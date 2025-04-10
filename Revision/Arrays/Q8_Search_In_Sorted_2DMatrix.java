public class Q8_Search_In_Sorted_2DMatrix {
    boolean searchOptimal2(int[][] matrix, int target){
        // flatten the array connect all elements
        // get row by mid/m, and col by mid % m
        int n = matrix.length;
        int m = matrix[0].length;
        int mid, low = 0, high = (n*m) - 1;
        int row, col;
        while(low <= high){
            mid = low + ((high -low) >> 1);
            row = mid/m;
            col = mid % m;

            if(matrix[row][col] == target){
                return true;
            }
            else if(target > matrix[row][col]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return false;
    }

    boolean searchOptimal1(int[][] matrix, int target) {
        // check if its between the range of each row
        for (int i = 0; i < matrix.length; i++) {
            if (target >= matrix[i][0] && target < matrix[i][matrix.length - 1]) {
                return binarySearch(matrix[i], target);
            }
        }

        return false;
    }

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

            if (arr[mid] == target) {
                return true;
            } else if (target > arr[mid]) {
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
        // System.out.println(bs.searchOptimal1(matrix, target));
        System.out.println(bs.searchOptimal2(matrix, target));
    }
}
