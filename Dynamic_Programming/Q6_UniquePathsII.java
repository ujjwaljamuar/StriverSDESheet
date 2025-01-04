import java.util.Arrays;

public class Q6_UniquePathsII {
    int findPathsOpt(int n, int m, int[][] maze) {
        // Initialize the previous row of the DP matrix
        int prev[] = new int[n];

        for (int i = 0; i < n; i++) {
            // Create a temporary array for the current row
            int temp[] = new int[m];

            for (int j = 0; j < m; j++) {
                // Base conditions
                if (i > 0 && j > 0 && maze[i][j] == 1) {
                    temp[j] = 0; // If there's an obstacle, no paths can go through here.
                    continue;
                }
                if (i == 0 && j == 0) {
                    temp[j] = 1; // There's one valid path to the start cell.
                    continue;
                }

                int up = 0;
                int left = 0;

                // Check if moving up is possible
                if (i > 0)
                    up = prev[j];

                // Check if moving left is possible
                if (j > 0)
                    left = temp[j - 1];

                // Calculate the number of paths by adding paths from above and from the left
                temp[j] = up + left;
            }

            // Update the previous row with the values of the current row
            prev = temp;
        }

        // The final result is stored in the last element of the previous row
        return prev[n - 1];
    }

    int findPathsTab(int n, int m, int[][] maze, int[][] dp) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Base conditions
                if (i > 0 && j > 0 && maze[i][j] == 1) {
                    dp[i][j] = 0; // If there's an obstacle, no paths can go through here.
                    continue;
                }
                if (i == 0 && j == 0) {
                    dp[i][j] = 1; // There's one valid path to the start cell.
                    continue;
                }

                int up = 0;
                int left = 0;

                // Check if moving up is possible
                if (i > 0)
                    up = dp[i - 1][j];

                // Check if moving left is possible
                if (j > 0)
                    left = dp[i][j - 1];

                // Calculate the number of paths by adding paths from above and from the left
                dp[i][j] = up + left;
            }
        }

        // The final result is stored in the bottom-right cell of the DP matrix
        return dp[n - 1][m - 1];
    }

    int findPathsMem(int i, int j, int[][] grid, int[][] dp) {
        if (i >= 0 && j >= 0 && grid[i][j] == 1) {
            return 0;
        }

        if (i == 0 && j == 0) {
            return 1;
        }

        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = findPathsMem(i - 1, j, grid, dp);
        int left = findPathsMem(i, j - 1, grid, dp);

        return dp[i][j] = up + left;
    }

    int findPaths(int i, int j, int[][] grid) {
        if (i >= 0 && j >= 0 && grid[i][j] == 1) {
            return 0;
        }

        if (i == 0 && j == 0) {
            return 1;
        }

        if (i < 0 || j < 0) {
            return 0;
        }

        int up = findPaths(i - 1, j, grid);
        int left = findPaths(i, j - 1, grid);

        return up + left;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }

        // return findPaths(m - 1, n - 1, obstacleGrid);
        // return findPathsMem(m - 1, n - 1, obstacleGrid, dp);
        // return findPathsTab(m, n, obstacleGrid, dp);
        return findPathsOpt(m, n, obstacleGrid);
    }

    public static void main(String[] args) {
        Q6_UniquePathsII dp = new Q6_UniquePathsII();

        int[][] grid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };

        System.out.println(dp.uniquePathsWithObstacles(grid));
    }
}
