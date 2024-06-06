package ShortestPath;

import java.util.PriorityQueue;

public class Q6_MinimumEffortGrid {
    int minimumEffort(int[][] heights) {
        int n = heights.length;
        int m = heights.length;

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = (int) 1e9;
            }
        }

        dist[0][0] = 0;

        PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        pq.add(new Tuple(0, 0, 0));

        int dr[] = { -1, 0, 1, 0 };
        int dc[] = { 0, 1, 0, -1 };

        while (!pq.isEmpty()) {
            Tuple tup = pq.peek();
            pq.remove();

            int diff = tup.distance;
            int r = tup.row;
            int c = tup.column;

            if (r == n - 1 && c == m - 1) {
                return diff;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int newEffort = Math.max(Math.abs(heights[r][c] - heights[nr][nc]), diff);

                    if (newEffort < dist[nr][nc]) {
                        dist[nr][nc] = newEffort;

                        pq.add(new Tuple(newEffort, nr, nc));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Q6_MinimumEffortGrid graph = new Q6_MinimumEffortGrid();

        int[][] heights = { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } };

        System.out.print(graph.minimumEffort(heights));
    }

    private class Tuple {
        int distance, row, column;

        Tuple(int _d, int _r, int _c) {
            this.distance = _d;
            this.row = _r;
            this.column = _c;
        }
    }
}
