package Graphs;

public class Q5_FloodFillAlgo {

    private void dfs(int row, int col, int[][] ans, int[][] image, int newColor, int[] delrow, int[] delCol,
            int initialColor) {
        // mark the initial color to new color
        ans[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;
        
        // we have to go exact 4 adjacent elements
        for (int i = 0; i < 4; i++) {
            int nRow = row + delrow[i];
            int nCol = col + delCol[i];

            // check for neighbour is valid or not
            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m &&
                    image[nRow][nCol] == initialColor && ans[nRow][nCol] != newColor) {
                dfs(nRow, nCol, ans, image, newColor, delrow, delCol, initialColor);
            }
        }

    }

    int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // get the initial color
        int initialColor = image[sr][sc];
        // make a copy of data to do changes and return
        int[][] ans = image;

        // find adjacent rows and columns using delrow, delcol, technique
        int[] delrow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };

        // start from initial color and go to its depth
        dfs(sr, sc, ans, image, newColor, delrow, delCol, initialColor);

        return ans;
    }

    public static void main(String[] args) {
        Q5_FloodFillAlgo graph = new Q5_FloodFillAlgo();

        int[][] image = {
                { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 }
        };

        // sr = 1, sc = 1, newColor = 2
        int[][] ans = graph.floodFill(image, 1, 1, 2);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println();
        }
    }
}
