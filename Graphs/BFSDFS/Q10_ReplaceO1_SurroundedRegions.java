package BFSDFS;

public class Q10_ReplaceO1_SurroundedRegions {

    void replaceOX(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };

        boolean[][] isVisited = new boolean[n][m];

        // replace boundaries

        // replace 1st row and last row

        for (int j = 0; j < m; j++) {
            // first row
            if (matrix[0][j] == 'O' && !isVisited[0][j]) {
                dfs(0, j, isVisited, matrix, n, m, delRow, delCol);
            }

            // last row
            if (matrix[n - 1][j] == 'O' && !isVisited[n - 1][j]) {
                dfs(n - 1, j, isVisited, matrix, n, m, delRow, delCol);
            }
        }

        // for column boundaries
        for (int i = 0; i < n; i++) {
            // first col
            if (matrix[i][0] == 'O' && !isVisited[i][0]) {
                dfs(i, 0, isVisited, matrix, n, m, delRow, delCol);
            }

            // last col
            if (matrix[i][m - 1] == 'O' && !isVisited[i][m - 1]) {
                dfs(i, m - 1, isVisited, matrix, n, m, delRow, delCol);
            }
        }

        // for every element
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 'O' && !isVisited[i][j]) {
                    matrix[i][j] = 'X';
                }
            }
        }
    }

    void dfs(int row, int col, boolean[][] isVisited, char[][] matrix, int n, int m, int[] delRow, int[] delCol) {
        isVisited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && matrix[nRow][nCol] == 'O' && !isVisited[nRow][nCol]) {
                dfs(nRow, nCol, isVisited, matrix, n, m, delRow, delCol);
            }
        }
    }

    public static void main(String[] args) {

        Q10_ReplaceO1_SurroundedRegions graph = new Q10_ReplaceO1_SurroundedRegions();

        char[][] matrix = { { 'X', 'X', 'O', 'O' },
                            { 'X', 'O', 'X', 'X' },
                            { 'X', 'O', 'O', 'X' },
                            { 'X', 'O', 'X', 'X' },
                            { 'X', 'X', 'X', 'X' } };

        graph.replaceOX(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}

/*  
- goto all the boundaries of the matrix, if there is O mark it visited and go to its depth and mark them visited
- these cannot be converted
- if anyone remains after this, only they can be converted to X
*/