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

    public static void getInorder(Node root, ArrayList<Integer> inorder) {// Convert BST to balanced BST
        if (root == null) {
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node createBST(ArrayList<Integer> inorder, int st, int end) {
        if (st > end) {
            return null;
        }
        int mid = (st + end) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder, st, mid - 1);
        root.right = createBST(inorder, mid + 1, end);
        return root;
    }

    public static Node convertBSTtoBalancedBST(Node root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);
        root = createBST(inorder, 0, inorder.size() - 1);
        return root;

    }

    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBST = 0;

    public static Info largestBST(Node root) { // find the largest BST
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false, size, min, max);
        }
        if (leftInfo.isBST && rightInfo.isBST) {
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);

    }

    public static int minDiffNode(Node root, int k) { // Find the kth closest element in BST
        int closest = root.data;
        while (root != null) {
            if (Math.abs(root.data - k) < Math.abs(closest - k)) {
                closest = root.data;
            }
            if (root.data > k) {
                root = root.left;
            } else if (root.data < k) {
                root = root.right;
            } else {
                break;
            }
        }
        return closest;
    }

    public static int findMin(Node root) { // Find minimum and maximum in BST
        if (root == null)
            return -1;
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

   
    public static int findMax(Node root) { // Function to find the maximum value
        if (root == null)
            return -1;
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    public static void main(String[] args) {

        Node root = new Node(9);
        root.left = new Node(4);
        root.right = new Node(17);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.left.right.left = new Node(5);

        System.out.println("Minimum value: " + findMin(root));
        System.out.println("Maximum value: " + findMax(root));

    }
}
