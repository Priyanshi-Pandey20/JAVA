
import java.util.*;
import java.util.Arrays;

class Node {

    Node[] children;
    boolean isEnd;

    Node() {
        children = new Node[26];
        isEnd = false;
    }
}

class Trie {
    static void insert(Node root, String s) {  // insertion in trie
        Node curr = root;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (curr.children[s.charAt(i) - 'a'] == null) {
                curr.children[s.charAt(i) - 'a'] = new Node();
            }
            curr = curr.children[s.charAt(i) - 'a'];
        }
        curr.isEnd = true;

        return;
    }

    static boolean search(Node root,String s){
        Node curr = root;
        int n = s.length();

        for(int i =0;i<n;i++){
            if(curr.children[s.charAt(i)-'a'] == null){
                return false;
            }
            curr = curr.children[s.charAt(i)-'a'];
        }
        return curr.isEnd;
    }
    public static void main(String[] args) {
        Node root = new Node();
        List<String> inputArr = Arrays.asList("abc", "adc", "abd", "bcd", "dca");
        List<String> targetArr = Arrays.asList("abz", "bcr", "abd", "ab");

        for (String s : inputArr) {
            insert(root,s);
        }
        for(String s: targetArr){
            if(search(root,s)){
                System.out.println(s + " word exists");
            }
        }

    }
}
