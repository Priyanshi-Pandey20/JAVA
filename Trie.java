
import java.util.*;
import java.util.Arrays;

class Trie {

    static class Node {

        Node[] children = new Node[26];;
        boolean isEnd = false;
        char data;
        String word;
        int freq;

        public Node() {

            for (int i = 0; i < children.length; i++) {
                children[i] = null;

            }
            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) { // insert node in trie
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            } else {
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];

        }
        curr.isEnd = true;
    }

    public static boolean search(String key) { // O(n) search the key in trie
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.isEnd == true;
    }

    public static boolean wordBreak(String s) { // word break problem
        if (s.length() == 0) {
            return true;
        }
        for (int i = 1; i <= s.length(); i++) {
            if (search(s.substring(0, i)) && wordBreak(s.substring(i))) {
                wordBreak(s.substring(i));
                return true;
            }
        }
        return false;
    }

    public static void shortestUniquePrefix(Node root, String ans) { // prefix problem O(L) L = levels
        if (root == null) {
            return;
        }
        if (root.freq == 1) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null) {
                shortestUniquePrefix(root.children[i], ans + (char) (i + 'a'));
            }

        }

    }

    public static boolean startsWith(String prefix) { // check whether the given whole prefix is present in trie or not
        Node curr = root;

        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static int countUniqueSubtrings(Node root) { // count all the unique substrings in trie
        if (root == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countUniqueSubtrings(root.children[i]);
            }
        }
        return count + 1;
    }

    public static String ans = ""; // longest word of all prefixes

    public static void longestWord(Node root, StringBuilder temp) {

        if (root == null) {
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].isEnd == true) {
                char ch = (char) (i + 'a');
                temp.append(ch);
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }

    }

    public static void main(String[] args) {

        // String[] arr = { "zebra", "dog", "duck", "dove" };
        // for (int i = 0; i < arr.length; i++) {
        // insert(arr[i]);
        // }
        // root.freq = -1;
        // shortestUniquePrefix(root, "");

        String word[] = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        for (int i = 0; i < word.length; i++) {
            insert(word[i]);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);

    }
}
