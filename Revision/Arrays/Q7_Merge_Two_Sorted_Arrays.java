import java.util.Arrays;

public class Q7_Merge_Two_Sorted_Arrays {
    void mergeOptimal2(long[] arr1, long[] arr2, int n, int m) {

        // len of the imaginary single array:
        int len = n + m;

        // Initial gap:
        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            // Place 2 pointers:
            int left = 0;
            int right = left + gap;
            while (right < len) {
                // case 1: left in arr1[]
                // and right in arr2[]:
                if (left < n && right >= n) {
                    swapIfGreater(arr1, arr2, left, right - n);
                }
                // case 2: both pointers in arr2[]:
                else if (left >= n) {
                    swapIfGreater(arr2, arr2, left - n, right - n);
                }
                // case 3: both pointers in arr1[]:
                else {
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++;
                right++;
            }
            // break if iteration gap=1 is completed:
            if (gap == 1)
                break;

            // Otherwise, calculate new gap:
            gap = (gap / 2) + (gap % 2);
        }
    }

    void mergeOptimal1(long[] arr1, long[] arr2, int n, int m) {
        int left = n - 1;
        int right = 0;
        while (left >= 0 && right < m) {
            if (arr1[left] > arr2[right]) {
                // swap
                long temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

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

    void swapIfGreater(long[] arr1, long[] arr2, int ind1, int ind2) {
        if (arr1[ind1] > arr2[ind2]) {
            long temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }

    public static void main(String[] args) {
        Q7_Merge_Two_Sorted_Arrays ar = new Q7_Merge_Two_Sorted_Arrays();

        long[] arr1 = { 1, 4, 8, 10 };
        long[] arr2 = { 2, 3, 9 };
        int n = 4, m = 3;

        // ar.mergeBrute(arr1, arr2, n, m);
        // ar.mergeOptimal1(arr1, arr2, n, m);
        ar.mergeOptimal2(arr1, arr2, n, m);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
