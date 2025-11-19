package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q11_DetectCycle_DG_BFS {
    boolean detectCycleDG_BFS(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        int[] inDeg = new int[V];

        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                inDeg[it]++;
            }
        }

        for (int i = 0; i < V; i++) {
            if (inDeg[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;
        int[] topo = new int[V];

        while (!q.isEmpty()) {
            int node = q.poll();
            topo[count++] = node;

            for (int it : adj.get(node)) {
                inDeg[it]--;
                if (inDeg[it] == 0) {
                    q.add(it);
                }
            }
        }

        if (count == V) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Q11_DetectCycle_DG_BFS graph = new Q11_DetectCycle_DG_BFS();

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

        System.out.println(graph.detectCycleDG_BFS(V, adj));
    }
}
