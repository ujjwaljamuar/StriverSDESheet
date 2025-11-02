package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Q16_DijkstraAlgoPath {
    ArrayList<Integer> shortestPath(int V, int src, int dest, ArrayList<ArrayList<int[]>> adj){
        int[] dist = new int[V];
        int[] parent = new int[V];

        for(int i = 0; i < V;i++){
            dist[i] = (int)1e9;
            parent[i] = i;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.dist - y.dist);

        dist[src] = 0;
        pq.add(new Pair(0, src));

        while(!pq.isEmpty()){
            Pair p = pq.poll();

            int node = p.node;
            int dis = p.dist;

            for(int it[]: adj.get(node)){
                int adjNode = it[0];
                int adjNodeWt = it[1];

                if(adjNodeWt + dis < dist[adjNode]){
                    dist[adjNode] = adjNodeWt + dis;
                    pq.add(new Pair(adjNodeWt + dis, adjNode));

                    parent[adjNode] = node;
                }
            }
        }

        ArrayList<Integer> path = new ArrayList<>();
        if(dist[dest] == (int)1e9){
            path.add(-1);
            return path;
        }

        int node = dest;
        while(parent[node] != node){
            path.add(node);
            node = parent[node];
        }

        path.add(node);
        Collections.reverse(path);

        return path;
    }
    public static void main(String[] args) {
        Q16_DijkstraAlgoPath graph = new Q16_DijkstraAlgoPath();
        int V = 5;

        // Adjacency list {neighbor, weight}
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // Example edges
        adj.get(0).add(new int[] { 1, 2 });
        adj.get(0).add(new int[] { 2, 4 });
        adj.get(1).add(new int[] { 2, 1 });
        adj.get(1).add(new int[] { 3, 7 });
        adj.get(2).add(new int[] { 4, 3 });
        adj.get(3).add(new int[] { 4, 2 });

        System.out.println(graph.shortestPath(V, 0, 3, adj));
    }

    class Pair{
        int dist;
        int node;

        Pair(int _dist, int _node){
            this.dist = _dist;
            this.node = _node;
        }
    }
}
