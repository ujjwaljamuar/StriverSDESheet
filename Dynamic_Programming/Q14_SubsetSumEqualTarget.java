import java.util.Arrays;

public class Q14_SubsetSumEqualTarget {
    boolean isSubsetSumTab(int n, int k, int[] arr) {
        // Create a boolean DP table with dimensions [n][k+1]
        boolean dp[][] = new boolean[n][k + 1];

        // Initialize the first row of the DP table
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Initialize the first column of the DP table
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        // Fill in the DP table using bottom-up approach
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                // Calculate if the current target can be achieved without taking the current
                // element
                boolean notTaken = dp[ind - 1][target];

                // Calculate if the current target can be achieved by taking the current element
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }

                // Store the result in the DP table
                dp[ind][target] = notTaken || taken;
            }
        }

        // The final result is stored in the bottom-right cell of the DP table
        return dp[n - 1][k];
    }

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

        // return isSubsetSumMem(arr, arr.length - 1, target, dp);

        return isSubsetSumTab(arr.length, target, arr);
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
