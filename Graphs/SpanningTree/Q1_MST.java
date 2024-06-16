package SpanningTree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Q1_MST {
    int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.

        ArrayList<Pair> mst = new ArrayList<>();
        boolean[] vis = new boolean[V];
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);

        pq.add(new Tuple(0, 0, -1));

        int sum = 0;

        while (!pq.isEmpty()) {
            int dis = pq.peek().distance;
            int child = pq.peek().child;
            int parent = pq.peek().parent;

            pq.remove();

            if (!vis[child]) {
                vis[child] = true;
                mst.add(new Pair(parent, child));
                sum += dis;
                int index = 0;
                for (int[] it : adj.get(child)) {
                    int adjParent = index++;
                    int adjChild = it[0];
                    int adjDis = it[1];
                    pq.add(new Tuple(adjDis, adjChild, adjParent));
                }
            }
        }
        return sum;
    }

    // 1. add 0, 0, -1 to priority queue
    // 2. take peeks out, and remove it
    // 3. if child is not visited only then add parent, child to mst, and sum up the distance and mark visited
    // 4. go to its adjacents and add them in pq.

    public static void main(String[] args) {

        Q1_MST graph = new Q1_MST();

        int V = 3;
        int E = 3;

        // int[][] adj = {
        // { 0, 1, 5 },
        // { 1, 2, 3 },
        // { 0, 2, 1 }
        // };

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList());
        }

        adj.get(0).add(new int[] { 1, 5 });
        adj.get(1).add(new int[] { 0, 5 });

        adj.get(1).add(new int[] { 2, 3 });
        adj.get(2).add(new int[] { 1, 3 });

        adj.get(0).add(new int[] { 2, 1 });
        adj.get(2).add(new int[] { 0, 1 });

        System.out.println(graph.spanningTree(V, E, adj));

    }

    private class Pair {
        int parent, child;

        Pair(int _parent, int _child) {
            this.parent = _parent;
            this.child = _child;
        }
    }

    private class Tuple {
        int distance, child, parent;

        Tuple(int _distance, int _child, int _parent) {
            this.distance = _distance;
            this.child = _child;
            this.parent = _parent;
        }
    }
}
