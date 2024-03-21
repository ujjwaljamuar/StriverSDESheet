public class Q20_KthMissingPositiveInteger {

    int nthMissingNumber(int[] arr, int n, int k) {
        int low = 0, high = n - 1, mid, missing;

        while (low <= high) {
            mid = low + ((high - low) / 2);
            missing = arr[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return k + high + 1;
    }

    int bruteNthMissingNumber(int[] arr, int k) {
        int i, n = arr.length;
        for (i = 0; i < n; i++) {

            // if number is lesthan equal to k,
            // then it will take one place in missing array so increase

            if (arr[i] <= k) {
                k++;
            } else {
                break;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        Q20_KthMissingPositiveInteger bs = new Q20_KthMissingPositiveInteger();

        int[] arr = { 4, 7, 9, 10 };
        int k = 4;
        int n = arr.length;

        System.out.println(bs.bruteNthMissingNumber(arr, k));
        System.out.println(bs.nthMissingNumber(arr, n, k));

    }
}
