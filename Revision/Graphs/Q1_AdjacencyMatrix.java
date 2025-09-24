package Graphs;

import java.util.Arrays;

public class Q1_AdjacencyMatrix {
    static int[][] getGraph (int n, int[][] edges){
        int[][] graph = new int[n+1][n+1]; // n+1 if its 1 based indexing
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            graph[u][v] = 1;
            graph[v][u] = 1; // remove this if it is directed
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

        int[][] undirectedGraph = getGraph(n, edges);

        System.out.println(Arrays.deepToString(undirectedGraph));
    }
}
