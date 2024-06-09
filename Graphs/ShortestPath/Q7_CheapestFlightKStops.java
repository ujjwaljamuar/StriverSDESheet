package ShortestPath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q7_CheapestFlightKStops {
    int CheapestFLight(int n, int flights[][], int src, int dst, int k) {
        // Code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int m = flights.length;

        for (int i = 0; i < m; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = (int) 1e9;
        }

        cost[src] = 0;

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));

        while (!q.isEmpty()) {
            Tuple t = q.remove();

            int stops = t.stops;
            int node = t.node;
            int oldCost = t.cost;

            if (stops > k) {
                continue;
            }

            for (Pair it : adj.get(node)) {
                int adjNode = it.node;
                int adjCost = it.cost;

                if (oldCost + adjCost < cost[adjNode] && stops <= k) {
                    cost[adjNode] = oldCost + adjCost;

                    q.add(new Tuple(stops + 1, adjNode, cost[adjNode]));
                }
            }
        }

        if (cost[dst] == (int) 1e9) {
            return -1;
        }

        return cost[dst];
    }

    public static void main(String[] args) {
        Q7_CheapestFlightKStops graph = new Q7_CheapestFlightKStops();

        int n = 4, src = 0, dst = 3, K = 1;
        int[][] flights={{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};

        System.out.println(graph.CheapestFLight(n,flights,src,dst,K));
    }

    private class Tuple{
        int stops, node, cost;
        
        Tuple(int _stops, int _node, int _cost){
            this.stops = _stops;
            this.node = _node;
            this.cost = _cost;
        }
        
    }
    
    private class Pair{
        int node, cost;
        
        Pair(int _node, int _cost){
            this.node = _node;
            this.cost = _cost;
        }
    }
}
