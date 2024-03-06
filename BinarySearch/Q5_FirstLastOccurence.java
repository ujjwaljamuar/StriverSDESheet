public class Q5_FirstLastOccurence {

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

    public static void main(String[] args) {
        int arr[] = { 0, 0, 1, 1, 2, 2, 2, 2 };
        int n = arr.length;
        int x = 2;
        Q5_FirstLastOccurence fl = new Q5_FirstLastOccurence();

        int[] result = fl.firstLastOccurence(arr, n, x);

        for (int i : result) {
            System.out.print(i + " ");
        }

    }
}
