package Arrays;

public class Q4_Maximum_Sum_SubArray {
    static int kadaneAlgo(int arr[]) {
        int size = arr.length, sum = 0, max = arr[0];
        for (int i = 0; i < size; i++) {
            sum += arr[i];
            if (sum > max)
                max = sum;
            if (sum < 0)
                sum = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(kadaneAlgo(arr));
    }
}
