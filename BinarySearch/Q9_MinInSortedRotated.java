class Q9_MinInSortedRotated {
    int findMin(int[] arr) {
        int low = 0, mid, high = arr.length - 1, ans = Integer.MAX_VALUE;

        while (low <= high) {
            mid = low + ((high - low) / 2);

            if (arr[low] <= arr[high]) {
                ans = Math.min(ans, arr[low]);
                break;
            }

            if (arr[low] <= arr[mid]) {
                ans = Math.min(ans, arr[low]);
                low = mid + 1;
            } else {
                ans = Math.min(ans, arr[mid]);
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 25, 30, 5, 10, 15, 20 };

        Q9_MinInSortedRotated bs = new Q9_MinInSortedRotated();

        System.out.println(bs.findMin(arr));
    }
}

// take a max value
// check which part is sorted
// if left is sorted low will be the lowest
// if right is sorted mid will be the lowest