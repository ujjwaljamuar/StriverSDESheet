public class Q3_Minimum_Coins {

    int findChange(int[] arr, int amount) {
        int count = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            while (amount >= arr[i]) {
                amount -= arr[i];
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Q3_Minimum_Coins grd = new Q3_Minimum_Coins();

        int[] coins = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };

        int amount = 22;

        System.out.println(grd.findChange(coins, amount));
    }
}
