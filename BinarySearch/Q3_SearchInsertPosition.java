public class Q3_SearchInsertPosition {
    static int searchInsert(int[] arr, int n, int target) {
        int low = 0, mid, high = n - 1, ans = n;

        while (low <= high) {
            mid = low + ((high - low) / 2);
            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 6 };
        System.out.println(searchInsert(arr, arr.length, 2));
    }
}

/*
 * 
 * same as lower bound - >=
 * 
 * Given a sorted array of distinct integers and a target value, return the
 * index if the target is found. If not, return the index where it would be if
 * it were inserted in order.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 * 
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 * 
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 */