package DP;

import java.util.Arrays;

public class Q2_CoinChange2 {
    /*
     * Optimized
     * Time Complexity: O(N*T)
     * Reason: There are two nested loops.
     * Space Complexity: O(T)
     * Reason: We are using an external array of size ‘T+1’ to store two rows only.
     */
    static long countWaysToMakeChangeOpt(int[] arr, int n, int T) {
        // Create an array to store results of subproblems for the previous element
        long[] prev = new long[T + 1];

        // Initialize base condition for the first element of the array
        for (int i = 0; i <= T; i++) {
            if (i % arr[0] == 0)
                prev[i] = 1;
            // Else condition is automatically fulfilled, as prev array is initialized to
            // zero
        }

        // Fill the prev array using dynamic programming
        for (int ind = 1; ind < n; ind++) {
            // Create an array to store results of subproblems for the current element
            long[] cur = new long[T + 1];
            for (int target = 0; target <= T; target++) {
                long notTaken = prev[target];

                long taken = 0;
                if (arr[ind] <= target)
                    taken = cur[target - arr[ind]];

                cur[target] = notTaken + taken;
            }
            prev = cur;
        }

        return prev[T];
    }

    /*
     * Tabulation
     * Time Complexity: O(N*T)
     * Reason: There are two nested loops
     * Space Complexity: O(N*T)
     * Reason: We are using an external array of size ‘N*T’. Stack Space is
     * eliminated.
     */

    static long countWaysToMakeChangeTab(int[] arr, int n, int T) {
        // Create a 2D array to store results of subproblems
        long dp[][] = new long[n][T + 1];

        // Initialize base condition for the first element of the array
        for (int i = 0; i <= T; i++) {
            if (i % arr[0] == 0)
                dp[0][i] = 1;
            // Else condition is automatically fulfilled, as dp array is initialized to zero
        }

        // Fill the dp array using dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= T; target++) {
                long notTaken = dp[ind - 1][target];

                long taken = 0;
                if (arr[ind] <= target)
                    taken = dp[ind][target - arr[ind]];

                dp[ind][target] = notTaken + taken;
            }
        }

        return dp[n - 1][T];
    }

    /*
     * Memoization
     * Time Complexity: O(N*T)
     * Reason: There are N*W states therefore at max ‘N*T’ new problems will be
     * solved.
     * Space Complexity: O(N*T) + O(N)
     * Reason: We are using a recursion stack space(O(N)) and a 2D array ( O(N*T)).
     */
    static long countWaysToMakeChangeUtilMem(int[] arr, int ind, int T, long[][] dp) {
        // Base case: If the current index is 0
        if (ind == 0) {
            // If T is divisible by the first element of the array, return 1, else return 0
            if (T % arr[0] == 0)
                return 1;
            else
                return 0;
        }

        // If the result for this subproblem has already been calculated, return it
        if (dp[ind][T] != -1)
            return dp[ind][T];

        // Calculate the number of ways without taking the current element
        long notTaken = countWaysToMakeChangeUtilMem(arr, ind - 1, T, dp);

        // Initialize the number of ways taking the current element as 0
        long taken = 0;

        // If the current element is less than or equal to T, calculate 'taken'
        if (arr[ind] <= T)
            taken = countWaysToMakeChangeUtilMem(arr, ind, T - arr[ind], dp);

        // Store the result in the dp array and return it
        return dp[ind][T] = notTaken + taken;
    }

    // Function to count the ways to make change
    static long countWaysToMakeChange(int[] arr, int n, int T) {
        // Create a 2D array to store results of subproblems
        long dp[][] = new long[n][T + 1];

        // Initialize the dp array with -1 to indicate that subproblems are not solved
        // yet
        for (long row[] : dp)
            Arrays.fill(row, -1);

        // Call the countWaysToMakeChangeUtil function to calculate the number of ways
        return countWaysToMakeChangeUtilMem(arr, n - 1, T, dp);
    }

    // Recursion
    static int countWaysToMakeChangeUtilRec(int index, int[] arr, int target) {
        if (index == 0) {
            return (target % arr[0] == 0) ? 1 : 0;
        }

        // not take
        // going back index because started from n-1
        int notTake = countWaysToMakeChangeUtilRec(index - 1, arr, target);

        int take = 0;
        // stay at same index because you might end up using same coin twice
        // only take if coin is less than equal target
        if (arr[index] <= target) {
            take = countWaysToMakeChangeUtilRec(index, arr, target - arr[index]);
        }

        return take + notTake;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3 };
        int target = 4;
        int n = arr.length;

        // Call the countWaysToMakeChange function and print the result
        // System.out.println("The total number of ways is " +
        // countWaysToMakeChange(arr, n, target));
        System.out.println("The total number of ways is " + countWaysToMakeChangeUtilRec(n-1, arr, target));
    }
}
