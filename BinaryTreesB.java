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

    public static int HeightOfTree(Node root) {// heigth of tree of the binary tree 
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

    public static boolean isIdentical(Node node, Node subRoot) { // is subtree is a subtree of tree

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

    public static void KthLevelOfTree(Node root, int level, int k) { // print the nodes of given level
        if (root == null) {
            return;
        }
        if (level == k) {
            System.out.println(root.data + " ");
            return;
        }
        KthLevelOfTree(root.left, level + 1, k);
        KthLevelOfTree(root.right, level + 1, k);

    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path) { // lowest common ancester
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root.data == n) {
            return true;
        }
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if (foundLeft || foundRight) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    public static Node LowestCommonAncester(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }
        Node LowestCommonAncester = path1.get(i - 1);
        return LowestCommonAncester;

    }

    public static Node lca(Node root, int n1, int n2) { // O(n) lowest common ancester (optimized approach)
        if (root == null) {
            return null;
        }
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        Node leftlca = lca(root.left, n1, n2);
        Node rightlca = lca(root.right, n1, n2);

        if (leftlca == null) {
            return rightlca;
        }
        if (rightlca == null) {
            return leftlca;
        }
        return root;

    }

    public static int lcaDist(Node root, int n) { // minimum distance between two nodes
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }
        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        } else if (leftDist == -1) {
            return rightDist + 1;
        } else {
            return leftDist + 1;
        }

    }

    public static int MinimumDistance(Node root, int n1, int n2) {
        Node lca = lca(root, n1, n2);
        int dis1 = lcaDist(lca, n1);
        int dis2 = lcaDist(lca, n2);

        return dis1 + dis2;
    }

    public static int KAncestor(Node root, int n, int k) { // kth ancester for node using distance
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }
        int leftDist = KAncestor(root.left, n, k);
        int rightDist = KAncestor(root.right, n, k);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }
        int max = Math.max(leftDist, rightDist);
        if (max + 1 == k) {
            System.out.println(root.data);
        }
        return max + 1;
    }

    public static int TransformToSumTree(Node root) { // transform the tree to sum tree 
        if (root == null) {
            return 0;
        }
        int leftChild = TransformToSumTree(root.left);
        int rightChild = TransformToSumTree(root.right);
        int data = root.data;
        int newLeft = root.left == null ? 0 : root.left.data;
        int newright = root.left == null ? 0 : root.right.data;

        root.data = newLeft + leftChild + newright + rightChild;
        return data;

    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static boolean IsUnivaluedTree(Node root) { // check whether all nodes contains same value
        if (root == null) {
            return true;
        }
        if (root.left != null && root.data != root.left.data) {
            return false;
        }
        if (root.right != null && root.data != root.right.data) {
            return false;
        }
        return IsUnivaluedTree(root.left) && IsUnivaluedTree(root.right);

    }

    public static Node mirror(Node root) { // create Mirror image if the tree pblm 
        if (root == null) {
            return root;
        }

        Node left = mirror(root.left);
        Node right = mirror(root.right);

        root.left = right;
        root.right = left;
        return root;

    }

    public static void InOrder(Node root) {
        if (root == null) {
            return;
        }

        InOrder(root.left);
        System.out.print(root.data + " ");
        InOrder(root.right);
    }

    public static Node DeleteLeaFNodes(Node root, int x) { // delete all the leaf nodes with a given target pblm 
        if (root == null) {
            return null;
        }
        root.left = DeleteLeaFNodes(root.left, x);
        root.right = DeleteLeaFNodes(root.right, x);

        if (root.data == x && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    static class Result { // maximum path sum  pblm 
        int maxSum;

    }

    public static int maxSum(Node root, Result result) { // max sum  pblm
        if (root == null) {
            return 0;
        }
        int leftSum = maxSum(root.left, result);
        int rightSum = maxSum(root.right, result);

        int maxSinglePath = Math.max(Math.max(leftSum, rightSum) + root.data, root.data);
        int maxTop = Math.max(maxSinglePath, leftSum + rightSum + root.data);

        result.maxSum = Math.max(result.maxSum, maxTop);
        return maxSinglePath;

    }

    public static int findMaxSum(Node root) { // find max sum
        Result result = new Result();
        result.maxSum = Integer.MIN_VALUE;
        maxSum(root, result);
        return result.maxSum;
    }

    public static int countLeafNodes(Node root) { // count all the leaf nodes
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        return countLeafNodes(root.left) + countLeafNodes(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(countLeafNodes(root));
    }
}
