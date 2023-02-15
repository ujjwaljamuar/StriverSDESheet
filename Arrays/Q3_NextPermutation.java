package Arrays;

public class Q3_NextPermutation {
    static void nextPerm(int[] arr) {
        if (arr == null || arr.length <= 1)
            return;

        int i = arr.length - 2; // traversal starts from here

        while (i >= 0 && arr[i] >= arr[i + 1])
            i--;

        if (i >= 0) {
            int j = arr.length - 1;
            while (arr[j] <= arr[i])
                j--;
            swap(arr, i, j);
        }
        reverse(arr, i + 1, arr.length - 1);
    }

    static void swap(int arr[], int i, int j) {
        arr[i] = arr[i] ^ arr[j];       // without using third variable
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    static void reverse(int arr[], int i, int j) {
        while (i < j)
            swap(arr, i++, j--);
    }

    static void printArr(int arr[], int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 5, 4, 2 };
        int size = arr.length;

        printArr(arr, size);

        nextPerm(arr);

        printArr(arr, size);

    }
}
