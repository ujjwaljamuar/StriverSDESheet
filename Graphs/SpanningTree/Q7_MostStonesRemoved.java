package SpanningTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q7_MostStonesRemoved {

    public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < n; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);

        HashMap<Integer, Integer> nodeMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;

            ds.unionBySize(nodeRow, nodeCol);
            nodeMap.put(nodeRow, 1);
            nodeMap.put(nodeCol, 1);
        }

        int count = 0;

        for (Map.Entry<Integer, Integer> it : nodeMap.entrySet()) {
            if (ds.findUPar(it.getKey()) == it.getKey()) {
                count++;
            }
        }

        return n - count;
    }

    public static void main(String[] args) {

        Q7_MostStonesRemoved graph = new Q7_MostStonesRemoved();

        int[][] stones = {
                { 0, 0 }, { 0, 2 },
                { 1, 3 }, { 3, 1 },
                { 3, 2 }, { 4, 3 }
        };

        System.out.println(graph.removeStones(stones));

    }

    private static class DisjointSet {
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                size.add(1);
                parent.add(i);
            }
        }

        int findUPar(int node) {
            if (parent.get(node) == node) {
                return node;
            }

            parent.set(node, findUPar(parent.get(node)));
            return parent.get(node);
        }

        void unionBySize(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);

            if (ulp_u == ulp_v) {
                return;
            }

            if (size.get(ulp_u) < size.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
            }

            else {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }
    }
}
