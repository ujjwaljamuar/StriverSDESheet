import java.util.Arrays;

public class Q4_NinjasTraining {

    int fTab(int days, int[][] points) {
        // Initialize a 2D array 'dp' to store the maximum points
        int[][] dp = new int[days][4];

        // Initialize the first day's maximum points based on the available choices
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        // Iterate through each day and each activity
        for (int day = 1; day < days; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0; // Initialize the maximum points for the current day and last activity
                // Consider each possible task for the current day
                for (int task = 0; task <= 2; task++) {
                    if (task != last) { // Ensure that the current task is different from the last
                        // Calculate the points for the current activity and add it to the maximum
                        // points from the previous day
                        int activity = points[day][task] + dp[day - 1][task];
                        // Update the maximum points for the current day and last activity
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }
        }

        // Return the maximum points achievable after all days (last activity is 3)
        return dp[days - 1][3];
    }

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
        // return ansMem;

        int ansTab = fTab(N, points);
        return ansTab;

    }

    public static void main(String[] args) {
        Q4_NinjasTraining dp = new Q4_NinjasTraining();

        int N = 3;
        int[][] points = { { 1, 2, 5 }, { 3, 1, 1 }, { 3, 3, 3 } };

        int ans = dp.ninjasTraining(N, points);
        System.out.println(ans);
    }
}
