import java.util.Arrays;
import java.util.List;

public class Q8_MinimumPathSumTriangle {
    int findMinPathSumMem(int i, int j, int n, List<List<Integer>> triangle, int[][] dp) {
        if (i == n - 1) {
            return triangle.get(n - 1).get(j);
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // int down = triangle[i][j] + findMinPathSum(i+1, j);
        // int diag = triangle[i][j] + findMinPathSum(i+1, j+1);

        int down = triangle.get(i).get(j) + findMinPathSumMem(i + 1, j, n, triangle, dp);
        int diag = triangle.get(i).get(j) + findMinPathSumMem(i + 1, j + 1, n, triangle, dp);

        return dp[i][j] = Math.min(down, diag);
    }

    int findMinPathSum(int i, int j, int n, List<List<Integer>> triangle) {
        if (i == n - 1) {
            return triangle.get(n - 1).get(j);
        }

        // int down = triangle[i][j] + findMinPathSum(i+1, j);
        // int diag = triangle[i][j] + findMinPathSum(i+1, j+1);

        int down = triangle.get(i).get(j) + findMinPathSum(i + 1, j, n, triangle);
        int diag = triangle.get(i).get(j) + findMinPathSum(i + 1, j + 1, n, triangle);

        return Math.min(down, diag);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[][] dp = new int[n][triangle.get(n - 1).size()];

        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }

        // return findMinPathSum(0, 0, n, triangle);

        return findMinPathSumMem(0, 0, n, triangle, dp);
    }

    public static void main(String[] args) {
        Q8_MinimumPathSumTriangle dp = new Q8_MinimumPathSumTriangle();

        // int[][] triangleArr = { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } };

        // List<List<Integer>> triangle = Arrays.stream(triangleArr)
        // .map(innerArray ->
        // Arrays.stream(innerArray).boxed().collect(Collectors.toList()))
        // .collect(Collectors.toList());

        List<List<Integer>> triangleList = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3));

        System.out.println(dp.minimumTotal(triangleList));
    }
}
