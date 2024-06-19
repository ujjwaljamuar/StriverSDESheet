package SpanningTree;

import java.util.ArrayList;
import java.util.Collections;

public class Q5_KruskalsAlgorithm {
    int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        // Code Here.
        ArrayList<Edges> edges = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int node = i;
                int adjNode = adj.get(i).get(j).get(0);
                int wt = adj.get(i).get(j).get(1);

                edges.add(new Edges(wt, node, adjNode));
            }
        }

        Collections.sort(edges);

        DisjointSet ds = new DisjointSet(V);

        int minWt = 0;

        for (int i = 0; i < edges.size(); i++) {
            int wt = edges.get(i).weight;
            int u = edges.get(i).source;
            int v = edges.get(i).destination;

            if (ds.findUPar(u) != ds.findUPar(v)) {
                minWt += wt;
                ds.unionBySize(u, v);
            }
        }

        return minWt;
    }

    // if adj provided find and create edges
    // sort the edges
    // loop through the edges
    // if not in the same component, do union by size and create disjointset
    // add and return minWeight

    public static void main(String[] args) {
        Q5_KruskalsAlgorithm graph = new Q5_KruskalsAlgorithm();

        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        int[][] edges = { { 0, 1, 2 }, { 0, 2, 1 }, { 1, 2, 1 }, { 2, 3, 2 }, { 3, 4, 1 }, { 4, 2, 2 } };

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

        System.out.println(graph.spanningTree(V, adj));

    }

    private class Edges implements Comparable<Edges> {
        int weight, source, destination;

        Edges(int _weight, int _source, int _destination) {
            this.weight = _weight;
            this.source = _source;
            this.destination = _destination;
        }

        public int compareTo(Edges compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    static class DisjointSet {
        ArrayList<Integer> size = new ArrayList<>();
        ArrayList<Integer> parent = new ArrayList<>();

        DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
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
