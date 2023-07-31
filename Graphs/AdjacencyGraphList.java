package Graphs;

import java.util.ArrayList;

public class AdjacencyGraphList {

    static void addUndirected(ArrayList<ArrayList<Integer>> adjUD, int u, int v) {
        // Undirected graph
        adjUD.get(u).add(v);
        adjUD.get(v).add(u);
    }

    static void addDirected(ArrayList<ArrayList<Integer>> adjD, int u, int v) {
        // Directed graph
        adjD.get(u).add(v);
    }

    public static void main(String[] args) {
        int n = 5, m = 5;
        ArrayList<ArrayList<Integer>> adjUD = new ArrayList<>(); // Un-directed
        ArrayList<ArrayList<Integer>> adjD = new ArrayList<>(); // directed

        for (int i = 0; i <= n; i++) {
            adjUD.add(new ArrayList<>());
        }
        for (int i = 0; i <= n; i++) {
            adjD.add(new ArrayList<>());
        }

        addUndirected(adjUD, 1, 2);
        addUndirected(adjUD, 1, 3);
        addUndirected(adjUD, 3, 4);
        addUndirected(adjUD, 2, 4);
        addUndirected(adjUD, 2, 5);
        addUndirected(adjUD, 4, 5);

        addDirected(adjD, 1, 2);
        addDirected(adjD, 1, 3);
        addDirected(adjD, 3, 4);
        addDirected(adjD, 2, 4);
        addDirected(adjD, 2, 5);
        addDirected(adjD, 4, 5);

        System.out.print("Undirected Graph: ");
        System.out.println(adjUD);

        System.out.print("Directed Graph: ");
        System.out.println(adjD);
    }
}
