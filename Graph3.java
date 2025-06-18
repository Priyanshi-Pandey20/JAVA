import java.util.ArrayList;
import java.util.Stack;

public class Graph3 {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;

        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 2));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));

    }

    public static void topSort(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> s) { // Kosaraju
                                                                                                     // Algorithm
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSort(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis) {
        vis[curr] = true;
        System.out.println(curr + " ");
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }

    }

    public static void kosaraju(ArrayList<Edge>[] graph, int V) {
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topSort(graph, i, vis, st);
            }
        }
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for (int i = 0; i < graph.length; i++) {
            vis[i] = false;
            transpose[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        while (!st.isEmpty()) {
            int curr = st.pop();
            if (!vis[curr]) {
                dfs(transpose, curr, vis);

            }
        }

    }

    

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        kosaraju(graph, V);
    }
}
