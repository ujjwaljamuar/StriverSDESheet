import java.util.Arrays;

public class Q3_Sort0s1s2s {
    // optimal, dutch national flag algorithm, TC - O(N) ,SC - O(1),
    // each iteration sorts each element
    /*
     * consider 0 0 0 0 0     1 1 1 1     2 1 1 0     2 2 2 2 2 as example
     * suppose an array consist of 0s 1s 2s such way that
     * 0 to low-1 consists 0s
     * low to mid-1 consists 1s
     * mid to high consists 0s1s2s unsorted
     * high+1 to n-1 consists 2s
     * here mid to high is your array which is unsorted
     * now point low, mid to arr[0] and arr[n-1] to high
     * if your arr[mid] == 0, swap(arr[low], arr[mid]) and mid++, low++
     * if your arr[mid] == 1, mid++
     * if your arr[mid] == 2, swap(arr[mid], arr[high]) and high --
     * 
     */

    // better, using counting
    // TC - O(2N), SC - O(1)

    void dutchNationalFlagAlgorithm(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    void swap(int[] arr, int x, int y) {
        arr[x] = arr[x] ^ arr[y];
        arr[y] = arr[x] ^ arr[y];
        arr[x] = arr[x] ^ arr[y];

        // arr[x] = arr[x] + arr[y];
        // arr[y] = arr[x] - arr[y];
        // arr[x] = arr[x] - arr[y];

        // int temp = arr[x];
        // arr[x] = arr[y];
        // arr[y] = temp;
    }

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

        int[] arr = { 2, 0, 2, 1, 1, 0, 0, 1, 2, 1 };
        // ar.sortUsingCounting(arr);
        ar.dutchNationalFlagAlgorithm(arr);
        System.out.println(Arrays.toString(arr));
    }
}
