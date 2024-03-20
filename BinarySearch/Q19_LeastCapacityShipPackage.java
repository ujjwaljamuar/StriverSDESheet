public class Q19_LeastCapacityShipPackage {

    int findDays(int[] weight, int cap) {
        int days = 1, load = 0, i;

        for (i = 0; i < weight.length; i++) {
            if (weight[i] + load > cap) {
                days += 1;
                load = weight[i];
            } else {
                load += weight[i];
            }
        }

        return days;
    }

    int leastCapacity(int[] weight, int d) {
        // low will be the max number and high will be sum
        int low = Integer.MIN_VALUE, high = 0, mid;

        for (int i = 0; i < weight.length; i++) {
            low = Math.max(low, weight[i]);
            high += weight[i];
        }

        while (low <= high) {
            mid = low + ((high - low) / 2);
            int noOfDays = findDays(weight, mid);

            if (noOfDays <= d) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    int bruteLeastCapacity(int[] weight, int d) {
        int low = Integer.MIN_VALUE, high = 0, currI = Integer.MAX_VALUE, ans = -1;

        for (int i = 0; i < weight.length; i++) {
            low = Math.max(low, weight[i]);
            high += weight[i];
        }

        for (int i = low; i <= high; i++) {
            int noOfDays = findDays(weight, i);
            if (noOfDays <= d && i < currI) {
                currI = i;
                ans = i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Q19_LeastCapacityShipPackage bs = new Q19_LeastCapacityShipPackage();

        int[] weight = { 5, 4, 5, 2, 3, 4, 5, 6 };
        int days = 5;

        System.out.println(bs.leastCapacity(weight, days));
        System.out.println(bs.bruteLeastCapacity(weight, days));
    }
}
