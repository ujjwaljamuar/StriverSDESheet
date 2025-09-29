package Graphs;

import java.util.ArrayList;

public class Q4_DFS {
    void dfs(int startIndex, ArrayList<ArrayList<Integer>> adjList, ArrayList<Integer> dfs, boolean[] vis) {
        vis[startIndex] = true;
        dfs.add(startIndex);

        for (int it : adjList.get(startIndex)) {
            if (vis[it] == false) {
                dfs(it, adjList, dfs, vis);
            }
        }
    }

    ArrayList<Integer> getDFS(int startIndex, int V, ArrayList<ArrayList<Integer>> adjList) {
        boolean[] vis = new boolean[V]; // for 0 based indexing else V+1
        ArrayList<Integer> dfs = new ArrayList<>();
        dfs(startIndex, adjList, dfs, vis);

        return dfs;
    }

    public static void main(String[] args) {
        Q4_DFS dfs = new Q4_DFS();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);

        int startIndex = 0;
        int V = adj.size();

        System.out.println(dfs.getDFS(startIndex, V, adj));

    }
}
