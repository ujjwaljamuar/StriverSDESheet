package Graphs;

import java.util.*;

public class Q1_BFSGraph {
    public ArrayList<Integer> bfsTraversal(int N, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] isVisited = new boolean[N];

        q.add(0);
        isVisited[0] = true;

        while(!q.isEmpty()){
            Integer node = q.poll();
            bfs.add(node);

            for(Integer it: adj.get(node)){
                if(isVisited[it] == false){
                    isVisited[it] = true;
                    q.add(it);
                }
            }
        }

        return bfs;
    }
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
