package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q3_BFS {
    ArrayList<Integer> getBFS(ArrayList<ArrayList<Integer>> adjList, int V, int startIndex) {
        boolean[] vis = new boolean[V];
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        // add starting node to queue and mark it visited
        q.add(startIndex);
        vis[startIndex] = true;

        while (!q.isEmpty()) {
            // take out from queue and add it to your bfs
            int node = q.poll();
            bfs.add(node);

            for (int it : adjList.get(node)) {
                // if not visited then add it to queue
                if (vis[it] == false) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }

        return bfs;
    }

    public static void main(String[] args) {
        Q3_BFS bfs = new Q3_BFS();

        // Adjacency List for the graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);

        System.out.println(bfs.getBFS(adj, 5, 4));
    }
}
