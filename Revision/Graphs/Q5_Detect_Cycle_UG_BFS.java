package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q5_Detect_Cycle_UG_BFS {
    boolean detectCycleBFSUtil(List<List<Integer>> adjList, int n, int startIndex, boolean[] vis) {
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(startIndex, -1));
        vis[startIndex] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int node = p.node;
            int parent = p.parent;

            for (int it : adjList.get(node)) {
                if (vis[it] == false) {
                    q.add(new Pair(it, node));
                    vis[it] = true;
                }

                // if adjacent node is visited and is not its own parent node
                else if (it != parent)
                    return true;
            }

        }
        return false;

    }

    boolean detectCycle(List<List<Integer>> adjList, int n, int startIndex) {
        boolean[] vis = new boolean[n + 1];
        // boolean isCycle = detectCycleBFSUtil(adjList, n, startIndex, vis);
        for(int i=0;i<=n;i++)
            if(vis[i]==false) 
                if(detectCycleBFSUtil(adjList, n,startIndex, vis)) 
                    return true;
    
        return false;


    }

    public static void main(String[] args) {
        Q5_Detect_Cycle_UG_BFS graph = new Q5_Detect_Cycle_UG_BFS();
        int[][] edges = {
                { 1, 2 },
                { 2, 5 },
                { 5, 7 },
                { 1, 3 },
                { 3, 4 },
                { 3, 6 },
                { 6, 7 }
        };

        int n = 7;
        int startIndex = 1;

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] it : edges) {
            int u = it[0];
            int v = it[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // System.out.println(adjList);
        System.out.println(graph.detectCycle(adjList, n, startIndex));

    }

    class Pair {
        int node;
        int parent;

        Pair(int _node, int _parent) {
            this.node = _node;
            this.parent = _parent;
        }
    }
}
