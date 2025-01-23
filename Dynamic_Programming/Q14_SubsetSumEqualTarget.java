public class Q14_SubsetSumEqualTarget {

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
        return isSubsetSumRec(arr, arr.length - 1, target);
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
