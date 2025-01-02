import java.util.Arrays;

public class Q5_UniquePaths {
    int countWaysUtilOpt(int m, int n) {
        // Create an array to store the results for the previous row
        int prev[] = new int[n];

        for (int i = 0; i < m; i++) {
            // Create a temporary array to store the results for the current row
            int temp[] = new int[n];

            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    // Base condition: There's one way to reach the top-left cell (0, 0)
                    temp[j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;

                // Calculate the number of ways by moving up (if possible) and left (if
                // possible)
                if (i > 0)
                    up = prev[j];
                if (j > 0)
                    left = temp[j - 1];

                // Store the total number of ways to reach the current cell in the temporary
                // array
                temp[j] = up + left;
            }

            // Set the temporary array as the previous array for the next row
            prev = temp;
        }

        // Return the number of ways to reach the bottom-right cell (m-1, n-1)
        return prev[n - 1];
    }

    int countWaysUtilTab(int m, int n) {
        int[][] dp = new int[m][n];
        // Loop through each cell in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Base condition: If we are at the top-left cell (0, 0), there's one way to
                // reach it.
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                }

                else {
                    int up = 0;
                    int left = 0;

                    // Calculate the number of ways by moving up (if possible) and left (if
                    // possible)
                    if (i > 0)
                        up = dp[i - 1][j];
                    if (j > 0)
                        left = dp[i][j - 1];

                    // Store the total number of ways to reach the current cell in the DP array
                    dp[i][j] = up + left;
                }
            }
        }

        // Return the number of ways to reach the bottom-right cell (m-1, n-1)
        return dp[m - 1][n - 1];
    }

    int countWaysUtilMem(int i, int j, int[][] dp) {
        if (i == 0 && j == 0) {
            return 1;
        }

        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int left = countWaysUtilRec(i, j - 1);
        int up = countWaysUtilRec(i - 1, j);

        return dp[i][j] = left + up;
    }

    int countWaysUtilRec(int i, int j) {
        if (i == 0 && j == 0) {
            return 1;
        }

        if (i < 0 || j < 0) {
            return 0;
        }

        int left = countWaysUtilRec(i, j - 1);
        int up = countWaysUtilRec(i - 1, j);

        return left + up;
    }

    int countWays(int m, int n) {
        // Start the recursive calculation from the bottom-right cell (m-1, n-1)
        // return countWaysUtilRec(m - 1, n - 1);

        // Memoization
        // Create a 2D DP array to store the results
        int dp[][] = new int[m][n];

        // Initialize the DP array with -1 to indicate uncomputed values
        for (int[] row : dp)
            Arrays.fill(row, -1);

        // return countWaysUtilMem(m - 1, n - 1, dp);

        // return countWaysUtilTab(m, n);

        return countWaysUtilOpt(m, n);

    }

    public static void main(String[] args) {
        Q5_UniquePaths dp = new Q5_UniquePaths();

        int m = 3;
        int n = 2;

        // Call the countWays function and print the result
        System.out.println(dp.countWays(m, n));
    }
}

/*
 * - Recursion
 * Time Complexity: 2^mxn
 * Space Complexity: O(Path)
 * 
 * - Memoization
 * Time Complexity: O(mxn)
 * Space Complexity: O(Paths)
 * 
 * - Tabulation
 * Time Complexity: O(mxn)
 * Space Complexity: O(mxn)
 * 
 * - Space Optimized
 * Time Complexity: O(mxn)
 * Space Complexity: O(N)
 * 
 */