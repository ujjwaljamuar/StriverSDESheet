import java.util.Arrays;

public class Q5_RotateMatrix {

    int[][] rotateMatrixBrute(int[][] matrix) {
        // i,j interchange positions row to col
        // the j remains constant but i changes to n-1-i
        int[][] ans = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ans[j][matrix.length - 1 - i] = matrix[i][j];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Q5_RotateMatrix ar = new Q5_RotateMatrix();

        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        System.out.println(Arrays.deepToString(ar.rotateMatrixBrute(matrix)));
    }
}
