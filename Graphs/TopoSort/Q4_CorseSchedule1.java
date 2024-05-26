package TopoSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q4_CorseSchedule1 {
    boolean canFinish(int V, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adjList.get(i)) {
                inDegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        int[] topoSort = new int[V];
        int ind = 0;

        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topoSort[ind++] = node;

            for (int it : adjList.get(node)) {
                inDegree[it]--;

                if (inDegree[it] == 0) {
                    q.add(it);
                }
            }

        }

        if (ind == V) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Q4_CorseSchedule1 graph = new Q4_CorseSchedule1();

        int numCourses = 2;
        int[][] prerequisites = { { 0, 1 } };

        System.out.println(graph.canFinish(numCourses, prerequisites));
    }
}
