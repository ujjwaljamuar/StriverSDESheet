package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q10_TopologicalSort_BFS_KahnsAlgo {
    /*
     * use indegrees to put in queue, 
     * 0 indegrees will be first to go
     */
    int[] topoSortBFS(int V, ArrayList<ArrayList<Integer>> adj){
        int[] topo = new int[V];
        int[] inDeg = new int[V];
        for(int i = 0; i < V; i++){
            for(int it: adj.get(i)){
                inDeg[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(inDeg[i] == 0){
                q.add(i);
            }
        }

        int i = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            topo[i++] = node;

            for (int it: adj.get(node)){
                inDeg[it]--;
                if(inDeg[it] == 0){
                    q.add(it);
                }
            }
        }

        return topo;
    }
    public static void main(String[] args) {
        Q10_TopologicalSort_BFS_KahnsAlgo graph = new Q10_TopologicalSort_BFS_KahnsAlgo();

        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        int[] res = graph.topoSortBFS(V, adj);

        System.out.println(Arrays.toString(res));
    }
}
