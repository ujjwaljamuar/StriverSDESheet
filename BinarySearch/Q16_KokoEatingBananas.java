public class Q16_KokoEatingBananas {
    int maximumBananas(int[] piles, int n) {
        int i, max = 0;
        for (i = 0; i < n; i++) {
            max = Math.max(piles[i], max);
        }
        return max;
    }

    int totalHrs(int[] piles, int bananasPerHr, int n) {
        int i, totalHrs = 0;
        for (i = 0; i < n; i++) {
            totalHrs += Math.ceil((double) piles[i] / (double) bananasPerHr);
        }
        return totalHrs;
    }

    int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1, high = maximumBananas(piles, n), mid;
        // int ans = Integer.MIN_VALUE;

        while (low <= high) {
            mid = low + ((high - low) / 2);

            if (totalHrs(piles, mid, n) <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // return ans;
        return low;
    }

    int bruteMinEatingSpeed(int[] piles, int h) {
        int minHrs = -1, max = maximumBananas(piles, piles.length), minPerHr = Integer.MAX_VALUE;
        for (int i = 1; i < max; i++) {
            int totalHrs = totalHrs(piles, i, piles.length);

            if (totalHrs <= h && minPerHr > i) {
                minHrs = i;
                minPerHr = i;
            }
        }
        return minHrs;
    }

    public static void main(String[] args) {
        Q16_KokoEatingBananas bs = new Q16_KokoEatingBananas();
        int[] piles = { 1, 1, 1, 999999999 };
        int h = 10;
        System.out.println(bs.minEatingSpeed(piles, h));
        System.out.println(bs.bruteMinEatingSpeed(piles, h));
    }
}

// Return k minimum number of bananas per hour it eats to finish all bananas
// within H hours