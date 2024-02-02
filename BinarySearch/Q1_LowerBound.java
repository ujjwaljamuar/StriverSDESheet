public class Q1_LowerBound {

    static int lowerBound(int[] arr, int n, int target) {
        int mid, start = 0, end = n - 1, ans = n;

        while (start <= end) {
            mid = start + ((end - start) >> 1);

            if (arr[mid] >= target) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 3, 5, 8, 8, 10, 10, 11 };
        System.out.println(lowerBound(arr, arr.length, 9));
    }
}
