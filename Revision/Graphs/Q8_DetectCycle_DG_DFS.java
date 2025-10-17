package Graphs;

import java.util.ArrayList;

public class Q8_DetectCycle_DG_DFS {
    boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathVis) {
        vis[node] = 1;
        pathVis[node] = 1;

        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                if (dfsCheck(it, adj, vis, pathVis) == true) {
                    return true;
                }
            }

            else if (pathVis[it] == 1) {
                return true;
            }
        }

        pathVis[node] = 0;
        return false;
    }

    boolean checkCycleDGDFS(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V + 1];
        int[] pathVis = new int[V + 1];

        for (int i = 0; i < V; i++) {
            if (dfsCheck(i, adj, vis, pathVis) == true) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Q8_DetectCycle_DG_DFS graph = new Q8_DetectCycle_DG_DFS();

        int V = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);

        System.out.println(graph.checkCycleDGDFS(V, adj));
    }
}
