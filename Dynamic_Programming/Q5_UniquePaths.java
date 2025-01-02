import java.util.Arrays;

public class Q5_UniquePaths {

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
        return countWaysUtilRec(m - 1, n - 1);
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