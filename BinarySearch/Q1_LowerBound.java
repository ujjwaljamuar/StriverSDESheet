public class Q1_LowerBound {

    static int lowerBound(int[] arr, int n, int target) {
        int mid, start = 0, end = n - 1, ans = n;

        while (start <= end) {
            mid = start + ((end - start) >> 1);

            if (arr[mid] >= target) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 3, 5, 8, 8, 10, 10, 11 };
        System.out.println(lowerBound(arr, arr.length, 9));
    }
}

/*
 * Q - lowerBound >=
 * 
 * You are given an array 'arr' sorted in non-decreasing order and a number 'x'.
 * 
 * You must return the index of lower bound of 'x'.
 * 
 * Note:
 * For a sorted array 'arr', 'lower_bound' of a number 'x' is defined as the
 * smallest index 'idx' such that the value 'arr[idx]' is not less than 'x'
 * 
 * If all numbers are smaller than 'x', then 'n' should be the 'lower_bound' of
 * 'x', where 'n' is the size of array.
 */