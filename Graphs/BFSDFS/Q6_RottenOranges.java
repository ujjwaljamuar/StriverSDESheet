package BFSDFS;

import java.util.LinkedList;
import java.util.Queue;

public class Q6_RottenOranges {
    int rottingOranges(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int count_fresh = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] { i, j });
                }

                if (grid[i][j] != 0) {
                    count_fresh++;
                }
            }
        }

        if (count_fresh == 0)
            return 0;

        int countMin = 0, count = 0;

        int[] delrow = { -1, 0, 1, 0 };
        int[] delcol = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            int size = q.size();

            count += size;

            for (int i = 0; i < size; i++) {
                int[] loc = q.poll();

                for (int j = 0; j < 4; j++) {
                    int x = loc[0] + delrow[j];
                    int y = loc[1] + delcol[j];

                    if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }

                    grid[x][y] = 2;

                    q.offer(new int[] { x, y });
                }
            }

            if (q.size() != 0) {
                countMin++;
            }
        }

        return count_fresh == count ? countMin : -1;
    }

    public static void main(String[] args) {
        Q6_RottenOranges graph = new Q6_RottenOranges();

        int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };

        System.out.println(graph.rottingOranges(grid));
    }
}

// class Pairr {
// int row, col, time;

// public Pairr(int _row, int _col, int _time) {
// this.row = _row;
// this.col = _col;
// this.time = _time;
// }
// }