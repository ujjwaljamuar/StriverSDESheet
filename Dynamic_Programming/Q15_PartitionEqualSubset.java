public class Q15_PartitionEqualSubset {
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

            return isSubsetSumRec(arr, arr.length - 1, k);
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
