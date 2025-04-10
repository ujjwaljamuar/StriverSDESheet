public class Q2_MaximumSubarray {
    long maxSumSubArrayKadanesAlgo(int[] arr) {
        long max = Long.MIN_VALUE;
        long sum = 0;

        // go on and take every element,
        // if at any time sum goes below 0, re initialize because thats of no use
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum > max) {
                max = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }

    int maxSubarraySumBetter(int[] arr) {
        int maxi = Integer.MIN_VALUE; // maximum sum

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                // current subarray = arr[i.....j]

                // add the current element arr[j]
                // to the sum i.e. sum of arr[i...j-1]
                sum += arr[j];

                maxi = Math.max(maxi, sum); // getting the maximum
            }
        }

        return maxi;
    }

    int maxSumSubArrBrute(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                // subarray = arr[i.....j]
                int sum = 0;

                // add all the elements of subarray:
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

        // System.out.println(ms.maxSumSubArrBrute(arr));
        // System.out.println(ms.maxSubarraySumBetter(arr));
        System.out.println(ms.maxSumSubArrayKadanesAlgo(arr));
    }
}
