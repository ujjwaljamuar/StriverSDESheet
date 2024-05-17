package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class Q15_BipartiteGraph {

    boolean dfs(int node, int color, int[] colorArr, ArrayList<ArrayList<Integer>> adjList) {
        colorArr[node] = color;

        for (int it : adjList.get(node)) {
            if (colorArr[it] == -1) {
                if (!dfs(it, 1 - color, colorArr, adjList)) {
                    return false;
                }

                // if previously colored has the same color
            } else if (colorArr[it] == color) {
                return false;
            }
        }

        return true;
    }

    boolean isBipartiteGraph(int totalVertex, ArrayList<ArrayList<Integer>> adjList) {
        int[] colorArr = new int[totalVertex];
        Arrays.fill(colorArr, -1);

        for (int i = 0; i < totalVertex; i++) {
            if (colorArr[i] == -1) {
                if (!dfs(i, 0, colorArr, adjList)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q15_BipartiteGraph graph = new Q15_BipartiteGraph();

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(2);
        adjList.get(1).add(1);
        adjList.get(1).add(3);
        adjList.get(2).add(2);
        adjList.get(2).add(4);
        adjList.get(3).add(3);
        adjList.get(3).add(7);
        adjList.get(3).add(5);
        adjList.get(4).add(4);
        adjList.get(4).add(6);
        adjList.get(5).add(2);
        adjList.get(5).add(5);
        adjList.get(6).add(4);
        adjList.get(6).add(8);
        adjList.get(7).add(7);

        System.out.println(graph.isBipartiteGraph(8, adjList));
    }
}
