public class Q17_MinimumDayBouquets {
    static boolean isPossible(int[] arr, int day, int m, int k) {
        int count = 0, noOfBoq = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= day) {
                count++;
            } else {
                noOfBoq += (count / k);
                count = 0;
            }
        }

        noOfBoq += (count / k);

        return noOfBoq >= m;

    }

    static int roseGarden(int[] arr, int b, int r) {
        // Write your code here.
        if ((r * b) > arr.length) {
            return -1;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        int low = min, high = max, ans = high;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (isPossible(arr, mid, b, r)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    static int bruteRoseGarden(int[] arr, int b, int r){
        if ((r * b) > arr.length) {
            return -1;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        int low = min, high = max, ans = high, currMin = Integer.MAX_VALUE;
        
        for(int i = low; i <= high; i++){
            if(isPossible(arr, i, b, r) && i < currMin){
                ans = i;
                currMin = i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 1, 2, 7, 2, 2, 3, 1 };
        int m = 3;
        int k = 2;
        System.out.println(roseGarden(arr, k, m));
        System.out.println(bruteRoseGarden(arr, k, m));
    }
}
