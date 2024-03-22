import java.util.Arrays;

public class Q21_AggresiveCows {

    int agressiveCows(int[] arr, int cows) {

        Arrays.sort(arr);
        int low = 0, high = arr[arr.length - 1] - arr[0], ans = -1, mid;

        while (low <= high) {
            mid = low + ((high - low) / 2);

            if (weCanPlace(arr, mid, cows)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
        // return ans;
    }

    int bruteAgressiveCows(int[] arr, int cows) {
        Arrays.sort(arr);
        int n = arr.length;
        int i, range = arr[n - 1] - arr[0];

        for (i = 1; i <= range; i++) {
            if (weCanPlace(arr, i, cows) == false) {
                return i - 1;
            }
        }

        return range;
    }

    boolean weCanPlace(int[] arr, int dist, int cows) {
        int countCows = 1, lastCowIndex = arr[0], i;

        for (i = 1; i < arr.length; i++) {
            if (arr[i] - lastCowIndex >= dist) {
                countCows++;
                lastCowIndex = arr[i];
            }
            if (countCows >= cows)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Q21_AggresiveCows bs = new Q21_AggresiveCows();

        int pos[] = { 0, 3, 4, 7, 9, 10 };
        int cows = 4;

        System.out.println(bs.bruteAgressiveCows(pos, cows));
        System.out.println(bs.agressiveCows(pos, cows));
    }
}
