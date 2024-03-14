public class Q12_SingleElementinArray {
    int singleNonDuplicate(int[] arr) {
        int n = arr.length, low = 1, mid, high = n - 2;
        if (n == 1) {
            return arr[0];
        }
        if (arr[0] != arr[1]) {
            return arr[0];
        }
        if (arr[n - 1] != arr[n - 2]) {
            return arr[n - 1];
        }

        while (low <= high) {
            mid = low + ((high - low) / 2);

            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
                return arr[mid];
            }

            // we are on left side
            if ((mid % 2 == 1 && arr[mid] == arr[mid - 1]) || mid % 2 == 0 && arr[mid] == arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Q12_SingleElementinArray bs = new Q12_SingleElementinArray();

        int[] arr = { 1, 1, 3, 3, 4, 4, 8 };

        System.out.println(bs.singleNonDuplicate(arr));
    }
}
