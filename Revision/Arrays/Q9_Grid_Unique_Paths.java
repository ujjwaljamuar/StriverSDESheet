public class Q9_Grid_Unique_Paths {
    // go every possible path and return 1 if found and sum it up
    int findPathsRecursion(int i, int j, int m, int n) {
        if (i == m-1 && j == n-1) {
            return 1;
        }
        if (i >= m || j >= n) {
            return 0;
        }

        return findPathsRecursion(i + 1, j, m, n) + findPathsRecursion(i, j + 1, m, n);
    }

    public static void main(String[] args) {
        Q9_Grid_Unique_Paths bs = new Q9_Grid_Unique_Paths();

        int m = 3, n = 7;
        System.out.println(bs.findPathsRecursion(0, 0, m, n));
    }
}
