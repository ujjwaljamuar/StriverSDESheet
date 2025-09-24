package Graphs;

import java.util.ArrayList;
import java.util.List;

public class Q2_AdjacencyList {
    // space -> 2xEdges, better than nxn in adj-matrix
    static List<List<Integer>> getGraph(int nodes, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= nodes; i++) { // <n in case of 0 based indexing
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u); // remove in case of directed graph
        }

        return graph;
    }

    public static void main(String[] args) {
        int n = 5; // number of nodes

        int[][] edges = {
                { 2, 1 },
                { 1, 3 },
                { 2, 4 },
                { 3, 4 },
                { 2, 5 },
                { 4, 5 }
        };

        System.out.println(getGraph(n, edges));
    }
}
