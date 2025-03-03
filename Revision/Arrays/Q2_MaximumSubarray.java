public class Q2_MaximumSubarray {
    int maxSumSubArrBrute(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                // subarray = arr[i.....j]
                int sum = 0;

                //add all the elements of subarray:
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                max = Math.max(sum, max);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Q2_MaximumSubarray ms = new Q2_MaximumSubarray();

        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        System.out.println(ms.maxSumSubArrBrute(arr));
    }
}
