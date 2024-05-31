package ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Q2_ShortestDistDAG {

    public int[] shortestPath(int N, int M, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<Pair>());
        }

        for (int i = 0; i < M; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
        }

        // topoSort using DFS
        boolean[] isVisited = new boolean[N];
        Stack<Integer> topoSort = new Stack();

        for (int i = 0; i < N; i++) {
            if (!isVisited[i]) {
                dfs(i, isVisited, adj, topoSort);
            }
        }

        int[] dist = new int[N];
        Arrays.fill(dist, (int) (1e9));
        dist[0] = 0;

        while (!topoSort.empty()) {
            int node = topoSort.peek();
            topoSort.pop();

            for (Pair it : adj.get(node)) {

                int v = it.node;
                int wt = it.dist;

                if (dist[node] + wt < dist[v]) {
                    dist[v] = dist[node] + wt;
                }
            }

        }

        for (int i = 0; i < N; i++) {
            if (dist[i] == (int) (1e9)) {
                dist[i] = -1;
            }
        }

        return dist;

    }

    void dfs(int node, boolean[] isVisited, ArrayList<ArrayList<Pair>> adj, Stack<Integer> topoSort) {
        isVisited[node] = true;

        for (Pair it : adj.get(node)) {
            if (!isVisited[it.node]) {
                dfs(it.node, isVisited, adj, topoSort);
            }
        }
        topoSort.add(node);
    }

    public static void main(String[] args) {

        Q2_ShortestDistDAG graph = new Q2_ShortestDistDAG();
        int[][] array = {
                { 0, 2, 6 },
                { 0, 3, 7 },
                { 0, 4, 9 },
                { 0, 6, 8 },
                { 0, 7, 6 },
                { 1, 2, 6 },
                { 1, 3, 7 },
                { 1, 5, 10 },
                { 1, 6, 1 },
                { 1, 7, 4 },
                { 2, 3, 3 },
                { 2, 6, 10 },
                { 2, 8, 8 },
                { 2, 9, 10 },
                { 3, 5, 3 },
                { 3, 6, 10 },
                { 3, 7, 5 },
                { 5, 6, 9 },
                { 5, 7, 7 },
                { 6, 7, 7 },
                { 6, 8, 8 },
                { 6, 9, 8 },
                { 7, 9, 1 },
                { 8, 9, 6 }
        };

        int N = 10, M = 24;

        int[] res = graph.shortestPath(N, M, array);

        for (int it : res) {
            System.out.print(it + " ");
        }
    }

    class Pair {
        int node, dist;

        Pair(int _n, int _d) {
            this.node = _n;
            this.dist = _d;
        }
    }

}
