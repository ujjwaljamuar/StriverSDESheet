package Graphs;

public class AdjacencyGraphMatrix {

    static void addUnDirected(int[][] adj, int u, int v) {
        // for undirected graph - do adj[u][v], do adj[v][u]
        // edge 1 --- 2
        adj[u][v] = 1;
        adj[v][u] = 1;
    }

    static void addDirected(int[][] adj, int u, int v) {
        // for directed graph only do adj[u][v]
        adj[u][v] = 1;
    }

    public static void main(String[] args) {
        int n = 5, m = 5;
        int[][] adj = new int[n + 1][n + 1];

        addUnDirected(adj, 1, 2);
        addUnDirected(adj, 1, 3);
        addUnDirected(adj, 3, 4);
        addUnDirected(adj, 2, 4);
        addUnDirected(adj, 2, 5);
        addUnDirected(adj, 4, 5);

        System.out.println("Undirected Ajdacency Matrix : ");

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

}

// if want to add weight use adj[u][v] = wt instead of 1;