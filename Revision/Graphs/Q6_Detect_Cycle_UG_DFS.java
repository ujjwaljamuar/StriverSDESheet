package Graphs;
// package Revision;

import java.util.ArrayList;
import java.util.List;

public class Q6_Detect_Cycle_UG_DFS {
    boolean detectCycleDFS(int node, int parent, List<List<Integer>> adjList, boolean[] vis) {
        vis[node] = true;

        for (int it : adjList.get(node)) {
            if (vis[it] == false) {
                if (detectCycleDFS(it, node, adjList, vis) == true) {
                    return true;
                }
            }
            // node is not parent and already visited
            else if (it != parent) {
                return true;
            }
        }

        return false;
    }

    boolean detectCycle(List<List<Integer>> adjList, int startIndex, int n) {
        boolean[] vis = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            if (vis[i] == false) {
                if (detectCycleDFS(startIndex, -1, adjList, vis) == true) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Q6_Detect_Cycle_UG_DFS graph = new Q6_Detect_Cycle_UG_DFS();
        int[][] edges = {
                { 1, 2 },
                { 2, 5 },
                { 5, 7 },
                { 1, 3 },
                { 3, 4 },
                { 3, 6 },
                { 6, 7 }
        };

        int n = 7;
        int startIndex = 1;

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] it : edges) {
            int u = it[0];
            int v = it[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // System.out.println(adjList);
        System.out.println(graph.detectCycle(adjList, startIndex, n));

    }
}
