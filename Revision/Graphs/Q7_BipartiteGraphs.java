package Graphs;

import java.util.ArrayList;
/*
 Bipartite graph is a graph that can be colored with 2 colors such that 
 no 2 adj element has the same color.
 */
import java.util.Arrays;

public class Q7_BipartiteGraphs {
    boolean dfsCycleDetection(int node, int color, int[] colorArr, ArrayList<ArrayList<Integer>> adj) {
        colorArr[node] = color;

        for (int it : adj.get(node)) {
            if (colorArr[it] == -1) {
                if (dfsCycleDetection(it, 1 - color, colorArr, adj) == false) {
                    return false;
                }
            } else if (colorArr[it] == color) {
                return false;
            }
        }
        return true;
    }

    boolean isBipartite(int N, ArrayList<ArrayList<Integer>> adj) {
        int[] colorArr = new int[N];
        Arrays.fill(colorArr, -1);

        for (int i = 0; i < N; i++) {
            if (colorArr[i] == -1) {
                if (dfsCycleDetection(i, 0, colorArr, adj) == false) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // V = 4, E = 4
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        Q7_BipartiteGraphs graphs = new Q7_BipartiteGraphs();
        boolean ans = graphs.isBipartite(4, adj);

        System.out.println(ans);
    }
}
