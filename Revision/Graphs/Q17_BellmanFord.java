package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class Q17_BellmanFord {
    /*
     * what if there exists a negative edge weight, dijkstra will run in infinite
     * loop
     * bellman ford helps there,
     * run iteration till V-1 on all edges, it will give you the shortest distance array, and if
     * even after there is a shortest distance
     * then its a negative cycle
     * TC - VxE - vertices times edges
     */

    int[] bellmanFord(int V, int src, ArrayList<ArrayList<Integer>> edges) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e8);
        dist[src] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);

                if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // check if there is still relaxation after V-1 to detect -ve cycle
        for (ArrayList<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);

            if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                return new int[]{-1};
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        Q17_BellmanFord graph = new Q17_BellmanFord();
        int V = 6;
        int S = 0;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>() {
            {
                add(new ArrayList<Integer>(Arrays.asList(3, 2, 6)));
                add(new ArrayList<Integer>(Arrays.asList(5, 3, 1)));
                add(new ArrayList<Integer>(Arrays.asList(0, 1, 5)));
                add(new ArrayList<Integer>(Arrays.asList(1, 5, -3)));
                add(new ArrayList<Integer>(Arrays.asList(1, 2, -2)));
                add(new ArrayList<Integer>(Arrays.asList(3, 4, -2)));
                add(new ArrayList<Integer>(Arrays.asList(2, 4, 3)));
            }
        };

        System.out.println(Arrays.toString(graph.bellmanFord(V, S, edges)));

    }
}
