import java.util.Arrays;

public class Q1_AssignCookies {

    int maxSatisfied(int[] greed, int[] size) {
        int m = size.length;
        int n = greed.length;

        int l = 0, r = 0;
        Arrays.sort(greed);
        Arrays.sort(size);

        while (l < m && r < n) {
            if (greed[r] <= size[l]) {
                r = r + 1;
            }

            l = l + 1;
        }

        return r;
    }

    public static void main(String[] args) {
        Q1_AssignCookies grd = new Q1_AssignCookies();

        int[] greed = { 1, 2};
        int[] size = { 1, 2, 3};
        System.out.println(grd.maxSatisfied(greed, size));
    }
}
