package ShortestPath;

import java.util.LinkedList;
import java.util.Queue;

public class Q5_ShortestPathBinaryGrid {
    int ShortestPath(int[] src, int[] desn, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = (int) 1e9;
            }
        }

        dist[src[0]][src[1]] = 0;

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src[0], src[1]));

        int dr[] = { -1, 0, 1, 0 };
        int dc[] = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            Tuple tuple = q.peek();
            q.remove();

            int dis = tuple.distance;
            int r = tuple.row;
            int c = tuple.col;

            for (int i = 0; i < 4; i++) {
                int nRow = r + dr[i];
                int nCol = c + dc[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1
                        && dis + 1 < dist[nRow][nCol]) {
                    dist[nRow][nCol] = 1 + dis;

                    if (nRow == desn[0] && nCol == desn[1]) {
                        // if source is also considered distance
                        // return dist[nRow][nCol] + 1;3

                        // if not
                        return dis + 1;
                    }

                    q.add(new Tuple(dis + 1, nRow, nCol));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Q5_ShortestPathBinaryGrid graph = new Q5_ShortestPathBinaryGrid();

        int[] source = { 0, 1 };
        int[] destination = { 2, 2 };

        int[][] grid = {
                { 1, 1, 1, 1 },
                { 1, 1, 0, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 0, 0 },
                { 1, 0, 0, 1 }
        };

        System.out.println(graph.ShortestPath(source, destination, grid));
    }

    class Tuple {
        int distance, row, col;

        Tuple(int _d, int _r, int _c) {
            this.distance = _d;
            this.row = _r;
            this.col = _c;
        }
    }
}
