import java.util.Arrays;

public class Q7_MinimumPathSum {
    int findPathSumTab(int n, int m, int[][] matrix) {
        int dp[][] = new int[n][m];

        // Iterate through the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = matrix[i][j]; // If we're at the top-left cell, the minimum sum is its value
                else {
                    int up = matrix[i][j];
                    if (i > 0)
                        up += dp[i - 1][j]; // Add the value from above if it's not out of bounds
                    else
                        up += (int) Math.pow(10, 9); // Add a large value if out of bounds in the up direction

                    int left = matrix[i][j];
                    if (j > 0)
                        left += dp[i][j - 1]; // Add the value from the left if it's not out of bounds
                    else
                        left += (int) Math.pow(10, 9); // Add a large value if out of bounds in the left direction

                    // Store the minimum of the two possible paths
                    dp[i][j] = Math.min(up, left);
                }
            }
        }

        // The final result is stored in the bottom-right cell of the DP matrix
        return dp[n - 1][m - 1];
    }

    int findPathSumMem(int i, int j, int[][] grid, int[][] dp) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }

        if (i < 0 || j < 0) {
            return (int) Math.pow(10, 9);
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = grid[i][j] + findPathSumMem(i - 1, j, grid, dp);
        int left = grid[i][j] + findPathSumMem(i, j - 1, grid, dp);

        return dp[i][j] = Math.min(up, left);
    }

    int findPathSumRec(int i, int j, int[][] grid) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }

        // return a large value so it can never be considered in math.min
        if (i < 0 || j < 0) {
            return (int) Math.pow(10, 9);
        }

        int up = grid[i][j] + findPathSumRec(i - 1, j, grid);
        int left = grid[i][j] + findPathSumRec(i, j - 1, grid);

        return Math.min(up, left);
    }

    int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }

        // return findPathSumRec(m - 1, n - 1, grid);

        // return findPathSumMem(m - 1, n - 1, grid, dp);

        return findPathSumTab(m , n, grid);
    }

    public static void main(String[] args) {
        Q7_MinimumPathSum dp = new Q7_MinimumPathSum();

        int[][] grid = {
                { 5, 0, 1, 1, 2, 1, 0, 1, 3, 6, 3, 0, 7, 3, 3, 3, 1 },
                { 1, 4, 1, 8, 5, 5, 5, 6, 8, 7, 0, 4, 3, 9, 9, 6, 0 },
                { 2, 8, 3, 3, 1, 6, 1, 4, 9, 0, 9, 2, 3, 3, 3, 8, 4 },
                { 3, 5, 1, 9, 3, 0, 8, 3, 4, 3, 4, 6, 9, 6, 8, 9, 9 },
                { 3, 0, 7, 4, 6, 6, 4, 6, 8, 8, 9, 3, 8, 3, 9, 3, 4 },
                { 8, 8, 6, 8, 3, 3, 1, 7, 9, 3, 3, 9, 2, 4, 3, 5, 1 },
                { 7, 1, 0, 4, 7, 8, 4, 6, 4, 2, 1, 3, 7, 8, 3, 5, 4 },
                { 3, 0, 9, 6, 7, 8, 9, 2, 0, 4, 6, 3, 9, 7, 2, 0, 7 },
                { 8, 0, 8, 2, 6, 4, 4, 0, 9, 3, 8, 4, 0, 4, 7, 0, 4 },
                { 3, 7, 4, 5, 9, 4, 9, 7, 9, 8, 7, 4, 0, 4, 2, 0, 4 },
                { 5, 9, 0, 1, 9, 1, 5, 9, 5, 5, 3, 4, 6, 9, 8, 5, 6 },
                { 5, 7, 2, 4, 4, 4, 2, 1, 8, 4, 8, 0, 5, 4, 7, 4, 7 },
                { 9, 5, 8, 6, 4, 4, 3, 9, 8, 1, 1, 8, 7, 7, 3, 6, 9 },
                { 7, 2, 3, 1, 6, 3, 6, 6, 6, 3, 2, 3, 9, 9, 4, 4, 8 }
        };

        System.out.println(dp.minPathSum(grid));
    }
}
