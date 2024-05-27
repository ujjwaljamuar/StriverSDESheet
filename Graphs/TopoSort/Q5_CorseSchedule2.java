package TopoSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q5_CorseSchedule2 {
    ArrayList<Integer> findOrder(int numCourses, int[][] prerequisites) {
        // convert 2d array into adj list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        // create indegree
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            for (int it : adjList.get(i)) {
                inDegree[it]++;
            }
        }

        // create a queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> topoSort = new ArrayList<>();
        int count = 0;

        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            // topoSort[count++] = node
            topoSort.add(node);
            count++;

            for (int it : adjList.get(node)) {
                inDegree[it]--;

                if (inDegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        // if only no cycle found
        if (count == numCourses) {
            return topoSort;
        }

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        Q5_CorseSchedule2 graph = new Q5_CorseSchedule2();

        int numCourses = 2;
        // int[][] prerequisites = { { 0, 1 }, { 1, 0 } };
        // int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        int[][] prerequisites = { { 1, 0 } };

        System.out.println(graph.findOrder(numCourses, prerequisites));
    }
}
