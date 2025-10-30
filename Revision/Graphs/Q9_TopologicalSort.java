package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

// Stack method will only work if there is guaranteed no cycle in the Graph

public class Q9_TopologicalSort {
    void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[node] = true;

        for (int it : adj.get(node)) {
            if (vis[it] == false) {
                dfs(it, vis, adj, st);
            }
        }

        st.push(node);
    }

    int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        int[] res = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                dfs(i, vis, adj, st);
            }
        }

        int i = 0;
        while (!st.isEmpty()) {
            res[i++] = st.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        Q9_TopologicalSort graph = new Q9_TopologicalSort();

        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        int[] ans = graph.topoSort(V, adj);
        System.out.println(Arrays.toString(ans));
    }
}
