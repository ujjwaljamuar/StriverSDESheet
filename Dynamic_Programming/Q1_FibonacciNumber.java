import java.util.Arrays;

public class Q1_FibonacciNumber {

    int fibMem(int n, int[] dpArr) {
        if (n <= 1) {
            return n;
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

        int n = 5;

        int[] dpArr = new int[n + 1];
        Arrays.fill(dpArr, -1);

        System.out.println(dp.fibRec(n));
        System.out.println(dp.fibMem(n, dpArr));
    }
}
