import java.util.Arrays;

public class Q1_FibonacciNumber {

    int fibOpt(int n) {
        if (n <= 1) {
            return n;
        }

        int prev2 = 0;
        int prev = 1;

        for (int i = 2; i <= n; i++) {
            int curr = prev2 + prev;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    int fibTab(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;

        if (n <= 1) {
            return n;
        }

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[n];
    }

    int fibMem(int n, int[] dpArr) {
        if (n <= 1) {
            return n;
        }

        if (dpArr[n] != -1) {
            return dpArr[n];
        }

        return dpArr[n] = fibMem(n - 1, dpArr) + fibMem(n - 2, dpArr);
    }

    int fibRec(int n) {
        if (n <= 1) {
            return n;
        }

        return fibRec(n - 1) + fibRec(n - 2);
    }

    public static void main(String[] args) {
        Q1_FibonacciNumber dp = new Q1_FibonacciNumber();

        int n = 40;

        int[] dpArr = new int[n + 1];
        Arrays.fill(dpArr, -1);

        System.out.println(dp.fibRec(n));
        System.out.println(dp.fibMem(n, dpArr));
        System.out.println(dp.fibTab(n));
        System.out.println(dp.fibOpt(n));
    }
}
