import java.util.Arrays;

public class Q7_Merge_Two_Sorted_Arrays {
    void mergeBrute(long[] arr1, long[] arr2, int n, int m) {
        int left = 0;
        int right = 0;
        int index = 0;

        long[] arr3 = new long[n + m];

        // move elements from arr1 and arr2 to arr3
        while (left < n && right < m) {
            if (arr1[left] <= arr2[right]) {
                arr3[index] = arr1[left];
                left++;
                index++;
            } else {
                arr3[index] = arr2[right];
                right++;
                index++;
            }
        }

        // check if some elements were left
        while (left < n) {
            arr3[index] = arr1[left];
            left++;
            index++;
        }
        while (right < m) {
            arr3[index] = arr2[right];
            right++;
            index++;
        }

        // now move all elements back to arr1 and arr2 from arr3
        for (int i = 0; i < n + m; i++) {
            if (i < n) {
                arr1[i] = arr3[i];
            } else {
                arr2[i - n] = arr3[i];
            }
        }
    }

    public static void main(String[] args) {
        Q7_Merge_Two_Sorted_Arrays ar = new Q7_Merge_Two_Sorted_Arrays();

        long[] arr1 = { 1, 4, 8, 10 };
        long[] arr2 = { 2, 3, 9 };
        int n = 4, m = 3;

        ar.mergeBrute(arr1, arr2, n, m);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
