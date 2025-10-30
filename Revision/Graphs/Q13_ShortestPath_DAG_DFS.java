package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Q13_ShortestPath_DAG_DFS {
    void topoSort(int node, boolean[] vis, Stack<Integer> st, ArrayList<ArrayList<Pair>> adj) {
        vis[node] = true;

        for (Pair p : adj.get(node)) {
            int it = p.node;
            if (vis[it] == false) {
                topoSort(it, vis, st, adj);
            }
        }

        st.push(node);
    }

    int[] shortestPath(int N, int[][] edge) {
        // Create adj list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] it : edge) {
            int u = it[0];
            int v = it[1];
            int wt = it[2];

            adj.get(u).add(new Pair(v, wt));
        }

        // Perform topo sort
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (vis[i] == false) {
                topoSort(i, vis, st, adj);
            }
        }

        // flatten the stack
        int[] dist = new int[N];
        Arrays.fill(dist, (int) 1e9);

        dist[0] = 0;

        while (!st.isEmpty()) {
            int node = st.pop();

            for (Pair p : adj.get(node)) {
                int n = p.node;
                int wt = p.weight;

                if (dist[node] + wt < dist[n]) {
                    dist[n] = dist[node] + wt;
                }
            }
        }

        // Check for unvisited nodes
        for (int i = 0; i < N; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        Q13_ShortestPath_DAG_DFS graph = new Q13_ShortestPath_DAG_DFS();

        int n = 6, m = 7;
        int[][] edge = {
                { 0, 1, 2 },
                { 0, 4, 1 },
                { 4, 5, 4 },
                { 4, 2, 2 },
                { 1, 2, 3 },
                { 2, 3, 6 },
                { 5, 3, 1 }
        };

        System.out.println(Arrays.toString(graph.shortestPath(n, edge)));

    }

    class Pair {
        int node;
        int weight;

        Pair(int _node, int _weight) {
            this.node = _node;
            this.weight = _weight;
        }
    }
}
