import java.util.Arrays;

public class Q1_SetZeroes {
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

        sz.findZeroes(arr);

        System.out.println(Arrays.deepToString(arr));
    }
}
