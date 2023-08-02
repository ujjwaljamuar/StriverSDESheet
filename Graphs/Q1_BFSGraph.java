package Graphs;

import java.util.*;

public class Q1_BFSGraph {
    public static ArrayList<Integer> bfsTraversal(int N, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] isVisited = new boolean[adj.size()];

        // starting node is 1
        q.add(1);
        isVisited[1] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);

            for (Integer it : adj.get(node)) {
                if (isVisited[it] == false) {
                    isVisited[it] = true;
                    q.add(it);
                }
            }
        }

        return bfs;
    }

    public static ArrayList<Integer> bfsTraversalMatrix(int N, int[][] adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] isVisited = new boolean[adj.length];

        // starting node is 1
        q.add(1);
        isVisited[1] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);

            for (int i = 0; i < adj.length; i++) {
                if (adj[node][i] == 1 && !isVisited[i]) {
                    isVisited[i] = true;
                    q.add(i);
                }
            }
        }

        return bfs;
    }

    static void addAdjList(int u, int v, ArrayList<ArrayList<Integer>> adjList) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    static void addUnDirectedMatrix(int u, int v, int[][] adj) {
        // for undirected graph - do adj[u][v], do adj[v][u]
        // edge 1 --- 2
        adj[u][v] = 1;
        adj[v][u] = 1;
    }

    public static void main(String[] args) {

        int n = 9;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int[][] adjMatrix = new int[n + 1][n + 1];

        for (int i = 0; i <= 9; i++) {
            adjList.add(new ArrayList<>());
        }

        // adding adjacency List
        addAdjList(1, 2, adjList);
        addAdjList(1, 6, adjList);
        addAdjList(2, 3, adjList);
        addAdjList(2, 4, adjList);
        addAdjList(6, 7, adjList);
        addAdjList(6, 9, adjList);
        addAdjList(4, 5, adjList);
        addAdjList(7, 8, adjList);
        addAdjList(5, 8, adjList);

        // adding adjacency Matrix
        addUnDirectedMatrix(1, 2, adjMatrix);
        addUnDirectedMatrix(1, 6, adjMatrix);
        addUnDirectedMatrix(2, 3, adjMatrix);
        addUnDirectedMatrix(2, 4, adjMatrix);
        addUnDirectedMatrix(6, 7, adjMatrix);
        addUnDirectedMatrix(6, 9, adjMatrix);
        addUnDirectedMatrix(4, 5, adjMatrix);
        addUnDirectedMatrix(7, 8, adjMatrix);
        addUnDirectedMatrix(5, 8, adjMatrix);

        System.out.println("Adjacency List : " + adjList);

        // n+1 vertexes because of 1 based indexing
        System.out.println("BFS : " + bfsTraversal(n + 1, adjList));

        System.out.println("BFS : " + bfsTraversalMatrix(n + 1, adjMatrix));

    }
}
