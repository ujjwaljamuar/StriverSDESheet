package ShortestPath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PrintShortestPath {
    List<Integer> shortestPath(int V, int E, int[][] edges, int src, int desn) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        // add list for all vertices
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        // add all the edges
        for (int i = 0; i < E; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][2], edges[i][1]));
            adj.get(edges[i][1]).add(new Pair(edges[i][2], edges[i][0]));
        }

        // create distance and parent array to track V+1 for 1 indexing array
        int[] dist = new int[V+1];
        int[] parent = new int[V+1];
        for (int i = 1; i <= V; i++) {
            dist[i] = (int) 1e9;
            parent[i] = i;
        }

        // distance of source from itself
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.distance - y.distance);

        // start with source
        pq.add(new Pair(0, src));

        while (!pq.isEmpty()) {
            int dis = pq.peek().distance;
            int node = pq.peek().node;

            pq.remove();

            for (Pair it : adj.get(node)) {
                int adjNode = it.node;
                int adjNodeWt = it.distance;

                // if weight of new path is less than older, replace
                if (dis + adjNodeWt < dist[adjNode]) {
                    dist[adjNode] = dis + adjNodeWt;
                    pq.add(new Pair(dist[adjNode], adjNode));

                    // add parent node to track
                    parent[adjNode] = node;
                }
            }
        }

        List<Integer> path = new ArrayList<>();

        if (dist[desn] == (int) 1e9) {
            path.add(-1);
            return path;
        }

        int totalDistance = dist[desn];

        int node = desn;

        // backtrack to get the path in reverse order
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }

        // add source in the last
        path.add(src);

        System.out.println(totalDistance);

        // reverse the list
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        PrintShortestPath graph = new PrintShortestPath();
        int[][] edges = {
                { 1, 3, 1 },
                { 1, 2, 2 },
                { 2, 3, 3 },
                { 1, 8, 3 },
                { 8, 5, 1 },
                { 2, 4, 1 },
                { 4, 5, 2 },
                { 2, 6, 4 },
                { 6, 5, 1 },
                { 6, 7, 2 } };

        int totalVertices = 8, totalEdges = 10;
        int source = 1, destination = 6;

        System.out.println(graph.shortestPath(totalVertices, totalEdges, edges, source, destination));
    }

    class Pair {
        int distance, node;

        Pair(int _distance, int _node) {
            this.distance = _distance;
            this.node = _node;
        }
    }
}
