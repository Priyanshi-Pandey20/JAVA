import java.util.*;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

public class BinaryTreesB {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int idx = -1;

    public static Node buildTree(int[] nodes) { // build a preorder tree
        idx++;
        if (nodes[idx] == -1) {
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;

    }

    public static void preorder(Node root) { // O(n) preorder traversal
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root) { // inorder traversal
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void postorder(Node root) { // postorder traversal
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrder(Node root) {// levelorder traversal
        if (root == null) {
            return;
        }
        java.util.Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    public static int HeightOfTree(Node root) {// heigth of tree
        if (root == null) {
            return 0;
        }
        int lh = HeightOfTree(root.left);
        int rh = HeightOfTree(root.right);
        int height = Math.max(lh, rh) + 1;
        return height;
    }

    public static int CountNodes(Node root) {// count nodes
        if (root == null) {
            return 0;
        }
        int lcount = CountNodes(root.left);
        int rcount = CountNodes(root.right);
        int total = lcount + rcount + 1;
        return total;
    }

    public static int SumOfNodes(Node root) { // sum of nodes
        if (root == null) {
            return 0;
        }
        int leftSum = SumOfNodes(root.left);
        int rightSum = SumOfNodes(root.right);
        int treeSum = leftSum + rightSum + root.data;
        return treeSum;

    }

    public static int DiameterOfTree(Node root) {// O(n^2) diameter of the tree(brute force approach)
        if (root == null) {
            return 0;
        }

        int ld = DiameterOfTree(root.left);
        int leftHt = HeightOfTree(root.left);
        int rd = DiameterOfTree(root.right);
        int rightHt = HeightOfTree(root.right);

        int selfDiameter = leftHt + rightHt + 1;
        return Math.max(selfDiameter, Math.max(ld, rd));
    }

    static class Info { // diamter of tree (optimized approach)
        int diam;
        int ht;

        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Info diameter(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info LeftInfo = diameter(root.left);
        Info RightInfo = diameter(root.right);

        int diam = Math.max(Math.max(LeftInfo.diam, RightInfo.diam), LeftInfo.ht + RightInfo.ht + 1);
        int ht = Math.max(LeftInfo.ht, RightInfo.ht) + 1;

        return new Info(diam, ht);

    }

    public static boolean isIdentical(Node node, Node subRoot) {

        if (node == null && subRoot == null) {
            return true;
        } else if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }
        if (!isIdentical(node.left, subRoot.left)) {
            return false;
        }
        if (!isIdentical(node.right, subRoot.right)) {
            return false;
        }
        return true;

    }

    public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }

        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

    static class Info1 { // diamter of tree (optimized approach)
        Node node;
        int hd;

        public Info1(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void TopViewOfTree(Node root) { // top view of tree
        Queue<Info1> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new Info1(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Info1 curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }
                if (curr.node.left != null) {
                    q.add(new Info1(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }
                if (curr.node.right != null) {
                    q.add(new Info1(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }

            }
        }
        for (int i = min; i <= max; i++) {
            System.out.println(map.get(i).data + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        TopViewOfTree(root);

    }
}
