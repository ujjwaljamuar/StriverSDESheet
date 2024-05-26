package BFSDFS;

import java.util.LinkedList;
import java.util.Queue;

public class Q11_NumberOfEnclaves {
    // using dfs - always fast

    int noOfEnclaves(int[][] Matrix) {
        int n = Matrix.length;
        int m = Matrix[0].length;
        boolean[][] isVisited = new boolean[n][m];

        int delRow[] = { -1, 0, +1, 0 };
        int delCol[] = { 0, +1, +0, -1 };

        // for all boundaries
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if (Matrix[i][j] == 1) {
                        isVisited[i][j] = true;
                        dfs(i, j, isVisited, Matrix, n, m, delRow, delCol);
                    }
                }
            }
        }

        // count remaining 1s
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (Matrix[i][j] == 1 && !isVisited[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(int row, int col, boolean[][] isVisited, int[][] Matrix, int n, int m, int[] delRow, int[] delCol) {
        isVisited[row][col] = true;

        // for neighbours
        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !isVisited[nRow][nCol] && Matrix[nRow][nCol] == 1) {
                dfs(nRow, nCol, isVisited, Matrix, n, m, delRow, delCol);
            }
        }
    }

    /// using bfs
    int numberOfEnclaves(int[][] Matrix) {
        int n = Matrix.length;
        int m = Matrix[0].length;
        boolean[][] isVisited = new boolean[n][m];

        Queue<Pair> q = new LinkedList<>();

        // for all boundaries
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // first row, first col, last row, last col
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    // if it is a land then store it in queue
                    if (Matrix[i][j] == 1) {
                        q.add(new Pair(i, j));
                        isVisited[i][j] = true;
                    }
                }
            }
        }

        int delrow[] = { -1, 0, +1, 0 };
        int delcol[] = { 0, +1, +0, -1 };

        // bfs
        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for (int i = 0; i < 4; i++) {
                int nRow = row + delrow[i];
                int nCol = col + delcol[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !isVisited[nRow][nCol]
                        && Matrix[nRow][nCol] == 1) {
                    q.add(new Pair(nRow, nCol));
                    isVisited[nRow][nCol] = true;
                }
            }
        }

        // count remaining 1s
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (Matrix[i][j] == 1 && !isVisited[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Q11_NumberOfEnclaves graph = new Q11_NumberOfEnclaves();

        int grid[][] = {
                { 0, 0, 0, 0 },
                { 1, 0, 1, 0 },
                { 0, 1, 1, 0 },
                { 0, 0, 0, 0 } };

        int ans = graph.numberOfEnclaves(grid);
        int ans2 = graph.noOfEnclaves(grid);

        System.out.println(ans);
        System.out.println(ans2);

    }

    class Pair {
        int first;
        int second;

        Pair(int _first, int _second) {
            this.first = _first;
            this.second = _second;
        }
    }
}

/*
 * Start with the boundary elements
 * both bfs and dfs can be used
 * use bfs
 * mark visited to all neighbours
 * after bfs if there any remains
 * count and return
 */