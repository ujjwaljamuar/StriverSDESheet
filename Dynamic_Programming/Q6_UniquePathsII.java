import java.util.Arrays;

public class Q6_UniquePathsII {

    int findPaths(int i, int j, int[][] grid) {
        if (i >= 0 && j >= 0 && grid[i][j] == 1) {
            return 0;
        }

        if (i == 0 && j == 0) {
            return 1;
        }

        if (i < 0 || j < 0) {
            return 0;
        }

        int up = findPaths(i - 1, j, grid);
        int left = findPaths(i, j - 1, grid);

        return up + left;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }

        return findPaths(m - 1, n - 1, obstacleGrid);
    }

    public static void main(String[] args) {
        Q6_UniquePathsII dp = new Q6_UniquePathsII();

        int[][] grid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };

        System.out.println(dp.uniquePathsWithObstacles(grid));
    }
}
