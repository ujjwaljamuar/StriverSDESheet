import java.util.Arrays;

public class Q1_SetZeroes {
    // better approach
    // TC ~ O(n)^2
    void setZeroes(int[][] arr) {
        int[] row = new int[arr[0].length];
        int[] col = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    row[j] = 1;
                    col[i] = 1;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if ((row[i] == 1) || (col[j] == 1)) {
                    arr[i][j] = 0;
                }
            }
        }

    }

    // brute force
    // TC ~ O(n)^3
    void markRow(int[][] arr, int i) {
        for (int j = 0; j < arr[0].length; j++) {
            if (arr[i][j] != 0) {
                arr[i][j] = -1;
            }
        }
    }

    void markCol(int[][] arr, int j) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][j] != 0) {
                arr[i][j] = -1;
            }
        }
    }

    void findZeroes(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    markRow(arr, i);
                    markCol(arr, j);
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == -1) {
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Q1_SetZeroes sz = new Q1_SetZeroes();

        int[][] arr = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };

        // sz.findZeroes(arr);
        sz.setZeroes(arr);

        System.out.println(Arrays.deepToString(arr));
    }
}
