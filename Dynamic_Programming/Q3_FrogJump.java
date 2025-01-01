import java.util.Arrays;

public class Q3_FrogJump {

    int minimumEnergyOpt(int[] arr, int n){
        int prev2 = 0;
        int prev = 0;

        for(int i = 1; i < n; i++){
            int fs = prev + Math.abs(arr[i] - arr[i-1]);
            int ss = Integer.MAX_VALUE;

            if(i > 1){
                ss = prev2 + Math.abs(arr[i]- arr[i-2]);
            }

            int curr = Math.min(fs, ss);
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }

    int minimumEnergyTab(int[] arr, int n) {
        int[] dp = new int[n];

        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int secondStep = Integer.MAX_VALUE;
            int firstStep = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);

            if (i > 1) {
                secondStep = dp[i - 2] + Math.abs(arr[i] - arr[i - 2]);
            }

            dp[i] = Math.min(secondStep, firstStep);
        }

        return dp[n-1];
    }

    int minimumEnergyMem(int[] arr, int n, int[] dp) {
        if (n == 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int rightRec = Integer.MAX_VALUE;
        int leftRec = minimumEnergyMem(arr, n - 1, dp) + Math.abs(arr[n] - arr[n - 1]);
        if (n > 1) {
            rightRec = minimumEnergyMem(arr, n - 2, dp) + Math.abs(arr[n] - arr[n - 2]);
        }

        return Math.min(leftRec, rightRec);
    }

    int minimumEnergyRec(int[] arr, int n) {
        if (n == 0) {
            return 0;
        }

        int rightRec = Integer.MAX_VALUE;
        int leftRec = minimumEnergyRec(arr, n - 1) + Math.abs(arr[n] - arr[n - 1]);
        if (n > 1) {
            rightRec = minimumEnergyRec(arr, n - 2) + Math.abs(arr[n] - arr[n - 2]);
        }

        return Math.min(leftRec, rightRec);
    }

    public static void main(String[] args) {
        Q3_FrogJump dp = new Q3_FrogJump();

        int[] arr = { 10, 20, 30, 10 };
        int n = 4;

        int[] dpArr = new int[n + 1];
        Arrays.fill(dpArr, -1);

        System.out.println(dp.minimumEnergyRec(arr, n - 1));
        System.out.println(dp.minimumEnergyMem(arr, n - 1, dpArr));
        System.out.println(dp.minimumEnergyTab(arr, n));
        System.out.println(dp.minimumEnergyOpt(arr, n));
    }
}
