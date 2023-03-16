import java.util.ArrayList;
import java.util.List;

//package Recursion;

class KthPermutation {

    static String getKthPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;

        for (int i = 1; i < n; i++) {
            fact = fact * i;
            numbers.add(i);
        }

        numbers.add(n);
        k = k - 1;

        String res = "";

        while (true) {
            res = res + numbers.get(k / fact);
            numbers.remove(k / fact);

            if (numbers.size() == 0) {
                break;
            }

            k = k % fact;
            fact = fact / numbers.size();
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 4, k = 17;
        System.out.println(getKthPermutation(n, k));
    }
}