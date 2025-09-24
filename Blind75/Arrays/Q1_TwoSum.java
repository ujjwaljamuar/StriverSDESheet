package Arrays;

import java.util.Arrays;
import java.util.Stack;

public class Q1_TwoSum {
    int[] twoSumOpt(int[] nums, int target) {
        Arrays.sort(nums);

        int left = 0, right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[] { left, right };
            } else if (sum < target) {
                left++;
            } else {
                right++;
            }
        }

        return new int[] {};
    }

    int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Q1_TwoSum b75 = new Q1_TwoSum();

        int[] nums = { 3, 2, 4 };
        int target = 6;

        System.out.println(Arrays.toString(b75.twoSumOpt(nums, target)));
    }
}