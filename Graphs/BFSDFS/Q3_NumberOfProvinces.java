package Graphs;

import java.util.ArrayList;

public class Q3_NumberOfProvinces {
    static int numofProvinces(ArrayList<ArrayList<Integer>> adjMat, int V) {

        // if V is not given then V = adjMat.length;

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        // convert matrix to list
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                // self nodes are not considered
                if (adjMat.get(i).get(j) == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        System.out.println(adjList);

        int[] isVisited = new int[V];
        int count = 0;

        for (int i = 0; i < V; i++) {
            if (isVisited[i] == 0) {
                count++;
                dfs(i, adjList, isVisited);
            }
        }

        return count;
    }

    static void dfs(int node, ArrayList<ArrayList<Integer>> adjList, int[] isVisited) {
        isVisited[node] = 1;
        for (Integer it : adjList.get(node)) {
            if (isVisited[it] == 0) {
                dfs(it, adjList, isVisited);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        adj.add(new ArrayList<Integer>());
        adj.get(0).add(0, 1);
        adj.get(0).add(1, 0);
        adj.get(0).add(2, 1);
        adj.add(new ArrayList<Integer>());
        adj.get(1).add(0, 0);
        adj.get(1).add(1, 1);
        adj.get(1).add(2, 0);
        adj.add(new ArrayList<Integer>());
        adj.get(2).add(0, 1);
        adj.get(2).add(1, 0);
        adj.get(2).add(2, 1);

        System.out.println(adj);

        System.out.println(numofProvinces(adj, 3));

    }
}
