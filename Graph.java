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
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;

        }
    }

    static void createGraph(ArrayList<Edge> graph[]) { // create a graph
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();

        }
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
         graph[4].add(new Edge(4, 1));


        graph[5].add(new Edge(5, 0));
         graph[5].add(new Edge(5, 2));


    }

    public static void bfs(ArrayList<Edge>[] graph) {// Breadth First Search Traversal
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                bfsUtil(graph, vis);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge>[] graph, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                System.out.println(curr + " ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph) { // depth first traversal
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                dfsUtil(graph, i, vis);
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean vis[]) {
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfsUtil(graph, e.dest, vis);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) { // find if the path
                                                                                               // exists

        if (src == dest) {
            return true;
        }
        vis[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);

            if (!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) {
                return true;
            }
        }
        return false;
    }

    public static boolean detectTheCycle(List<List<Integer>> adj) { // detect the cycle in undirected graph
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

    public static boolean detectCycleInDirectedGraph(ArrayList<Edge>[] graph) { // detect cycle in directed graph
        boolean[] vis = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycleUtil(graph, i, vis, stack)){
                return true;
                }
            }
        }
        return false;

    }
    public static boolean isCycleUtil(ArrayList<Edge>[] graph,int curr,boolean[] vis,boolean[] stack){
        vis[curr] = true;
        stack[curr] = true;

        for(int i =0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(stack[e.dest]){
                return true;
            }
            if(!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)){
            return true;
            }
        }
        return false;
    }

    

    public static boolean validAlienDictionary(String[] arr, int k) { // Alien Dictionary problem
        int indegree[] = new int[26];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < arr.length - 1; i++) {
            String word1 = arr[i];
            String word2 = arr[i + 1];

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);

                if (ch1 != ch2) {
                    adj.get(ch1 - 'a').add(ch2 - 'a');
                    indegree[ch2 - 'a']++;
                    break;
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();

        while (q.size() > 0) {
            int curr = q.poll();

            ans.add(curr);

            for (int i = 0; i < adj.get(curr).size(); i++) {
                int conn = adj.get(curr).get(i);
                indegree[conn]--;

                if (indegree[conn] == 0) {
                    q.add(conn);
                }
            }

        }
        if (ans.size() == k) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean isBipartiteGraph(ArrayList<Edge>[] graph) { // check whether the given graph is bipartite or
                                                                      // not

        int col[] = new int[graph.length];
        for (int i = 0; i < col.length; i++) {
            col[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) {
                q.add(i);
                col[i] = 0;
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if (col[e.dest] == -1) {
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        } else if (col[e.dest] == col[curr]) {
                            return false;
                        }
                    }
                }
            }

        }
        return true;

    }

    public static void topSort(ArrayList<Edge>[] graph){ // topological sort
        boolean[] vis = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i = 0;i<graph.length;i++){
            if(!vis[i]){
                topSortUtil(graph,i,vis,s);
            }
        }
        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }

    public static void topSortUtil(ArrayList<Edge>[] graph,int curr,boolean[] vis,Stack<Integer> s){
       vis[curr] = true;
       for(int i = 0;i< graph[curr].size();i++){
        Edge e = graph[curr].get(i);
        if(!vis[e.dest]){
            topSortUtil(graph, e.dest, vis, s);
        }
       }
       s.push(curr);
    }
    public static void calculateIndegree(ArrayList<Edge> graph[],int indeg[]){// kahn's algorithm 
        
        for(int i =0;i<graph.length;i++){
            int v = i;
            for(int j =0;j<graph[v].size();j++){
                Edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void kahnAlogrithm(ArrayList<Edge>graph[]){
        int[] indeg = new int[graph.length];
        calculateIndegree(graph, indeg);
        Queue<Integer> q  = new LinkedList<>();

        for(int i =0;i<indeg.length;i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+ " ");

            for(int i =0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest] == 0){
                    q.add(e.dest);
                }
            }

        }
        System.out.println();

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // int nodes = 4;
        // for (int i = 0; i < nodes; i++)
        //     adj.add(new ArrayList<>());
        // adj.get(0).add(1);
        // adj.get(1).add(0);
        // adj.get(1).add(2);
        // adj.get(2).add(1);
        // adj.get(2).add(3);
        // adj.get(3).add(2);
        // adj.get(3).add(0);
        // adj.get(0).add(3);
       // System.out.println(detectTheCycle(adj));

        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);
    kahnAlogrithm(graph);

    }

}
