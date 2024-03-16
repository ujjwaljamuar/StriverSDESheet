public class Q15_NthRootOfM {
    int NthRoot(int n, int m) {
        int low = 1, high = m, mid;
        if(m == 1){
            return 1;
        }

        while (low <= high) {
            mid = low + ((high - low) / 2);

            if (Math.pow(mid, n) == m) {
                return mid;
            } else if (Math.pow(mid, n) < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Q15_NthRootOfM bs = new Q15_NthRootOfM();
        System.out.println(bs.NthRoot(3, 27));
    }
}
