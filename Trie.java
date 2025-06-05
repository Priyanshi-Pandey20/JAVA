
import java.util.*;
import java.util.Arrays;

class Trie {

    static class Node {

        Node[] children = new Node[26];;
        boolean isEnd = false;
        int freq;

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;

            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) { // insert node in trie
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
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
        if(s.length() == 0){
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

  
    public static void main(String[] args) {

        String[] arr = { "i", "like", "sam", "samsung", "mobile", "ice" };
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
        String s = "ilikesung";
        System.out.println(wordBreak(s));

    }
}
