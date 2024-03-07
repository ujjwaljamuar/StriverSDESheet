public class Q7_SearchInRotatedSortedArray {
    int search(int[] arr, int n, int target) {
        int low = 0, mid, high = n - 1;

        while (low <= high) {
            mid = low + ((high - low) / 2);

            if (arr[mid] == target) {
                return mid;
            }

            // left part sorted
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && target <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            // right part is sorted
            else {
                if (arr[mid] <= target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Q7_SearchInRotatedSortedArray sr = new Q7_SearchInRotatedSortedArray();

        int[] arr = {12, 15, 18, 2, 4};
        int n = arr.length;
        int target = 4;

        System.out.println(sr.search(arr, n, target));
    }
}
