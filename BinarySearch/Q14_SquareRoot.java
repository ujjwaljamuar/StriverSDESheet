public class Q14_SquareRoot {

    int sqaureRootBinarySearch(long n) {
        long low = 1, high = n, mid;

        while (low <= high) {
            mid = low + ((high - low) / 2);

            if (mid * mid <= n) {
                // ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // return ans; both are correct
        return (int) high;
    }

    int sqaureRoot(int n) {
        int i, ans = -1;
        for (i = 1; i <= n; i++) {
            if (i * i <= n) {
                ans = i;
            } else {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q14_SquareRoot bs = new Q14_SquareRoot();

        System.out.println(bs.sqaureRoot(25000000));
        System.out.println(bs.sqaureRootBinarySearch(25000000));
    }
}
