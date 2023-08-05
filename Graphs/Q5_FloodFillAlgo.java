package Graphs;

public class Q5_FloodFillAlgo {

    static int[][] floodFill(int sr, int sc, int[][] image, int newColor) {
        int initialColor = image[sr][sc];
        int[][] ans = image;

        int[] delrow = { -1, 0, 1, 0 };
        int[] delcol = { 0, 1, 0, -1 };

        dfs(sr, sc, ans, image, delrow, delcol, initialColor, newColor);

        return ans;
    }

    static void dfs(int row, int col, int[][] ans, int[][] image, int[] delrow, int[] delcol, int initialColor,
            int newColor) {
        ans[row][col] = newColor;

        int n = ans.length;
        int m = ans[0].length;

        // delrow and col are exactly 4
        for (int i = 0; i < 4; i++) {
            // find neighbours
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            // perform checks
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == initialColor
                    && ans[nrow][ncol] != newColor) {
                dfs(nrow, ncol, ans, image, delrow, delcol, initialColor, newColor);
            }
        }

    }

    public static void main(String[] args) {
        int[][] image = {
                { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 }
        };

        // sr = 1, sc = 1, newColor = 2
        int[][] ans = floodFill(1, 1, image, 2);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println();
        }
    }
}