package DP;

import java.util.Arrays;

public class Q7_UniquePaths {
    int findPaths(int i, int j) {
        // base case
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i < 0 || j < 0) {
            return 0;
        }

        // one for going down
        int left = findPaths(i, j - 1);
        // one for going right
        int up = findPaths(i - 1, j);

        return left + up;
    }

    public int uniquePaths(int m, int n) {
        return findPaths(m - 1, n - 1);
    }

    int findPathsMem(int i, int j, int[][] dp) {
        // base case
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int left = findPathsMem(i, j - 1, dp);
        int up = findPathsMem(i - 1, j, dp);

        return dp[i][j] = left + up;
    }

    public int uniquePathsMem(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }

        return findPathsMem(m - 1, n - 1, dp);
    }

    public int uniquePathsOpt(int m, int n) {
        // return util(0,0,m,n);

        // return (int) combination(m + n - 2, Math.min(m - 1, n - 1));

        int N = n + m - 2;
            int r = m - 1; 
            double res = 1;
            
            for (int i = 1; i <= r; i++)
                res = res * (N - r + i) / i;
            return (int)res;
    }
}
