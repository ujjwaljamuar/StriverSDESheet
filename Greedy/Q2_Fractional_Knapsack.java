import java.util.Comparator;
import java.util.Arrays;

public class Q2_Fractional_Knapsack {

    double fractionalKnapsack(Item[] arr, int weight, int n) {
        double totalSum = 0;
        Arrays.sort(arr, new ItemComparator());

        for (int i = 0; i < n; i++) {
            if (weight > arr[i].wt) {
                totalSum += arr[i].val;
                weight -= arr[i].wt;
            } else {
                totalSum += ((double) arr[i].val / (double) arr[i].wt) * weight;
                break;
            }
        }

        return totalSum;
    }

    public static void main(String[] args) {
        Q2_Fractional_Knapsack grd = new Q2_Fractional_Knapsack();

        int n = 3, weight = 50;
        Item[] arr = new Item[n];

        int[] val = { 100, 60, 120 };
        int[] wt = { 20, 10, 30 };

        for (int i = 0; i < n; i++) {
            arr[i] = new Item(val[i], wt[i]);
        }

        System.out.println(grd.fractionalKnapsack(arr, weight, n));
    }

    static class Item {
        int val;
        int wt;

        Item(int _val, int _wt) {
            this.val = _val;
            this.wt = _wt;
        }
    }

    class ItemComparator implements Comparator<Item> {

        public int compare(Item a, Item b) {
            double r1 = (double) (a.val) / (double) (a.wt);
            double r2 = (double) (b.val) / (double) (b.wt);

            if (r1 < r2) {
                return 1;
            }

            else if (r1 > r2) {
                return -1;
            }

            else {
                return 0;
            }
        }
    }
}
