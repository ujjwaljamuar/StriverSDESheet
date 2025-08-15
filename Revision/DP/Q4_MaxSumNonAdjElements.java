package DP;

import java.util.Arrays;

// House Robber - I
public class Q4_MaxSumNonAdjElements {
    static int robUtil(int index, int[] nums) {
        if (index == 0) {
            return nums[index];
        }

        // edge case if it go below 0 because of ind - 2
        if (index < 0) {
            return 0;
        }

        int pick = nums[index] + robUtil(index - 2, nums);

        int notPick = 0 + robUtil(index - 1, nums);

        return Math.max(pick, notPick);
    }

    static int houseRobber(int[] nums) {
        return robUtil(nums.length - 1, nums);
    }

    // memoization
    static int robUtilMem(int index, int[] nums, int[] dp) {
        if (index == 0) {
            return nums[index];
        }

        // edge case if it go below 0 because of ind - 2
        if (index < 0) {
            return 0;
        }

        // if element exists in dp array
        if (dp[index] != -1) {
            return dp[index];
        }

        int pick = nums[index] + robUtilMem(index - 2, nums, dp);

        int notPick = 0 + robUtilMem(index - 1, nums, dp);

        return dp[index] = Math.max(pick, notPick);
    }

    static int houseRobberMem(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return robUtilMem(nums.length - 1, nums, dp);
    }

    // Tabulation
    static int robUtilTab(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        // in tabulation we go from bottom to up, so we will start from 0;
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int pick = nums[i];
            if (i > 1) {
                pick = pick + dp[i - 2];
            }

            int notPick = 0 + dp[i - 1];

            dp[i] = Math.max(pick, notPick);
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {
                114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90,
                222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169,
                241, 202, 144, 240 }; // return 4173
        // int[] nums = { 2, 7, 9, 3, 1 };

        System.out.println(robUtilTab(nums));
    }
}
