package Graphs;

import java.util.ArrayList;

public class Q8_DetectCycleDFS {

    boolean dfs(int node, int parent, boolean[] isVisited, ArrayList<ArrayList<Integer>> adjList){
        isVisited[node] = true;

        // for every adj node
        for(int adjNode: adjList.get(node)){

            // if adjnode is not visited
            if(!isVisited[adjNode]){
                // if dfs returns true, it was a cycle
                if(dfs(adjNode, node, isVisited, adjList)){
                    return true;
                }
            }

            // if adj node was not parent and was already visited -> cycle
            else if(adjNode != parent){
                return true;
            }
        }

        return false;
    }

    boolean detectCycleDFS(ArrayList<ArrayList<Integer>> adjList, int V){
        boolean[] isVisited = new boolean[V];

        // check for every graph
        for(int i = 0; i< V; i++){
            if(!isVisited[i]){
                if(dfs(i, -1, isVisited, adjList)){
                    return true;
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {
        Q8_DetectCycleDFS graph = new Q8_DetectCycleDFS();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        boolean ans = graph.detectCycleDFS(adj, 4);
        if (ans)
            System.out.println("1");
        else
            System.out.println("0");
    }
}
