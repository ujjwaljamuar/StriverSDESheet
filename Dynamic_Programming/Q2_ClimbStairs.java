public class Q2_ClimbStairs {

    int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int prev2 = 1;
        int prev = 1;

        for (int i = 2; i <= n; i++) {
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }

    int climbStairsRec(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int left = climbStairs(n - 1);
        int right = climbStairs(n - 2);

        return left + right;
    }

    public static void main(String[] args) {
        Q2_ClimbStairs dp = new Q2_ClimbStairs();

        System.out.println(dp.climbStairsRec(3));
        System.out.println(dp.climbStairs(3));
    }
}
