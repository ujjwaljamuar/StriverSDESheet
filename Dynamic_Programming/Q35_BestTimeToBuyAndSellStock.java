public class Q35_BestTimeToBuyAndSellStock {
    int maxProfit(int[] prices) {
        int min = prices[0];
        int currProfit, profit = 0;

        for (int i = 1; i < prices.length; i++) {
            currProfit = prices[i] - min;
            profit = Math.max(profit, currProfit);
            min = Math.min(min, prices[i]);
        }

        return profit;
    }

    public static void main(String[] args) {
        Q35_BestTimeToBuyAndSellStock dp = new Q35_BestTimeToBuyAndSellStock();

        int[] prices = { 7, 1, 5, 3, 6, 4 };

        System.out.println(dp.maxProfit(prices));
    }
}
