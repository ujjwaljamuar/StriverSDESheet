package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Q18_MinimumSpanningTreeSum {
    int getSum(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj){
        int[] vis = new int[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.dist - y.dist);

        pq.add(new Pair(0, 0));
        int sum = 0;

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            int dis = p.dist;

            if(vis[node] == 1){
                continue;
            }

            vis[node] = 1;
            sum += dis;

            for(ArrayList<Integer> it:  adj.get(node)){
                int adjNode = it.get(0);
                int adjNWt = it.get(1);

                if(vis[adjNode] == 0){
                    pq.add(new Pair(adjNWt, adjNode));
                }
            }
        }

        return sum;
    }
    public static void main(String[] args) {
        Q18_MinimumSpanningTreeSum graph = new Q18_MinimumSpanningTreeSum();

        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }

        for (int i = 0; i < 6; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            ArrayList<Integer> tmp1 = new ArrayList<Integer>();
            ArrayList<Integer> tmp2 = new ArrayList<Integer>();
            tmp1.add(v);
            tmp1.add(w);

            tmp2.add(u);
            tmp2.add(w);

            adj.get(u).add(tmp1);
            adj.get(v).add(tmp2);
        }

        System.out.println(graph.getSum(V, adj));
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
