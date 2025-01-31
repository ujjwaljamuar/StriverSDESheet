import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q9_MinimumPathSumII {
    int findPathSumOpt(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        List<Integer> prev = new ArrayList<>(Collections.nCopies(m, 0));
        List<Integer> cur = new ArrayList<>(Collections.nCopies(m, 0));

        // Initializing the first row - base condition
        for (int j = 0; j < m; j++) {
            prev.set(j, matrix[0][j]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + prev.get(j);

                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += prev.get(j - 1);
                } else {
                    leftDiagonal += (int) 1e9;
                }

                int rightDiagonal = matrix[i][j];
                if (j + 1 < m) {
                    rightDiagonal += prev.get(j + 1);
                } else {
                    rightDiagonal += (int) 1e9;
                }

                // Store the maximum of the three paths in cur
                cur.set(j, Math.min(up, Math.min(leftDiagonal, rightDiagonal)));
            }

            // Update the prev list with the values from the cur list for the next row
            prev = new ArrayList<>(cur);
        }

        int mini = Integer.MAX_VALUE;

        for (int j = 0; j < m; j++) {
            mini = Math.min(mini, prev.get(j));
        }

        return mini;
    }

    int findPathSumTab(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];

        // Initializing the first row - base condition
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Calculate the maximum path sum for each cell in the matrix
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + dp[i - 1][j];

                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += dp[i - 1][j - 1];
                } else {
                    leftDiagonal += (int) Math.pow(10, 9);
                }

                int rightDiagonal = matrix[i][j];
                if (j + 1 < m) {
                    rightDiagonal += dp[i - 1][j + 1];
                } else {
                    rightDiagonal += (int) Math.pow(10, 9);
                }

                // Store the maximum of the three paths in dp
                dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
        }

        // Find the maximum value in the last row of dp
        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            mini = Math.min(mini, dp[n - 1][j]);
        }

        return mini;
    }

    int findPathSumMem(int i, int j, int[][] grid, int n, int m, int[][] dp) {
        if (j < 0 || j >= m) {
            return (int) 1e9;
        }

        if (i == 0) {
            return grid[0][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = grid[i][j] + findPathSumMem(i - 1, j, grid, n, m, dp);
        int upl = grid[i][j] + findPathSumMem(i - 1, j - 1, grid, n, m, dp);
        int upr = grid[i][j] + findPathSumMem(i - 1, j + 1, grid, n, m, dp);

        return dp[i][j] = Math.min(up, Math.min(upl, upr));
    }

    int findPathSumRec(int i, int j, int[][] grid, int n, int m) {
        if (j < 0 || j >= m) {
            return (int) 1e9;
        }

        if (i == 0) {
            return grid[0][j];
        }

        int up = grid[i][j] + findPathSumRec(i - 1, j, grid, n, m);
        int upl = grid[i][j] + findPathSumRec(i - 1, j - 1, grid, n, m);
        int upr = grid[i][j] + findPathSumRec(i - 1, j + 1, grid, n, m);

        return Math.min(up, Math.min(upl, upr));
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int mini = (int) 1e9;

        int dp[][] = new int[n][m];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // for (int j = 0; j < m; j++) {
        // mini = Math.min(mini, findPathSumRec(n - 1, j, matrix, n, m));
        // }

        // for (int j = 0; j < m; j++) {
        // mini = Math.min(mini, findPathSumMem(n - 1, j, matrix, n, m, dp));
        // }

        // return mini;

        // return findPathSumTab(matrix);

        return findPathSumOpt(matrix);
    }

    public static void main(String[] args) {
        Q9_MinimumPathSumII dp = new Q9_MinimumPathSumII();

        int[][] array = {
                { -19, -1, -96, 48, -94, 36, 16, 55, -42, 37, -59, 6, -32, 96, 95, -58, 13, -34, 94, 85 },
                { 17, 44, 36, -29, 84, 80, -34, 50, -99, 64, 13, 91, -27, 25, -36, 57, 20, 98, -100, -72 },
                { -92, -75, 86, 90, -4, 90, 64, 56, 50, -63, 10, -15, 90, -66, -66, 32, -69, -78, 1, 60 },
                { 21, 51, -47, -43, -14, 99, 44, 90, 8, 11, 99, -62, 57, 59, 69, 50, -69, 32, 85, 13 },
                { -28, 90, 12, -18, 23, 61, -55, -97, 6, 89, 36, 26, 26, -1, 46, -50, 79, -45, 89, 86 },
                { -85, -10, 49, -10, 2, 62, 41, 92, -67, 85, 86, 27, 89, -50, 77, 55, 22, -82, -94, -98 },
                { -50, 53, -23, 55, 25, -22, 76, -93, -7, 66, -75, 42, -35, -96, -5, 4, -92, 13, -31, -100 },
                { -62, -78, 8, -92, 86, 69, 90, -37, 81, 97, 53, -45, 34, 19, -19, -39, -88, -75, -74, -4 },
                { 29, 53, -91, 65, -92, 11, 49, 26, 90, -31, 17, -84, 12, 63, -60, -48, 40, -49, -48, 88 },
                { 100, -69, 80, 11, -93, 17, 28, -94, 52, 64, -86, 30, -9, -53, -8, -68, -33, 31, -5, 11 },
                { 9, 64, -31, 63, -84, -15, -30, -10, 67, 2, 98, 73, -77, -37, -96, 47, -97, 78, -62, -17 },
                { -88, -38, -22, -90, 54, 42, -29, 67, -85, -90, -29, 81, 52, 35, 13, 61, -18, -94, 61, -62 },
                { -23, -29, -76, -30, -65, 23, 31, -98, -9, 11, 75, -1, -84, -90, 73, 58, 72, -48, 30, -81 },
                { 66, -33, 91, -6, -94, 82, 25, -43, -93, -25, -69, 10, -71, -65, 85, 28, -52, 76, 25, 90 },
                { -3, 78, 36, -92, -52, -44, -66, -53, -55, 76, -7, 76, -73, 13, -98, 86, -99, -22, 61, 100 },
                { -97, 65, 2, -93, 56, -78, 22, 56, 35, -24, -95, -13, 83, -34, -51, -73, 2, 7, -86, -19 },
                { 32, 94, -14, -13, -6, -55, -21, 29, -21, 16, 67, 100, 77, -26, -96, 22, -5, -53, -92, -36 },
                { 60, 93, -79, 76, -91, 43, -95, -16, 74, -21, 85, 43, 21, -68, -32, -18, 18, 100, -43, 1 },
                { 87, -31, 26, 53, 26, 51, -61, 92, -65, 17, -41, 27, -42, -14, 37, -46, 46, -31, -74, 23 },
                { -67, -14, -20, -85, 42, 36, 56, 9, 11, -66, -59, -55, 5, 64, -29, 77, 47, 44, -33, -77 }
        };

        System.out.println(dp.minFallingPathSum(array)); // -1428
    }
}
