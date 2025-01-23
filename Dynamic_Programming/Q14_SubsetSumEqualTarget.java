import java.util.Arrays;

public class Q14_SubsetSumEqualTarget {
    boolean isSubsetSumMem(int[] arr, int index, int target, int[][] dp) {
        if (target == 0) {
            return true;
        }

        if (index == 0) {
            return arr[0] == target;
        }

        if (dp[index][target] != -1) {
            return dp[index][target] == 0 ? false : true;
        }

        boolean notTake = isSubsetSumRec(arr, index - 1, target);
        boolean take = false;

        if (target >= arr[index]) {
            take = isSubsetSumRec(arr, index - 1, target - arr[index]);
        }

        dp[index][target] = take || notTake ? 0 : 1;
        return take || notTake;
    }

    boolean isSubsetSumRec(int[] arr, int index, int target) {
        if (target == 0) {
            return true;
        }

        if (index == 0) {
            return arr[0] == target;
        }

        boolean notTake = isSubsetSumRec(arr, index - 1, target);
        boolean take = false;

        if (target >= arr[index]) {
            take = isSubsetSumRec(arr, index - 1, target - arr[index]);
        }

        return take || notTake;
    }

    boolean isSubsetSum(int[] arr, int target) {
        int[][] dp = new int[arr.length][target + 1];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }

        // return isSubsetSumRec(arr, arr.length - 1, target);

        return isSubsetSumMem(arr, arr.length - 1, target, dp);

    }

    public static void main(String[] args) {
        Q14_SubsetSumEqualTarget dp = new Q14_SubsetSumEqualTarget();

        // int[] arr = { 3, 34, 4, 12, 5, 2 };
        // int target = 9;
        int[] arr = { 3, 34, 4, 12, 5, 2 };
        int target = 30;

        System.out.println(dp.isSubsetSum(arr, target));

    }
}
