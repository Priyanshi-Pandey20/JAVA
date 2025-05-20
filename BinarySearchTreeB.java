import java.util.*;
public class BinarySearchTreeB {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            root.left = insert(root.left, val);

        } else {
            root.right = insert(root.right, val);
        }
        return root;

    }

    public static void inorder(Node root) { // inorder traversal
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean search(Node root, int key) { // search element in tree
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        } else if (root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }

    }

    public static Node DeleteNode(Node root, int val) { // delete node from tree
        if (root.data < val) {
            root.right = DeleteNode(root.right, val);
        } else if (root.data > val) {
            root.left = DeleteNode(root.left, val);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            DeleteNode(root.right, IS.data);
        }
        return root;

    }

    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;

    }

    public static void printInRange(Node root, int k1, int k2) { // print all the numbers in a given range
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.println(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }

    }

    public static void printPath(ArrayList<Integer>path){ // print the path 
        for(int i =0;i<path.size();i++){
            System.out.print(path.get(i) + "->");
        }
        System.out.println();
    }

    public static void RootToLeafPath(Node root,ArrayList<Integer>path){
       if(root == null){
        return;
       }
        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }
        RootToLeafPath(root.left, path);
        RootToLeafPath(root.right, path);
        path.remove(path.size()-1);



    }

    public static void main(String[] args) {
        int[] val = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < val.length; i++) {
            root = insert(root, val[i]);
        }
        RootToLeafPath(root, new ArrayList<>());
    }
}
