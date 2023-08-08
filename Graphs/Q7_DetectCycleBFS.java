package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;

public class Q7_DetectCycleBFS {

    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean vis[] = new boolean[V];
        Arrays.fill(vis, false);
        int parent[] = new int[V];
        Arrays.fill(parent, -1);

        for(int i=0;i<V;i++)
            if(vis[i]==false) 
                if(detectCycle(i, vis, parent, adj))
                    return true;
    
        return false;
    }

    static boolean detectCycle(int s, boolean[] visited, int[] parent, ArrayList<ArrayList<Integer>> adj) {
        Queue<Pairrr> q = new LinkedList<>(); // BFS
        q.add(new Pairrr(s, -1));
        visited[s] = true;

        // until the queue is empty
        while (!q.isEmpty()) {
            // source node and its parent node
            int node = q.peek().first;
            int par = q.peek().second;
            q.remove();

            // go to all the adjacent nodes
            for (Integer it : adj.get(node)) {
                if (visited[it] == false) {
                    q.add(new Pairrr(it, node));
                    visited[it] = true;
                }

                // if adjacent node is visited and is not its own parent node
                else if (par != it)
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        boolean ans = isCyclic(adj, 4);
        if (ans)
            System.out.println("1");
        else
            System.out.println("0");
    }
}

class Pairrr {
    int first;
    int second;

    public Pairrr(int _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}