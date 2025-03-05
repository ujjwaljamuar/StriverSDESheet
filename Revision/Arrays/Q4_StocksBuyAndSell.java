public class Q4_StocksBuyAndSell {
    int maxProfit(int[] arr) {
        // for getting the maximum profit, subtract current price to min, keep track of
        // maxProfit and min
        int min = arr[0];
        int profit, maxProfit = 0;
        for (int i = 1; i < arr.length; i++) {
            profit = arr[i] - min;
            maxProfit = Math.max(maxProfit, profit);
            min = Math.min(min, arr[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Q4_StocksBuyAndSell ar = new Q4_StocksBuyAndSell();

        int[] arr = { 7, 1, 5, 3, 6, 4 };

        System.out.println(ar.maxProfit(arr));
    }
}
