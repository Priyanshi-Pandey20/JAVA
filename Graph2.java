import java.util.*;
import java.util.LinkedList;

public class Graph2 {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;

        }
    }

    static void createGraph1(int[][] flights, ArrayList<Edge> graph[]) { // create a graph
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();

        }
        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];
            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }

    }

    public static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, String path) { // print all paths from
                                                                                                // source to target
        if (src == dest) {
            System.out.println(path + dest);
            return;
        }
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            printAllPaths(graph, e.dest, dest, path + src);
        }
    }

    static class Pair implements Comparable<Pair> { // Dijkstra Algorithm
        int n;
        int path;

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public static void dijkstra(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.n]) {
                vis[curr.n] = true;
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void bellmanFord(ArrayList<Edge>[] graph, int src) { // Bellman Ford Algorithm
        int[] dist = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        int V = graph.length;

        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;

                    }

                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.println(dist[i]);
        }
        System.out.println();
    }

    static class Pair1 implements Comparable<Pair1> { // Prims Algorithm
        int v;
        int cost;

        Pair1(int v, int c) {
            this.v = v;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair1 p2) {
            return this.cost - p2.cost;
        }

    }

    public static void prims(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair1> pq = new PriorityQueue<>();

        pq.add(new Pair1(0, 0));
        int finalCost = 0;

        while (!pq.isEmpty()) {
            Pair1 curr = pq.remove();
            if (!vis[curr.v]) {
                vis[curr.v] = true;
                finalCost += curr.cost;

                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair1(e.dest, e.wt));
                }

            }
        }

        System.out.println(finalCost);

    }

    static class Info { // cheapest flights with K spots
        int v;
        int cost;
        int stops;

        public Info(int v, int c, int s) {
            this.v = v;
            this.cost = c;
            this.stops = s;

        }

    }

    public static int cheapestFlight(int n, int[][] flights, int src, int dest, int k) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph1(flights, graph);

        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();

            if (curr.stops > k) {
                break;
            }
            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if (curr.cost + wt < dist[v] && curr.stops <= k) {
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }
        if (dist[dest] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[dest];
        }

    }

    static class Edge1 implements Comparable<Edge1> { // connect cities with minimum cost

        int dest;
        int cost;

        public Edge1(int d, int c) {

            this.dest = d;
            this.cost = c;

        }

        @Override
        public int compareTo(Edge1 e2) {
            return this.cost - e2.cost;
        }
    }

    public static int connectCities(int[][] cities) {
        PriorityQueue<Edge1> pq = new PriorityQueue<>();

        boolean[] vis = new boolean[cities.length];

        pq.add(new Edge1(0, 0));
        int finalCost = 0;

        while (!pq.isEmpty()) {
            Edge1 curr = pq.remove();
            if (!vis[curr.dest]) {
                vis[curr.dest] = true;
                finalCost += curr.cost;

                for (int i = 0; i < cities[curr.dest].length; i++) {
                    if (cities[curr.dest][i] != 0) {
                        pq.add(new Edge1(i, cities[curr.dest][i]));
                    }
                }
            }
        }
        return finalCost;

    }

    static int n = 7; // Disjoint set
    static int[] par = new int[n];
    static int[] rank = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }
        return find(par[x]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;

        } else {
            par[parB] = parA;

        }
    }

    static class Edge2 implements Comparable<Edge2> { // Kruskal's Algorithm
        int src;
        int dest;
        int wt;

        public Edge2(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public int compareTo(Edge2 e2) {
            return this.wt - e2.wt;
        }

    }

    static void createGraph1(ArrayList<Edge2> edges) {
        edges.add(new Edge2(0, 1, 10));
        edges.add(new Edge2(0, 2, 15));
        edges.add(new Edge2(0, 3, 30));
        edges.add(new Edge2(1, 3, 40));
        edges.add(new Edge2(2, 3, 50));

    }
   static int m = 4;
   static int p[] = new int[m];
   static int rank1[] = new int[m];

   public static void init1(){
    for(int i =0;i<m;i++){
        par[i] = i;
    }
   }

   public static int find1(int x) {
        if (x == par[x]) {
            return x;
        }
        return find1(par[x]);
    }

     public static void union1(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;

        } else {
            par[parB] = parA;

        }
    }

    public static void KruskalMST(ArrayList<Edge2> edges,int V){
        init1();
        Collections.sort(edges);
        int mstCost = 0;
        int count = 0;

        for(int i =0; count<V-1;i++){
            Edge2 e = edges.get(i);

            int parA = find(e.src);
            int parB = find(e.dest);
            if(parA != parB){
              union(e.src, e.dest);
              mstCost +=e.wt;
              count++;
            }
        }
        System.out.println(mstCost);
    }

    





    


    


    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge2> edges = new ArrayList<>();
        createGraph1(edges);
        KruskalMST(edges, V);

        int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0;
        int dest = 3;
        int k = 1;
        System.out.println(cheapestFlight(n, flights, src, dest, k));

        int[][] cities = {
                { 0, 1, 2, 3, 4 },
                { 1, 0, 5, 0, 7 },
                { 2, 5, 0, 6, 0 },
                { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 }
        };
        System.out.println(connectCities(cities));





    }
}
