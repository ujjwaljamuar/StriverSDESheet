package Questions;

public class Q1_SwapNumbers {
    public static void main(String[] args) {
        int a = 10, b = 5;
        System.out.println("a = " + a + ", b = " + b);

        a = a ^ b;
        b = a ^ b;    // a ^ b ^ b, so b ^ b will be 0
        a = a ^ b;

        System.out.println("a = " + a + ", b = " + b);
    }
}
