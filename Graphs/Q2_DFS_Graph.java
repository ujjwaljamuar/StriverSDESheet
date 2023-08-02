package Graphs;

import java.util.ArrayList;

public class Q2_DFS_Graph {

    static void dfsHelper(int node, boolean[] isVisited,  ArrayList<ArrayList<Integer>> adjList, ArrayList<Integer> dfs){
        isVisited[node] = true;
        dfs.add(node);

        for(Integer it: adjList.get(node)){
            if(!isVisited[it]){
                dfsHelper(it, isVisited, adjList, dfs);
            }
        }
    }
    static ArrayList<Integer> dfs(int V, ArrayList<ArrayList<Integer>> adjList){
        boolean[] isVisited = new boolean[V+1];
        ArrayList<Integer> dfs = new ArrayList<>();

        // 0 based indexing
        isVisited[0] = true;

        dfsHelper(0, isVisited, adjList, dfs);
        return dfs;
    }

    static void addAdjList(int u, int v, ArrayList<ArrayList<Integer>> adjList) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        // because of 0 based indexing <
        for (int i = 0; i < 5; i++) {
            adjList.add(new ArrayList<>());
        }

        // adding adjacency List
        addAdjList(0, 1, adjList);
        addAdjList(0, 2, adjList);
        addAdjList(0, 4, adjList);
        addAdjList(4, 3, adjList);

        System.out.println(adjList);

        System.out.println(dfs(n, adjList));
        
    }
}
