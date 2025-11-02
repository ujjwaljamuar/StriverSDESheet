package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Q15DijkstraAlgoSet {
    int[] shortestPath(int V, int src, List<List<int[]>> adj) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;

        TreeSet<Pair> ts = new TreeSet<>();
        ts.add(new Pair(0, src));

        while (!ts.isEmpty()) {
            Pair p = ts.first();
            ts.remove(p);

            int node = p.node;
            int dis = p.dist;

            for (int[] it : adj.get(node)) {
                int adjNode = it[0];
                int edgeWt = it[1];

                if (dis + edgeWt < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWt;
                    ts.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Q15DijkstraAlgoSet graph = new Q15DijkstraAlgoSet();

        int V = 5;

        // Adjacency list {neighbor, weight}
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // Example edges
        adj.get(0).add(new int[] { 1, 2 });
        adj.get(0).add(new int[] { 2, 4 });
        adj.get(1).add(new int[] { 2, 1 });
        adj.get(1).add(new int[] { 3, 7 });
        adj.get(2).add(new int[] { 4, 3 });
        adj.get(3).add(new int[] { 4, 2 });

        System.out.println(Arrays.toString(graph.shortestPath(V, 0, adj)));
    }

    class Pair implements Comparable<Pair> {
        int dist, node;

        Pair(int _d, int _n) {
            this.dist = _d;
            this.node = _n;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.dist == other.dist) {
                return Integer.compare(this.node, other.node);
            }

            return Integer.compare(this.dist, other.dist);
        }
    }
}
