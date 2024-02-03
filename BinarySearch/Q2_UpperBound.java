public class Q2_UpperBound {
    static int upperBound(int[] arr, int target, int n) {
        int mid, low = 0, high = n - 1, ans = n;

        while (low <= high) {
            mid = low + ((high - low) / 2);

            if (arr[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 5, 7, 7, 9, 10 };
        System.out.println(upperBound(arr, 5, arr.length));
    }
}

/*
 * 
 * UpperBound - >
 * 
 * You are given a sorted array ‘arr’ containing ‘n’ integers and an integer
 * ‘x’.
 * 
 * Implement the ‘upperBound’ function to find the index of the upper bound of
 * 'x' in the array.
 * Note:
 * The upper bound in a sorted array is the index of the first value that is
 * greater than a given value.
 * If the greater value does not exist then the answer is 'n', Where 'n' is the
 * size of the array.
 * We are using 0-based indexing.
 * Try to write a solution that runs in log(n) time complexity.
 */