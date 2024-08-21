public class Q11_SlidingWindowMax {
    int[] windowMaxBrute(int[] arr, int k){
        int n = arr.length;
        int max;
        int[] ans = new int[n-k];

        for(int i = 0; i < n-k; i++){
            max = arr[i];
            for(int j = i; j < i+k-1; j++){
                max = Math.max(max, arr[j]);
            }
            ans[i] = max;
        }

        return ans;
    }
    public static void main(String[] args) {
        Q11_SlidingWindowMax sq = new Q11_SlidingWindowMax();

        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] res = sq.windowMaxBrute(arr, k);
        for(int i: res){
            System.out.print(i + " ");
        }

    }
}
