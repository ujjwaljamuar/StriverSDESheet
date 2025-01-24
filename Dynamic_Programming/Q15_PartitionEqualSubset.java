import java.util.Arrays;

public class Q15_PartitionEqualSubset {
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

        boolean notTake = isSubsetSumMem(arr, index - 1, target, dp);
        boolean take = false;

        if (target >= arr[index]) {
            take = isSubsetSumMem(arr, index - 1, target - arr[index], dp);
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

    boolean canPartition(int[] arr) {
        int totSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totSum += arr[i];
        }

        if (totSum % 2 == 1) {
            return false;
        } else {
            int k = totSum / 2;

            int[][] dp = new int[arr.length][k + 1];
            for (int[] rows : dp) {
                Arrays.fill(rows, -1);
            }

            // return isSubsetSumRec(arr, arr.length - 1, k);

            return isSubsetSumMem(arr, arr.length - 1, k, dp);
        }
    }

    public static void main(String[] args) {
        Q15_PartitionEqualSubset dp = new Q15_PartitionEqualSubset();

        int[] arr = { 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 97 };

        System.out.println(dp.canPartition(arr));
    }
}
