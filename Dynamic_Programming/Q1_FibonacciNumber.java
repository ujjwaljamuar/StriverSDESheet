public class Q1_FibonacciNumber {

    int fibRec(int n) {
        if (n <= 1) {
            return n;
        }

        return fibRec(n - 1) + fibRec(n - 2);
    }

    public static void main(String[] args) {
        Q1_FibonacciNumber dp = new Q1_FibonacciNumber();

        int n = 5;

        System.out.println(dp.fibRec(n));
    }
}
