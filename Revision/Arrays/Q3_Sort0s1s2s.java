import java.util.Arrays;

public class Q3_Sort0s1s2s {

    // better, using counting
    // TC - O(2N), SC - O(1)
    void sortUsingCounting(int[] arr) {
        int count0 = 0, count1 = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count0++;
            } else if (arr[i] == 1) {
                count1++;
            }
        }

        for (int i = 0; i < count0; i++) {
            arr[i] = 0;
        }
        for (int i = count0; i < count0 + count1; i++) {
            arr[i] = 1;
        }
        for (int i = count0 + count1; i < arr.length; i++) {
            arr[i] = 2;
        }

    }

    // brute
    // use any sort algo, probably merge sort
    // TC - o(nlogn)
    // SC - o(n)
    public static void main(String[] args) {
        Q3_Sort0s1s2s ar = new Q3_Sort0s1s2s();

        int[] arr = { 2, 0, 2, 1, 1, 0 };
        ar.sortUsingCounting(arr);
        System.out.println(Arrays.toString(arr));
    }
}
