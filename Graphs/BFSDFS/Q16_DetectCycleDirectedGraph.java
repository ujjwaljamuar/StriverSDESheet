import java.util.ArrayList;

public class Q16_DetectCycleDirectedGraph {

    boolean dfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] isVisited, boolean[] isPathVisited) {
        isVisited[node] = true;
        isPathVisited[node] = true;

        // traverse every adjacent element
        for (int it : adjList.get(node)) {
            if (!isVisited[it]) {
                if (dfs(it, adjList, isVisited, isPathVisited)) {
                    return true;
                }
            }

            // if already visited but checking if path visited then its a cycle
            else if (isPathVisited[it]) {
                return true;
            }
        }

        // if not detected cycle
        isPathVisited[node] = false;
        return false;
    }

    boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adjList) {
        boolean[] isVisited = new boolean[V];
        boolean[] isPathVisited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!isVisited[i]) {
                if (dfs(i, adjList, isVisited, isPathVisited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Q16_DetectCycleDirectedGraph graph = new Q16_DetectCycleDirectedGraph();

        int V = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);

        System.out.println(graph.detectCycle(V, adj));
    }
}
