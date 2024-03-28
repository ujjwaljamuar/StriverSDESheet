package Graphs;

import java.util.*;

public class Q1_BFSGraph {
    ArrayList<Integer> bfsTraversal(int n, ArrayList<ArrayList<Integer>> adjList) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] isVisited = new boolean[n];

        Queue<Integer> q = new LinkedList<>();

        // add starting node to queue and mark it visited
        q.add(0);
        isVisited[0] = true;

        // till queue is not empty
        while (!q.isEmpty()) {
            // take out the first element in queue and add it to bfs list
            Integer node = q.poll();
            bfs.add(node);

            for (Integer i : adjList.get(node)) {
                // check if the element is already visited, if not mark it and add it to queue
                // to be visited
                if (isVisited[i] == false) {
                    isVisited[i] = true;
                    q.add(i);
                }
            }
        }
        return bfs;
    }

    public static void main(String[] args) {
        Q1_BFSGraph graph = new Q1_BFSGraph();

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(1);
        adjList.get(1).add(0);
        adjList.get(0).add(4);
        adjList.get(4).add(0);
        adjList.get(1).add(2);
        adjList.get(2).add(1);
        adjList.get(1).add(3);
        adjList.get(3).add(1);

        System.out.println(graph.bfsTraversal(5, adjList));
    }

}
