public class Q10_MinSortedRotDup {
    int findMin(int[] arr) {
        int low = 0, mid, high = arr.length - 1;

        if (arr[low] < arr[high])
            return arr[low];

        while (low < high) {
            mid = low + ((high - low) / 2);

            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else if (arr[mid] < arr[high]) {
                high = mid;
            } else {
                high = high -1;
            }
        }

        return arr[high];
    }

    public static void main(String[] args) {
        int[] arr = { 2, 2, 2, 0, 1 };
        Q10_MinSortedRotDup bs = new Q10_MinSortedRotDup();

        System.out.println(bs.findMin(arr));
    }
}
