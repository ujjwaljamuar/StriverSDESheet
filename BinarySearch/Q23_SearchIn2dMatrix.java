public class Q23_SearchIn2dMatrix {

    boolean bestSearch(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0, high = n * m - 1, mid, row, col;

        while (low <= high) {
            mid = low + ((high - low) / 2);
            row = mid / m;
            col = mid % m;
            if (mat[row][col] == target) {
                return true;
            } else if (mat[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    boolean goodSearch(int[][] mat, int target) { // O(n) + O(logN) = O{n}
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][0] <= target && target <= mat[i][mat[0].length - 1]) {

                // return binarSearch(mat[i], target)
                return true;
            }
        }

        return false;
    }

    boolean worstSearch(int[][] mat, int target) { // O(n)2
        int n = mat.length;
        int m = mat[0].length;
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if (mat[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Q23_SearchIn2dMatrix bs = new Q23_SearchIn2dMatrix();

        int[][] mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

        int target = 56;

        System.out.println(bs.worstSearch(mat, target));
        System.out.println(bs.bestSearch(mat, target));

    }
}
