package TopoSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q6_FindSafeStates {
    List<Integer> findSafeNodes(int V, List<List<Integer>> adj) {
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            revAdj.add(new ArrayList<>());
        }
        int[] inDegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                revAdj.get(it).add(i);
                inDegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> safeNodes = new ArrayList<>();
        // int count = 0;

        while (!q.isEmpty()) {
            int node = q.remove();
            safeNodes.add(node);

            for (int it : revAdj.get(node)) {
                inDegree[it]--;

                if (inDegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }

    public static void main(String[] args) {
        Q6_FindSafeStates graphs = new Q6_FindSafeStates();

        int V = 12;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(2).add(4);
        adj.get(3).add(4);
        adj.get(3).add(5);
        adj.get(4).add(6);
        adj.get(5).add(6);
        adj.get(6).add(7);
        adj.get(8).add(1);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);
        adj.get(11).add(9);

        System.out.println(graphs.findSafeNodes(V, adj));

    }
}
