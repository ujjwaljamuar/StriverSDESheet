package SpanningTree;

import java.util.ArrayList;
import java.util.List;

public class Q9_NumberOfIslandsII {
    List<Integer> numOfIsland(int n, int m, int[][] operators) {
        DisjointSet ds = new DisjointSet(n * m);
        int len = operators.length;

        boolean[][] isVisited = new boolean[n][m];

        List<Integer> ans = new ArrayList();
        int count = 0;

        for(int i = 0; i < len; i++){
            int row = operators[i][0];
            int col = operators[i][1];

            if(isVisited[row][col] == true){
                ans.add(count);
                continue;
            }

            isVisited[row][col] = true;
            count++;
            int dr[] = { -1, 0, 1, 0};
            int dc[] = {0, 1, 0, -1};

            for(int ind = 0; ind < 4; ind++){
                int nRow = row + dr[ind];
                int nCol = col + dc[ind];

                if(isValid(nRow, nCol, n, m)){
                    if(isVisited[nRow][nCol] == true){
                        int nodeNo = row * m + col;
                        int adjNodeNo = nRow * m + nCol;

                        if(ds.findUPar(nodeNo) != ds.findUPar(adjNodeNo)){
                            count--;
                            ds.unionBySize(nodeNo, adjNodeNo);
                        }
                    }
                }
            }

            ans.add(count);
        }
        return ans;

    }
    private boolean isValid(int adjr, int adjc, int n, int m) {
        return adjr >= 0 && adjr < n && adjc >= 0 && adjc < m;
    }

    public static void main(String[] args) {
        Q9_NumberOfIslandsII graph = new Q9_NumberOfIslandsII();

        int n = 4, m = 5;
        int[][] operators = {
                { 0, 0 },
                { 0, 0 },
                { 1, 1 },
                { 1, 0 },
                { 0, 1 },
                { 0, 3 },
                { 1, 3 },
                { 0, 4 },
                { 3, 2 },
                { 2, 2 },
                { 1, 2 },
                { 0, 2 }
        };

        System.out.println(graph.numOfIsland(n, m, operators));
    }

    private static class DisjointSet {
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                size.add(0);
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
            } else {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }
    }

}
