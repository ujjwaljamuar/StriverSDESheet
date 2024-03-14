public class Q13_PeakElement {
    public int findPeakElement(int[] arr) {
        int n = arr.length, low = 1, mid, high = n - 2;
        if (n == 1)
            return 0;

        if (arr[0] > arr[1]) {
            return 0;
        }

        if (arr[n - 1] > arr[n - 2]) {
            return n - 1;
        }

        while (low <= high) {
            mid = low + ((high - low) / 2);

            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            else if (arr[mid] > arr[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
