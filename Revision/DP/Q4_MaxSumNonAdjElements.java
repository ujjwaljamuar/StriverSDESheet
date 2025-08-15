package DP;

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

    public static void main(String[] args) {
        int[] nums = {
                114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90,
                222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169,
                241, 202, 144, 240 }; // return 4173
        // int[] nums = { 2, 7, 9, 3, 1 };

        System.out.println(houseRobber(nums));
    }
}
