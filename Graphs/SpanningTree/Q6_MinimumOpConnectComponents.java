package SpanningTree;

import java.util.ArrayList;

public class Q6_MinimumOpConnectComponents {
    int minOp(int V, int[][] edges) {
        int extraEdges = 0;

        DisjointSet ds = new DisjointSet(V);

        for (int i = 0; i < edges.length; i++) {
            if (ds.findUPar(edges[i][0]) == ds.findUPar(edges[i][1])) {
                extraEdges += 1;
            } else {
                ds.unionBySize(edges[i][0], edges[i][1]);
            }
        }

        int totalComponents = 0;
        for (int i = 0; i < V; i++) {
            if (ds.findUPar(i) == i) {
                totalComponents++;
            }
        }

        int minOp = totalComponents - 1;

        if (extraEdges >= minOp) {
            return minOp;
        }

        return -1;
    }

    public static void main(String[] args) {
        Q6_MinimumOpConnectComponents graph = new Q6_MinimumOpConnectComponents();

        int V = 9;
        int[][] edge = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 }, { 2, 3 }, { 4, 5 }, { 5, 6 }, { 7, 8 } };

        System.out.println(graph.minOp(V, edge));
    }

    private class DisjointSet {
        ArrayList<Integer> size = new ArrayList<>();
        ArrayList<Integer> parent = new ArrayList<>();

        DisjointSet(int n) {
            for (int i = 0; i < n; i++) {
                size.add(0);
                parent.add(i);
            }
        }

        int findUPar(int node) {
            if (node == parent.get(node)) {
                return node;
            }

            parent.set(node, findUPar(parent.get(node)));
            return parent.get(node);
        }

        void unionBySize(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);

            if (ulp_u == ulp_v) {
                return;
            }

            if (size.get(ulp_u) < size.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
            } else {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }
    }
}
