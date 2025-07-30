package DP;

import java.util.Arrays;

public class LongestIncreasingSequence {
    // Function to find the length of the longest increasing subsequence
    static int getAns(int arr[], int n, int ind, int prev_index, int[][] dp) {
        // Base condition
        if (ind == n) {
            return 0;
        }

        if (dp[ind][prev_index + 1] != -1) {
            return dp[ind][prev_index + 1];
        }

        int notTake = 0 + getAns(arr, n, ind + 1, prev_index, dp);

        int take = 0;

        if (prev_index == -1 || arr[ind] > arr[prev_index]) {
            take = 1 + getAns(arr, n, ind + 1, ind, dp);
        }

        dp[ind][prev_index + 1] = Math.max(notTake, take);

        return dp[ind][prev_index + 1];
    }

    // Function to find the length of the longest increasing subsequence
    static int longestIncreasingSubsequence(int arr[], int n) {
        int dp[][] = new int[n][n + 1];

        // Initialize dp array with -1 to mark states as not calculated yet
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return getAns(arr, n, 0, -1, dp);
    }

    // Recursion
    static int LISUtil(int index, int prev_index, int[] nums) {
        if (index == nums.length) {
            return 0;
        }

        int notTake = 0 + LISUtil(index + 1, prev_index, nums);

        int take = 0;
        if (prev_index == -1 || nums[index] > nums[prev_index]) {
            take = 1 + LISUtil(index + 1, index, nums);
        }

        return Math.max(notTake, take);
    }

    static int LIS(int[] nums) {
        return LISUtil(0, -1, nums);
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 3, 2, 3 };

        System.out.println(LIS(nums));
    }
}
