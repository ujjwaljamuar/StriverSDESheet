package TopoSort;

import java.util.ArrayList;
import java.util.Stack;

public class Q1_TopoSort {

    private void dfs(int node, boolean[] isVisited, Stack<Integer> st, ArrayList<ArrayList<Integer>> adjList) {
        isVisited[node] = true;

        for (int it : adjList.get(node)) {
            if (!isVisited[it]) {
                dfs(it, isVisited, st, adjList);
            }
        }
        st.push(node);
    }

    int[] topoSort(int V, ArrayList<ArrayList<Integer>> adjList) {
        boolean[] isVisited = new boolean[V];

        Stack<Integer> st = new Stack<>();

        int[] res = new int[V];

        for (int i = 0; i < V; i++) {
            if (!isVisited[i]) {
                dfs(i, isVisited, st, adjList);
            }
        }

        int i = 0;
        while (!st.isEmpty()) {
            res[i++] = st.peek();
            st.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        Q1_TopoSort graphs = new Q1_TopoSort();

        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        int[] res = graphs.topoSort(V, adj);

        for(int i: res){
            System.out.print(i + " ");
        }
    }
}
