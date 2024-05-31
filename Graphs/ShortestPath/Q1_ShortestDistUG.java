package ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q1_ShortestDistUG {
    int[] shortestDistPair(int[][] edges, int n, int m, int src) {
        int[] dist = new int[n];
        Arrays.fill(dist, (int) (1e9));

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        dist[src] = 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));

        while (!q.isEmpty()) {
            int node = q.peek().node;
            int dis = q.peek().dist;

            q.remove();

            for (int it : adjList.get(node)) {
                if (dis + 1 < dist[it]) {
                    dist[it] = dis + 1;
                    q.add(new Pair(it, dist[it]));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dist[i] == (int) (1e9)) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    int[] shortestDist(int[][] edges, int n, int m, int src) {
        int[] dist = new int[n];
        Arrays.fill(dist, (int) (1e9));

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        dist[src] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()) {
            int node = q.remove();

            for (int it : adjList.get(node)) {
                if (dist[node] + 1 < dist[it]) {
                    dist[it] = dist[node] + 1;
                    q.add(it);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dist[i] == (int) (1e9)) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        Q1_ShortestDistUG graphs = new Q1_ShortestDistUG();

        int n = 9, m = 10;
        int[][] edges = { { 0, 1 }, { 0, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 1, 2 }, { 2, 6 }, { 6, 7 }, { 7, 8 },
                { 6, 8 } };
        int src = 0;

        int[] distArr = graphs.shortestDist(edges, n, m, src);

        for (int i = 0; i < n; i++) {
            System.out.print(distArr[i] + " ");
        }
    }

    class Pair {
        int node, dist;

        Pair(int _n, int _d) {
            this.node = _n;
            this.dist = _d;
        }
    }
}
