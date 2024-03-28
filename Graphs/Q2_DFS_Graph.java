package Graphs;

import java.util.ArrayList;

public class Q2_DFS_Graph {

    void dfsHelper(int node, boolean[] isVisited, ArrayList<Integer> dfs, ArrayList<ArrayList<Integer>> adjList){
        isVisited[node] = true;
        dfs.add(node);

        for (int i : adjList.get(node)) {
            if(isVisited[i] == false){
                dfsHelper(i, isVisited, dfs, adjList);
            }
        }
    }

    ArrayList<Integer> dfsTraversal(int elements, ArrayList<ArrayList<Integer>> adjList){
        boolean[] isVisited = new boolean[elements];
        ArrayList<Integer> dfs = new ArrayList<>();

        isVisited[0] = true;
        dfsHelper(0, isVisited, dfs, adjList);

        return dfs;
    }

    public static void main(String[] args) {
        Q2_DFS_Graph graph = new Q2_DFS_Graph(); 

        int n = 5;
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);
        
        System.out.println(graph.dfsTraversal(n, adj));        
    }
}
