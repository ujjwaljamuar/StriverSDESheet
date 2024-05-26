package BFSDFS;

import java.util.LinkedList;
import java.util.Queue;

public class Q14_NumberOfIslandsMultiSource {

    int numOfIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] isVisited = new boolean[n][m];

        int count = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == '1' && !isVisited[row][col]) {
                    dfs(grid, isVisited, row, col, n, m);
                    count++;
                }
            }
        }
        return count;
    }

    void bfs(char[][] grid, boolean[][] isVisited, int ro, int co, int n, int m) {
        isVisited[ro][co] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro, co));

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;

            q.remove();

            for (int dRow = -1; dRow <= 1; dRow++) {
                for (int dCol = -1; dCol <= 1; dCol++) {
                    int nRow = row + dRow;
                    int nCol = col + dCol;

                    if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m &&
                            grid[nRow][nCol] == '1' && !isVisited[nRow][nCol]) {
                        isVisited[nRow][nCol] = true;
                        q.add(new Pair(nRow, nCol));
                    }
                }
            }
        }
    }

    void dfs(char[][] grid, boolean isVisited[][], int ro, int co, int n, int m) {
        isVisited[ro][co] = true;

        for (int dRow = -1; dRow <= 1; dRow++) {
            for (int dCol = -1; dCol <= 1; dCol++) {
                int nRow = ro + dRow;
                int nCol = co + dCol;

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol <= m &&
                        grid[nRow][nCol] == '1' && !isVisited[nRow][nCol]) {
                    isVisited[nRow][nCol] = true;
                    dfs(grid, isVisited, nRow, nCol, n, m);
                }
            }
        }

    }

    public static void main(String[] args) {
        Q14_NumberOfIslandsMultiSource graph = new Q14_NumberOfIslandsMultiSource();

        char[][] grid = {
                { '0', '1', '1', '1', '0', '0', '0' },
                { '0', '0', '1', '1', '0', '1', '0' }
        };

        System.out.println(graph.numOfIslands(grid));
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
