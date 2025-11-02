package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Q14_DijkstraAlgoPQ {
    int[] shortestPath(int V, int src, List<List<int[]>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.dist - y.dist);
        int[] distAr = new int[V];
        Arrays.fill(distAr, (int) 1e9);
        distAr[src] = 0;

        pq.add(new Pair(0, src));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int dis = p.dist;
            int node = p.node;

            for (int[] it : adj.get(node)) {
                int adjNode = it[0];
                int edgeWt = it[1];

                if (dis + edgeWt < distAr[adjNode]) {
                    distAr[adjNode] = dis + edgeWt;
                    pq.add(new Pair(distAr[adjNode], adjNode));
                }
            }
        }

        return distAr;
    }

    public static void main(String[] args) {
        Q14_DijkstraAlgoPQ graph = new Q14_DijkstraAlgoPQ();

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

    class Pair {
        int dist;
        int node;

        Pair(int _dist, int _node) {
            this.dist = _dist;
            this.node = _node;
        }
    }
}
