public class BinarySearch {
    int binarySearchIterative(int[] arr, int length, int target) {
        int mid, low = 0, high = length - 1;
        while (low <= high) {
            mid = low + ((high - low) / 2);

            if (arr[mid] == target) {
                return mid;
            }

            else if (target > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // if the target is not found.
        return -1;
    }

    int binarySearchRecursive(int[] arr, int low, int high, int target) {
        // base case
        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) / 2);
        if (arr[mid] == target) {
            return mid;
        } else if (target > arr[mid]) {
            return binarySearchRecursive(arr, mid + 1, high, target);
        } else {
            return binarySearchRecursive(arr, low, mid - 1, target);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, 6, 7, 9, 12, 17 };

        BinarySearch bs = new BinarySearch();

        System.out.println(bs.binarySearchIterative(arr, arr.length, 7));

        System.out.println(bs.binarySearchRecursive(arr, 0, arr.length - 1, 7));

    }
}
