public class Q18_SmallestDivisorForThreshold {

    int sumAllByD(int[] arr, int div) {
        int i, sum = 0, len = arr.length;
        for (i = 0; i < len; i++) {
            sum += Math.ceil((double) arr[i] / (double) div);
        }
        return sum;
    }

    int smallestDivisor(int arr[], int limit) {
        // Write your coder here
        int i, max = Integer.MIN_VALUE;
        for (i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        int low = 1, high = max, mid, ans = -1;

        while (low <= high) {
            mid = low + ((high - low) / 2);
            if (sumAllByD(arr, mid) <= limit) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    int bruteSmallestDivisor(int arr[], int limit) {
        int i, max = Integer.MIN_VALUE;
        for (i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        int ans = -1, minI = Integer.MAX_VALUE;
        for (i = 1; i <= max; i++) {
            if (sumAllByD(arr, i) <= limit && i < minI) {
                ans = i;
                minI = i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Q18_SmallestDivisorForThreshold bs = new Q18_SmallestDivisorForThreshold();

        int[] arr = { 8, 4, 2, 3 };

        int threshold = 10;

        System.out.println(bs.smallestDivisor(arr, threshold));
        System.out.println(bs.bruteSmallestDivisor(arr, threshold));
    }
}
