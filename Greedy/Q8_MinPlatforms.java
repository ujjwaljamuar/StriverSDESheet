public class Q8_MinPlatforms {

    int countPlatformsBrute(int n, int[] arrival, int[] dept) {
        int maxPlatform = 0;

        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arrival[i] >= arrival[j] && arrival[i] <= dept[j] ||
                        arrival[j] >= arrival[i] && arrival[j] <= dept[i]) {
                    count++;
                }
            }

            maxPlatform = Math.max(maxPlatform, count);
        }

        return maxPlatform;
    }

    public static void main(String[] args) {
        Q8_MinPlatforms grd = new Q8_MinPlatforms();

        int[] arr = { 900, 945, 955, 1100, 1500, 1800 };
        int[] dep = { 920, 1200, 1130, 1150, 1900, 2000 };
        int n = arr.length;
        int totalCount = grd.countPlatformsBrute(n, arr, dep);
        System.out.println("Minimum number of Platforms required " + totalCount);
    }
}
