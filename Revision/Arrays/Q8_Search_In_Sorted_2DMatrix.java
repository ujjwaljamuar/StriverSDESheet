public class Q8_Search_In_Sorted_2DMatrix {
    boolean searchBrute(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean binarySearch(int[] arr, int target) {
        int mid, low = 0, high = arr.length - 1;

        while (low <= high) {
            // mid = low + ((high - low)/2);
            mid = low + ((high - low) >> 1);

            if (mid == target) {
                return true;
            } else if (target > mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Q8_Search_In_Sorted_2DMatrix bs = new Q8_Search_In_Sorted_2DMatrix();

        int target = 3;
        int[][] matrix = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 }
        };

        // System.out.println(bs.searchBrute(matrix, target));
        System.out.println(bs.searchOptimal1(matrix, target));
    }
}
