
import java.util.*;
import java.util.Arrays;

class Trie {

    static class Node {

        Node[] children = new Node[26];;
        boolean isEnd = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;

            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {  // insert node in trie
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

    public static boolean search(String key){  //O(n)  search the key in trie
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

    

    public static void main(String[] args) {
        Node root = new Node();
        String[] word = {"the","a","there","their","any","three"};
        for(int i =0; i<word.length;i++){
              insert(word[i]);
        }
        System.out.println(search("there"));
        System.out.println(search("thor"));

    }
}
