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

    public static void printPath(ArrayList<Integer> path) { // print the path from root to leaf node
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println();
    }

    public static void RootToLeafPath(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            printPath(path);
        }
        RootToLeafPath(root.left, path);
        RootToLeafPath(root.right, path);
        path.remove(path.size() - 1);

    }

    public static boolean isValidBST(Node root, Node min, Node max) { // check whether the bst is valid

        if (root == null) {
            return true;
        }
        if (min != null && root.data <= min.data) {
            return false;
        } else if (max != null && root.data >= max.data) {
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);

    }

    public static Node mirrorBST(Node root) { // invert BST
        if (root == null) {
            return null;
        }
        Node left = mirrorBST(root.left);
        Node right = mirrorBST(root.right);

        root.left = right;
        root.right = left;

        return root;

    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static Node convertArrayToBST(int[] arr, int st, int end) { // convert sorted array to BST
        if (st > end) {
            return null;
        }
        int mid = (st + end) / 2;
        Node root = new Node(arr[mid]);
        root.left = convertArrayToBST(arr, st, mid - 1);
        root.right = convertArrayToBST(arr, mid + 1, end);
        return root;
    }
    public static void preorder1(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data + " ");
        preorder1(root.left);
        preorder1(root.right);
    }


    public static void main(String[] args) {
        

        int[] arr = {3,5,6,8,10,11,14};
       Node root = convertArrayToBST(arr, 0, arr.length-1);
        preorder1(root);
    }
}
