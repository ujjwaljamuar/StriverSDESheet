public class Q11_FindTimesRotated {
    int findNumberOfTimes(int[] arr) {
        int low = 0, mid, high = arr.length - 1, min = Integer.MAX_VALUE, index = -1;

        while (low <= high) {
            mid = low + ((high - low) / 2);

            if (arr[low] <= arr[high]) {
                if (arr[low] < min) {
                    min = arr[low];
                    index = low;
                }
                break;
            }

            if (arr[low] <= arr[mid]) {
                if (arr[low] < min) {
                    min = arr[low];
                    index = low;
                }

                low = mid + 1;
            } else {
                if (arr[mid] < min) {
                    min = arr[mid];
                    index = mid;
                }
                high = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Q11_FindTimesRotated bs = new Q11_FindTimesRotated();

        int[] arr = { 4, 5, 1, 2, 3 };

        System.out.println(bs.findNumberOfTimes(arr));
    }
}
