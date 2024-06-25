package SpanningTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q10_MakingLargeIsland {
    int largestIsland(int[][] grid) {
        int n = grid.length;

        DisjointSet ds = new DisjointSet(n * n);

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    continue;
                }

                int[] dRow = { -1, 0, 1, 0 };
                int[] dCol = { 0, -1, 0, 1 };

                for (int ind = 0; ind < 4; ind++) {
                    int nRow = row + dRow[ind];
                    int nCol = col + dCol[ind];

                    if (isValid(nRow, nCol, n) && grid[nRow][nCol] == 1) {
                        int nodeNo = row * n + col;
                        int adjNodeNo = nRow * n + nCol;

                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }

        // step 2;
        int max = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    continue;
                }

                int[] dRow = { -1, 0, 1, 0 };
                int[] dCol = { 0, -1, 0, 1 };

                Set<Integer> components = new HashSet<>();

                for (int ind = 0; ind < 4; ind++) {
                    int nRow = row + dRow[ind];
                    int nCol = col + dCol[ind];

                    if (isValid(nRow, nCol, n)) {
                        if (grid[nRow][nCol] == 1) {
                            components.add(ds.findUPar(nRow * n + nCol));
                        }
                    }
                }

                int sizeTotal = 0;

                for (Integer parents : components) {
                    sizeTotal += ds.size.get(parents);
                }

                max = Math.max(max, sizeTotal + 1);

            }
        }

        // if grid has all 1s
        for (int cellNo = 0; cellNo < n * n; cellNo++) {
            max = Math.max(max, ds.size.get(ds.findUPar(cellNo)));
        }

        return max;

    }

    private boolean isValid(int newRow, int newCol, int n) {
        return newRow >= 0 && newRow < n && newCol >= 0 && newCol < n;
    }

    public static void main(String[] args) {
        Q10_MakingLargeIsland graph = new Q10_MakingLargeIsland();

        int[][] grid = {
                { 1, 1, 0, 1, 1, 0 },
                { 1, 1, 0, 1, 1, 0 },
                { 1, 1, 0, 1, 1, 0 },
                { 0, 0, 1, 0, 0, 0 },
                { 0, 0, 1, 1, 1, 0 },
                { 0, 0, 1, 1, 1, 0 }
        };

        System.out.println(graph.largestIsland(grid));
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
            if (node == parent.get(node)) {
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
