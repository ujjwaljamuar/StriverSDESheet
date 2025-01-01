import java.util.Arrays;

public class Q4_NinjasTraining {

    int fMem(int days, int lastTask, int[][] points, int[][] dp) {
        if (dp[days][lastTask] != -1) {
            return dp[days][lastTask];
        }

        if (days == 0) {
            int maxi = 0;
            for (int task = 0; task < 3; task++) {
                if (task != lastTask) {
                    int point = points[0][task];
                    maxi = Math.max(maxi, point);
                }
            }

            return dp[days][lastTask] = maxi;
        }

        int maxi = 0;
        for (int task = 0; task < 3; task++) {
            if (task != lastTask) {
                int point = points[days][task] + fRecur(days - 1, task, points);
                maxi = Math.max(maxi, point);
            }
        }

        return dp[days][lastTask] = maxi;
    }

    int fRecur(int days, int lastTask, int[][] points) {
        if (days == 0) {
            int maxi = 0;
            for (int task = 0; task < 3; task++) {
                if (task != lastTask) {
                    int point = points[0][task];
                    maxi = Math.max(maxi, point);
                }
            }

            return maxi;
        }

        int maxi = 0;
        for (int task = 0; task < 3; task++) {
            if (task != lastTask) {
                int point = points[days][task] + fRecur(days - 1, task, points);
                maxi = Math.max(maxi, point);
            }
        }

        return maxi;
    }

    int ninjasTraining(int N, int[][] points) {
        // Recursion
        int ansRec = fRecur(N - 1, 3, points);
        // return ansRec;

        // memoization
        int[][] dp = new int[N][4];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ansMem = fMem(N - 1, 3, points, dp);
        return ansMem;

    }

    public static void main(String[] args) {
        Q4_NinjasTraining dp = new Q4_NinjasTraining();

        int N = 3;
        int[][] points = { { 1, 2, 5 }, { 3, 1, 1 }, { 3, 3, 3 } };

        int ans = dp.ninjasTraining(N, points);
        System.out.println(ans);
    }
}
