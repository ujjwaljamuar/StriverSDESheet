package ShortestPath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Q3_ShortestPathPrint {
    List<Integer> shortestPath(int n, int m, int edges[][]) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][2], edges[i][1]));
            adj.get(edges[i][1]).add(new Pair(edges[i][2], edges[i][0]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);

        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            dist[i] = (int) 1e9;
            parent[i] = i;
        }

        // 1 is the starting point
        dist[1] = 0;
        pq.add(new Pair(0, 1));

        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int dis = pq.peek().distance;

            pq.remove();

            for (Pair it : adj.get(node)) {
                int adjNode = it.node;
                int edw = it.distance;

                if (edw + dis < dist[adjNode]) {
                    dist[adjNode] = edw + dis;
                    pq.add(new Pair(dist[adjNode], adjNode));
                    parent[adjNode] = node;
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        if (dist[n] == 1e9) {
            path.add(-1);
            return path;
        }

        int node = n;
        int totalDistance = dist[n];

        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }

        path.add(1);
        Collections.reverse(path);

        System.out.println("Total distance => " + totalDistance);
        return path;
    }

    public static void main(String[] args) {
        Q3_ShortestPathPrint graph = new Q3_ShortestPathPrint();

        int[][] edges = { { 1, 2, 2 }, { 2, 5, 5 }, { 2, 3, 4 }, { 1, 4, 1 }, { 4, 3, 3 }, { 3, 5, 1 } };
        int n = 5, m = 6;

        System.out.println(graph.shortestPath(n, m, edges));


    }

    class Pair {
        int distance, node;

        Pair(int _dist, int _node) {
            this.distance = _dist;
            this.node = _node;
        }
    }
}
