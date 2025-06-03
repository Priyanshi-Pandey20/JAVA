import java.util.*;
import java.util.LinkedList;

class Pair {
    int first, second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

}

public class Graph {

    public static boolean detectTheCycle(List<List<Integer>> adj) { // detect the cycle in undirected grapgh
        int n = adj.size();
        int vis[] = new int[n];

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                if (bfsCycleCheck(i, vis, adj))
                    return true;
            }
        }
        return false;
    }

    private static boolean bfsCycleCheck(int start, int[] vis, List<List<Integer>> adj) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, -1));
        vis[start] = 1;

        while (!q.isEmpty()) {
            Pair currPair = q.remove();
            int curr = currPair.first;
            int parent = currPair.second;

            for (int conn : adj.get(curr)) {
                if (vis[conn] == 0) {
                    vis[conn] = 1;
                    q.add(new Pair(conn, curr));
                } else if (conn != parent) {
                    return true; // cycle found
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
         List<List<Integer>> adj = new ArrayList<>();
        int nodes = 4;
        for (int i = 0; i < nodes; i++) adj.add(new ArrayList<>());
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(0);
        adj.get(0).add(3);
        System.out.println(detectTheCycle(adj));
    }

}
