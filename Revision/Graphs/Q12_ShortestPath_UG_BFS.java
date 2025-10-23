package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * use a dist arr filled with infinity then put 0 for src node and
 * use a queue, put source into the queue, then start polling
 * and keep adding dist[node] + 1 < dist[it] and 
 * add it in queue
 */

public class Q12_ShortestPath_UG_BFS {
    int[] shortestDistBFS(int N, ArrayList<ArrayList<Integer>> adj) {
        int[] dist = new int[N];
        Arrays.fill(dist, (int) 1e9);

        dist[0] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int it : adj.get(node)) {
                if (dist[node] + 1 < dist[it]) {
                    dist[it] = dist[node] + 1;
                    q.add(it);
                }
            }
        }

        // update unreachable nodes
        for (int i = 0; i < N; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        Q12_ShortestPath_UG_BFS graph = new Q12_ShortestPath_UG_BFS();

        int N = 9, m = 10;
        int[][] edges = { { 0, 1 }, { 0, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 1, 2 }, { 2, 6 }, { 6, 7 }, { 7, 8 },
                { 6, 8 } };

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        System.out.println(Arrays.toString(graph.shortestDistBFS(N, adj)));
    }
}
