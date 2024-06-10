package ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Q8_NumberOfWays {
    int countWays(int n, int[][] roads){
        int m = roads.length;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][2], roads[i][1]));
            adj.get(roads[i][1]).add(new Pair(roads[i][2], roads[i][0]));
        }

        int[] dist = new int[n];
        int[] ways = new int[n];

        Arrays.fill(dist, (int) 1e9);
        Arrays.fill(ways, 0);
        
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.distance - y.distance);

        pq.add(new Pair(0, 0));

        int mod = (int) 1e9 + 7;

        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int dis = pq.peek().distance;

            pq.remove();

            for(Pair it: adj.get(node)){
                int adjNode = it.node;
                int adjDis = it.distance;

                // if visits for first time
                if(dis + adjDis < dist[adjNode]){
                    dist[adjNode] = dis + adjDis;
                    pq.add(new Pair(dist[adjNode], adjNode));

                    ways[adjNode] = ways[node];
                }

                else if(dis + adjDis == dist[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        
        return ways[n-1] % mod;
    }
    public static void main(String[] args) {
        Q8_NumberOfWays graphs = new Q8_NumberOfWays();

        int[][] roads = {
            {0, 6, 7},
            {0, 1, 2},
            {1, 2, 3},
            {1, 3, 3},
            {6, 3, 3},
            {3, 5, 1},
            {6, 5, 1},
            {2, 5, 1},
            {0, 4, 5},
            {4, 6, 2}
        };
        
        int n = 7;

        System.out.println(graphs.countWays(n, roads));
    }

    private class Pair{
        int distance, node;

        Pair(int _d, int _n){
            this.distance = _d;
            this.node = _n;
        }
    }
}
