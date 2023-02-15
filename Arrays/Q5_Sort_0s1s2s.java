package Arrays;

public class Q5_Sort_0s1s2s {
    static void sortZerosOnesTwos(int arr[]) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    arr[low] = arr[low] ^ arr[mid];
                    arr[mid] = arr[low] ^ arr[mid];
                    arr[low] = arr[low] ^ arr[mid];

                    low++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    arr[mid] = arr[mid] ^ arr[high];
                    arr[high] = arr[mid] ^ arr[high];
                    arr[mid] = arr[mid] ^ arr[high];

                    high--;
                    break;

            }
        }
    }

    static void printArr(int arr[], int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 2, 1, 2, 0, 1, 2, 2 };
        int size = arr.length;
        printArr(arr, size);

        sortZerosOnesTwos(arr);

        printArr(arr, size);
    }
}
