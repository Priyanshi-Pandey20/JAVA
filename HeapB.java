import java.util.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class HeapB {

    static class Heap {
        static ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) { // add data to heap pblm
            arr.add(data);

            int x = arr.size() - 1;
            int par = (x - 1) / 2;

            while (arr.get(x) < arr.get(par)) {
                int temp = arr.get(x);
                // arr.set(x, arr.get(x));
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x - 1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;

            if (left < arr.size() && arr.get(left) < arr.get(minIdx)) {
                minIdx = left;
            }
            if (right < arr.size() && arr.get(right) < arr.get(minIdx)) {
                minIdx = right;
            }

            if (minIdx != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);
                heapify(minIdx);
            }
        }

        public int remove() { // remove the node frome heap pblm
            int temp = arr.get(0);
            int data = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);
            arr.remove(arr.size() - 1);
            heapify(0);
            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }

    }

    static class Point implements Comparable<Point> { // nearest car pblm
        int x;
        int y;
        int disSq;
        int idx;

        public Point(int x, int y, int disSq, int idx) {
            this.x = x;
            this.y = y;
            this.disSq = disSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2) {
            return this.disSq - p2.disSq;
        }
    }

    static class Row implements Comparable<Row> { // weakest soliders pblm 
        int soliders;
        int idx;

        public Row(int soliders, int idx) {
            this.soliders = soliders;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2) {
            if (this.soliders == r2.soliders) {
                return this.idx - r2.idx;
            } else {
                return this.soliders - r2.soliders;
            }
        }
    }

    static class Pair implements Comparable<Pair> { // sliding window pblm 
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2) {
            return p2.val - this.val;

        }
    }

    static class Node implements Comparable<Node> { // path with minimum efforts pblm 
        int row, col, effort;

        Node(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }

        public int compareTo(Node other) {
            return this.effort - other.effort;
        }
    }

    public static int minmumEfforstPath(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        boolean[][] vis = new boolean[rows][cols];

        int[] dr = { -1, 0, +1, 0 };
        int[] dc = { 0, +1, 0, -1 };

        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(0, 0, 0));

        while (q.size() != 0) {
            Node node = q.remove();
            int sr = node.row, sc = node.col;
            vis[sr][sc] = true;
            int effort = node.effort;

            if (sr == rows - 1 && sc == cols - 1)
                return effort;

            for (int idx = 0; idx < 4; idx++) {
                int nr = sr + dr[idx];
                int nc = sc + dc[idx];

                if (nr < 0 || nc < 0 || nr >= rows || nc >= cols)
                    continue;
                if (vis[nr][nc] == true)
                    continue;

                int diff = Math.abs(heights[nr][nc] - heights[sr][sc]);
                q.add(new Node(nr, nc, Math.max(effort, diff)));
            }
        }
        return 0;
    }

    static PriorityQueue<Integer> min1;
    /// kth largest element in stream of integer pblm
    static int p;

    static List<Integer> getAllKthNumbers(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int val : arr) {
            if (min1.size() < p) {
                min1.add(val);
            } else {
                if (val > min1.peek()) {
                    min1.poll();
                    min1.add(val);
                }
            }
            if (min1.size() >= p) {
                list.add(min1.peek());
            } else {
                list.add(-1);
            }
        }
        return list;
    }

    public static void minTime(int[] arr, int n, int k) { // min time required to fill n slots pblm 
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[n + 1];
        int time = 0;

        for (int i = 0; i < k; i++) {
            q.add(arr[i]);
            vis[arr[i]] = true;
        }
        while (q.size() > 0) {
            for (int i = 0; i < q.size(); i++) {
                int curr = q.poll();
                if (curr - 1 >= 1 && !vis[curr - 1]) {
                    vis[curr - 1] = true;
                    q.add(curr - 1);
                }
                if (curr + 1 <= n && !vis[curr + 1]) {
                    vis[curr + 1] = true;
                    q.add(curr + 1);
                }
            }
            time++;
        }
        System.out.println(time - 1);
    }

    static class ListNode { // merge k sorted list pblm
        int data;
        ListNode next;

        ListNode(int key) {
            data = key;
            next = null;
        }
    }

    static class ListNodeComparator implements Comparator<ListNode> {
        public int compare(ListNode k1, ListNode k2) {
            if (k1.data > k2.data) {
                return 1;
            } else if (k1.data < k2.data) {
                return -1;

            }
            return 0;

        }
    }

    static ListNode mergeKList(ListNode[] arr, int k) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new ListNodeComparator());
        int[] at = new int[k];
        ListNode head = new ListNode(0);
        ListNode last = head;

        for (int i = 0; i < k; i++) {
            if (arr[i] != null) {
                queue.add(arr[i]);
            }
        }
        if (queue.isEmpty()) {
            return null;
        }
        while (!queue.isEmpty()) {
            ListNode curr = queue.poll();
            last.next = curr;
            last = last.next;
            if (curr.next != null) {
                queue.add(curr.next);
            }

        }
        return head.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        int[][] pts = { { 3, 3 }, { 5, -1 }, { -2, 4 } }; // nearest car main function
        int k = 2;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < pts.length; i++) {
            int disSq = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], disSq, i));

        }
        for (int i = 0; i < k; i++) {
            System.out.println(pq.remove().idx);
        }

        int[] ropes = { 2, 3, 3, 4, 6 }; // Connect N ropes main function
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        for (int i = 0; i < ropes.length; i++) {
            pq1.add(ropes[i]);
        }

        int cost = 0;
        while (pq1.size() > 1) {
            int min = pq1.remove();
            int min2 = pq1.remove();

            cost += min + min2;
            pq1.add(min + min2);

        }
        System.out.println(cost);

        int[][] army = { { 1, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 } }; // Weakest Soliders main
                                                                                           // method

        int s = 2;
        PriorityQueue<Row> pq2 = new PriorityQueue<>();

        for (int i = 0; i < army.length; i++) {
            int count = 0;
            for (int j = 0; j < army[0].length; j++) {
                count += army[i][j] == 1 ? 1 : 0;
            }
            pq2.add(new Row(count, i));

        }
        for (int i = 0; i < s; i++) {
            System.out.println(pq2.remove().idx);

        }

        int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 }; // sliding window problem main method O(nlogk)
        int t = 3;

        int[] res = new int[arr.length - t + 1];
        PriorityQueue<Pair> pq3 = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq3.add(new Pair(arr[i], i));
        }
        res[0] = pq3.peek().val;
        for (int i = t; i < arr.length; i++) {
            while (pq3.size() > 0 && pq3.peek().idx <= (i - t)) {
                pq3.remove();
            }
            pq3.add(new Pair(arr[i], i));
            res[i - t + 1] = pq3.peek().val;
        }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();

        int[][] heights = { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } };
        int total = minmumEfforstPath(heights);
        System.out.println(total);

        min1 = new PriorityQueue<>();
        p = 3;
        int[] arr2 = { 1, 2, 3, 4, 5, 6 };
        List<Integer> res1 = getAllKthNumbers(arr2);
        for (int x : res1) {
            System.out.println(x);

        }
        System.out.println();

        int[] arr3 = { 2, 6 };
        int q = 6;
        int b = arr3.length;
        minTime(arr3, q, b);

        int N = 3;
        ListNode[] a = new ListNode[N];
        ListNode head1 = new ListNode(1);
        a[0] = head1;
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);
        head1.next.next.next = new ListNode(7);

        ListNode head2 = new ListNode(2);
        a[1] = head2;
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);
        head2.next.next.next = new ListNode(8);

        ListNode head3 = new ListNode(0);
        a[2] = head3;
        head3.next = new ListNode(9);
        head3.next.next = new ListNode(10);
        head3.next.next.next = new ListNode(11);

        ListNode mergedList = mergeKList(a, N);
        if (mergedList != null) {
            printList(mergedList);
            System.out.println();
        }

    }

}
