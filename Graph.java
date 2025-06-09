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

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) { // create a graph
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();

        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));

    }

    public static void bfs(ArrayList<Edge>[] graph) { // Breadth First Search Traversal
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
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

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean vis[]) {
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) { // find if the path exists
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


    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj){ // Topological sort            
        int n = adj.size();
        int[] indegree = new int[n];

        for(int curr =0;curr<n;curr++){
            for(int conn : adj.get(curr)){
                indegree[conn]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i =0;i<n;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(q.size()>0){
            int curr = q.remove();
            ans.add(curr);

            for(int conn: adj.get(curr)){
                indegree[conn]--;
                if(indegree[conn] == 0){
                    q.add(conn);
                }
            }
        }
        return ans;
    }

    
    public static boolean validAlienDictionary(String[] arr,int k){ // Alien Dictionary problem
      int indegree[] = new int[26];
      ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

      for(int i =0;i<26;i++){
        adj.add(new ArrayList<Integer>());
      }
      for(int i =0;i<arr.length-1;i++){
        String word1 = arr[i];
        String word2 = arr[i+1];

        for(int j =0;j<Math.min(word1.length(),word2.length());j++){
            char ch1 = word1.charAt(j);
            char ch2 = word2.charAt(j);

            if(ch1!= ch2){
                adj.get(ch1-'a').add(ch2-'a');
                indegree[ch2 - 'a']++;
                break;
            }
        }
      }
      Queue<Integer> q = new LinkedList<>();

      for(int i =0;i<k;i++){
        if(indegree[i] == 0){
            q.add(i);
        }
    }
      ArrayList<Integer> ans = new ArrayList<>();

      while(q.size()>0){
        int curr = q.poll();

        ans.add(curr);

        for(int i =0;i<adj.get(curr).size();i++){
            int conn = adj.get(curr).get(i);
            indegree[conn]--;

            if(indegree[conn] == 0){
                q.add(conn);
            }
        }
    
      }
      if(ans.size() == k){
        return true;
      }
      else{
        return false;
      }

    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        int nodes = 4;
        for (int i = 0; i < nodes; i++)
            adj.add(new ArrayList<>());
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(0);
        adj.get(0).add(3);
        System.out.println(detectTheCycle(adj));

        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);
       String[] arr = {"cat","bat","mat","act"};
       System.out.println(validAlienDictionary(arr,4 ));

    }

}
