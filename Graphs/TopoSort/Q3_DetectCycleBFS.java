package TopoSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q3_DetectCycleBFS {

    boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adjList) {
        int[] inDegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int it : adjList.get(i)) {
                inDegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        // int[] topoSort = new int[V];
        int count = 0;

        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();

            // topoSort[count++] = node;
            count++;

            for (int it : adjList.get(node)) {
                inDegree[it]--;

                if (inDegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        // if total count of topoSort elements is same as initial then no cycle
        if (count == V) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Q3_DetectCycleBFS graph = new Q3_DetectCycleBFS();

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

        System.out.println(graph.detectCycle(V, adj));

    }
}
