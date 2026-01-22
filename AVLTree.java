import java.util.*;
public class AVLTree {
    static class Node { // node 
        int data, height;
        Node left, right;

        Node(int data) {
            this.data = data;
            height = 1;
        }
    }

    public static Node root;

    public static int height(Node root) { // height function method 

        if (root == null) {
            return 0;
        }
        return root.height;

    }

    public static Node rightRotate(Node y) { // right rotate method  
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    public static Node leftRotate(Node x) { // left rotate function 
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    public static int getBalance(Node root) { // get balance  function
        if (root == null) {
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    public static Node insert(Node root, int key) { // insertion  in the tree  in avl 
        if (root == null) {
            return new Node(key);
        }
        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        } else {
            return root;
        }
        root.height = 1 + Math.max(height(root.left), height(root.right));

        int bf = getBalance(root);

        if (bf > 1 && key < root.left.data) { // LL case
            return rightRotate(root);
        }
        if (bf < -1 && key > root.right.data) { // RR case
            return leftRotate(root);
        }
        if (bf > 1 && key > root.left.data) { // LR case
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (bf < -1 && key < root.right.data) { // RL case
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;

    }

    public static void preorder(Node root) { // preorder in avl 
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static Node getMinNode(Node root) { // deletion  in avl 
        Node curr = root;

        while (curr.left != null)
            curr = curr.left;
        return curr;

    }

    public static Node deleteNode(Node root, int key) { // delete node  from tree 

        if (root == null) {
            return root;
        }

        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        }

        else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null || root.right == null) {
                Node temp = null;
                if (temp == root.left) {
                    temp = root.right;
                } else
                    temp = root.left;

                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;

            } else {
                Node temp = getMinNode(root.left);//get min node function 
                root.data = temp.data;
                root.right = deleteNode(root.right, key);
            }

        }
        if (root == null)
            return root;

        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int bf = getBalance(root);

        if (bf > 1 && getBalance(root.left) >= 0) // when bf is greater function 
            return rightRotate(root);

        if (bf > 1 && getBalance(root.left) < 0) { // when bf is greater and less than 0
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (bf < -1 && getBalance(root.right) <= 0) // when bf is less than -1 
            return leftRotate(root);

        if (bf < -1 && getBalance(root.right) > 0) { // when bf is greater than 0 
            root.right = rightRotate(root.right);
            return leftRotate(root); //left rotation
        }

        return root;

    }
  //main function
    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root,50);
         root = insert(root,25);
        
        root = deleteNode(root, 50);
      
        

        preorder(root);

    }

}
