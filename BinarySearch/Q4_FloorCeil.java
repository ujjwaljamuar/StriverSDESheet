public class Q4_FloorCeil {

    static int[] getFloorCeil(int[] arr, int n, int target) {
        int low = 0, mid, high = n - 1;

        int[] res = { -1, -1 };

        while (low <= high) {
            mid = low + ((high - low) / 2);

            if (arr[mid] == target) {
                res[0] = res[1] = arr[mid];
                return res;
            } else if (arr[mid] < target) {
                res[0] = arr[mid];
                low = mid + 1;
            } else {
                res[1] = arr[mid];
                high = mid - 1;
            }
        }

        return res;

        // while (low <= high) {
        // mid = low + ((high - low) / 2);
        // if (arr[mid] <= target) {
        // ans = arr[mid];
        // res[0] = ans;
        // low = mid + 1;
        // } else {
        // high = mid - 1;
        // }

        // }
        // ans = -1;
        // low = 0;
        // high = n - 1;

        // while (low <= high) {
        // mid = low + ((high - low) / 2);
        // if (arr[mid] >= target) {
        // ans = arr[mid];
        // res[1] = ans;
        // high = mid - 1;
        // } else {
        // low = mid + 1;
        // }

        // }
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, 4, 7, 8, 10 };
        int floor = getFloorCeil(arr, arr.length, 2)[0];
        int ceil = getFloorCeil(arr, arr.length, 2)[1];

        System.out.println(floor + " " + ceil);
    }
}

/*
 * 
 * floor - <=
 * ceil - >=
 * 
 * Sample Input 2 :
 * 6 2
 * 3 4 4 7 8 10
 * 
 * 
 * Sample Output 2 :
 * -1 3
 * 
 * 
 * Explanation of sample input 2 :
 * Since no number is less than or equal to x = 2 in the array, its floor does
 * not exist. The ceiling will be 3.
 */