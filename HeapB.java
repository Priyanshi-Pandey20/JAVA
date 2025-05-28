import java.util.*;
import java.util.ArrayList;

public class HeapB {

    static class Heap {
        static ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) { // add data to heap
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

        public int remove() { // remove the node frome heap
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

    static class Point implements Comparable<Point> { // nearest car
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

    static class Row implements Comparable<Row> { // Weakest solider
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

    public static void main(String[] args) {

        int[][] pts = { { 3, 3 }, { 5, -1 }, { -2, 4 } }; // nearest car
        int k = 2;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < pts.length; i++) {
            int disSq = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], disSq, i));

        }
        for (int i = 0; i < k; i++) {
            System.out.println(pq.remove().idx);
        }

        int[] ropes = { 2, 3, 3, 4, 6 }; // Connect N ropes
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

        int[][] army = { { 1, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 } }; // Weakest Soliders
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
         


    }

}
