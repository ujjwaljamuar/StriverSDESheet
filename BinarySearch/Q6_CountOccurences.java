public class Q6_CountOccurences {
    int firstOccurence(int[] arr, int n, int x) {
        int mid, low = 0, high = n - 1, first = -1;

        while (low <= high) {
            mid = low + ((high - low) / 2);
            if (arr[mid] == x) {
                first = mid;
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return first;
    }

    int lastOccurence(int[] arr, int n, int x) {
        int mid, low = 0, high = n - 1, last = -1;

        while (low <= high) {
            mid = low + ((high - low) / 2);
            if (arr[mid] == x) {
                last = mid;
                low = mid + 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            }

            else {
                high = mid - 1;
            }
        }

        return last;
    }

    int[] firstLastOccurence(int[] arr, int n, int x) {
        int first = firstOccurence(arr, n, x);
        if (first == -1)
            return new int[] { -1, -1 };
        int last = lastOccurence(arr, n, x);

        return new int[] { first, last };
    }

    int countOccurence(int[] arr, int n, int target) {
        int[] fl = firstLastOccurence(arr, n, target);

        if (fl[0] == -1)
            return 0;

        return (fl[1] - fl[0]) + 1;
    }

    public static void main(String[] args) {
        Q6_CountOccurences cn = new Q6_CountOccurences();

        int[] arr = { 1, 1, 1, 2, 2, 3, 3 };
        int n = arr.length;
        int target = 1;

        System.out.println(cn.countOccurence(arr, n, target));

    }
}
