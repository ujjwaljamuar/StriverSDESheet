package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class ShortestPath {
    ArrayList<Integer> shortestPathUtil(int V, int src, int dest, ArrayList<ArrayList<Pair>> adj) {
        int[] dist = new int[V + 1];
        int[] parent = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            dist[i] = (int) 1e9;
            parent[i] = i;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.dis - y.dis);
        dist[src] = 0;
        pq.add(new Pair(0, src));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int node = p.node;
            int dis = p.dis;

            for (Pair it : adj.get(node)) {
                int adjNode = it.node;
                int edWt = it.dis;

                if (dis + edWt < dist[adjNode]) {
                    dist[adjNode] = dis + edWt;
                    pq.add(new Pair(dis + edWt, adjNode));
                    parent[adjNode] = node;
                }
            }
        }

        ArrayList<Integer> path = new ArrayList<>();
        if (dist[dest] == (int) 1e9) {
            path.add(-1);
            return path;
        }
        int n = dest;
        while (parent[n] != n) {
            path.add(n);
            n = parent[n];
        }
        path.add(n);
        Collections.reverse(path);

        return path;
    }

    ArrayList<Integer> shortestPath(int V, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        // 1 based indexing therefore <= V
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] it : edges) {
            adj.get(it[0]).add(new Pair(it[2], it[1]));
        }

        return shortestPathUtil(V, 4, 6, adj);
    }

    public static void main(String[] args) {
        ShortestPath graph = new ShortestPath();
        int V = 8;
        int[][] edges = {
                { 1, 2, 3 }, { 1, 3, 1 },
                { 2, 1, 3 }, { 2, 3, 1 }, { 2, 4, 4 }, { 2, 6, 5 },
                { 3, 1, 1 }, { 3, 2, 1 }, { 3, 5, 6 },
                { 4, 2, 4 }, { 4, 7, 5 }, { 4, 8, 6 },
                { 5, 3, 6 }, { 5, 6, 1 }, { 5, 7, 1 },
                { 6, 2, 5 }, { 6, 5, 1 },
                { 7, 4, 5 }, { 7, 5, 1 }, { 7, 8, 6 },
                { 8, 4, 6 }, { 8, 7, 6 }
        };

        System.out.println(graph.shortestPath(V, edges));
    }

    class Pair {
        int dis;
        int node;

        Pair(int _dist, int _node) {
            this.dis = _dist;
            this.node = _node;
        }
    }
}
