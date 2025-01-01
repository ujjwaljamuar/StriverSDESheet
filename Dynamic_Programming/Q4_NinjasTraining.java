public class Q4_NinjasTraining {

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

    public static void main(String[] args) {
        Q4_NinjasTraining dp = new Q4_NinjasTraining();

        int N = 3;
        int[][] points = { { 1, 2, 5 }, { 3, 1, 1 }, { 3, 3, 3 } };

        int ans = dp.fRecur(N - 1, 3, points);
        System.out.println(ans);
    }
}
