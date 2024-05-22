package TopoSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q1_TopoSortBFS {
    int[] topoSort(int V, ArrayList<ArrayList<Integer>> adjList) {
        // build indegree
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

        int i = 0;
        int[] topoSort = new int[V];

        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topoSort[i++] = node;

            for (int it : adjList.get(node)) {
                inDegree[it]--;
                if (inDegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        return topoSort;
    }

    public static void main(String[] args) {
        Q1_TopoSortBFS graph = new Q1_TopoSortBFS();

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

        int[] res = graph.topoSort(V, adj);

        for (int i : res) {
            System.out.print(i + " ");
        }

        // 5 4 2 3 1 0
    }
}
