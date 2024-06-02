package ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class DijkstraAlgorithm {
    int[] dijkstraPQ(int V, int S, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);
        dist[S] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.dist - y.dist);
        pq.add(new Pair(0, S));

        while (!pq.isEmpty()) {
            int dis = pq.peek().dist;
            int node = pq.peek().node;
            pq.remove();

            for (ArrayList<Integer> it : adj.get(node)) {
                int n = it.get(0);
                int wt = it.get(1);

                if (dis + wt < dist[n]) {
                    dist[n] = dis + wt;
                    pq.add(new Pair(dist[n], n));
                }
            }
        }

        return dist;
    }

    int[] dijkstraSet(int V, int S, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);
        dist[S] = 0;

        Set<Pair> set = new TreeSet<>();
        set.add(new Pair(0, S));

        while (!set.isEmpty()) {
            Pair p = set.stream().findFirst().orElse(null);
            int dis = p.dist;
            int node = p.node;

            set.remove(new Pair(dis, node));

            for (ArrayList<Integer> it : adj.get(node)) {
                int n = it.get(0);
                int wt = it.get(1);

                if (dis + wt < dist[n]) {
                    dist[n] = dis + wt;
                    set.add(new Pair(dist[n], n));
                }
            }

        }

        return dist;
    }

    public static void main(String[] args) {
        DijkstraAlgorithm graph = new DijkstraAlgorithm();

        int V = 3, E = 3, S = 2;
        ArrayList<Integer> node1 = new ArrayList<Integer>() {
            {
                add(1);
                add(1);
            }
        };
        ArrayList<Integer> node2 = new ArrayList<Integer>() {
            {
                add(2);
                add(6);
            }
        };
        ArrayList<Integer> node3 = new ArrayList<Integer>() {
            {
                add(2);
                add(3);
            }
        };
        ArrayList<Integer> node4 = new ArrayList<Integer>() {
            {
                add(0);
                add(1);
            }
        };
        ArrayList<Integer> node5 = new ArrayList<Integer>() {
            {
                add(1);
                add(3);
            }
        };
        ArrayList<Integer> node6 = new ArrayList<Integer>() {
            {
                add(0);
                add(6);
            }
        };

        ArrayList<ArrayList<Integer>> inter1 = new ArrayList<ArrayList<Integer>>() {
            {
                add(node1);
                add(node2);
            }
        };
        ArrayList<ArrayList<Integer>> inter2 = new ArrayList<ArrayList<Integer>>() {
            {
                add(node3);
                add(node4);
            }
        };
        ArrayList<ArrayList<Integer>> inter3 = new ArrayList<ArrayList<Integer>>() {
            {
                add(node5);
                add(node6);
            }
        };
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>() {
            {
                add(inter1); // for 1st node
                add(inter2); // for 2nd node
                add(inter3); // for 3rd node
            }
        };

        /*
         * 0 -> 1, 2
         * 1 -> 0, 2
         * 2 -> 0, 1
         * 
         * list ->
         * [ [[1, 1], [2, 6]], [[2, 3], [0, 1]], [[1, 3], [0, 6]] ]
         */
        int[] resPQ = graph.dijkstraPQ(V, S, adj);
        int[] resSet = graph.dijkstraSet(V, S, adj);

        for (int it : resPQ) {
            System.out.print(it + " ");
        }

        System.out.println();

        for (int it : resSet) {
            System.out.print(it + " ");
        }
    }

    class Pair implements Comparable<Pair> {
        int dist, node;

        Pair(int _d, int _n) {
            this.dist = _d;
            this.node = _n;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.dist, other.dist);
        }
    }
}
