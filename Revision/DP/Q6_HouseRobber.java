package DP;

import java.util.Arrays;

public class Q6_HouseRobber {
    int robUtil(int index, int[] nums) {
        if (index == 0) {
            return nums[index];
        }

        if (index <= 0) {
            return 0;
        }

        int pick = nums[index] + robUtil(index - 2, nums);

        int notPick = 0 + robUtil(index - 1, nums);

        return Math.max(pick, notPick);
    }

    public int rob(int[] nums) {
        return robUtil(nums.length - 1, nums);
    }

    int robUtilMem(int index, int[] nums, int[] dp) {
        if (index == 0) {
            return nums[index];
        }

        if (index <= 0) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int pick = nums[index] + robUtilMem(index - 2, nums, dp);

        int notPick = 0 + robUtilMem(index - 1, nums, dp);
        dp[index] = Math.max(pick, notPick);

        return dp[index];
    }

    public int robMem(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return robUtilMem(nums.length - 1, nums, dp);
    }

    int robOpt(int[] nums) {
        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i < nums.length; i++) {
            int take = nums[i];
            if (i > 1) {
                take += prev2;
            }

            int nottake = 0 + prev;
            int curri = Math.max(take, nottake);

            prev2 = prev;
            prev = curri;
        }
        return prev;
    }

    public static void main(String[] args) {
        Q6_HouseRobber dp = new Q6_HouseRobber();

        int[] nums = { 2, 7, 9, 3, 1 };

        System.out.println(dp.rob(nums));
    }
}
