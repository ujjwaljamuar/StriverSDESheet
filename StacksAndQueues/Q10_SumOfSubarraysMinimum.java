import java.util.Stack;

public class Q10_SumOfSubarraysMinimum {

    int subArrSumMin(int[] arr) {
        int[] nse = findNse(arr);
        int[] pse = findPse(arr);
        int total = 0;
        int mod = (int) 1e9 + 7;

        for (int i = 0; i < arr.length; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;

            total = (total + (right * left * arr[i]) % mod) % mod;

        }

        return total;
    }

    int subArrSumMinBrute(int[] arr) {
        int mini, sum = 0;
        int mod = (int) 1e9 + 7;

        for (int i = 0; i < arr.length; i++) {
            mini = arr[i];
            for (int j = i; j < arr.length; j++) {
                mini = Math.min(mini, arr[j]);
                sum = (sum + mini) % mod;
            }
        }

        return sum;
    }

    int[] findNse(int[] arr) {
        int[] nse = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            nse[i] = st.isEmpty() ? arr.length : st.peek();
            st.add(i);
        }
        return nse;
    }

    int[] findPse(int[] arr) {
        int[] pse = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.add(i);
        }
        return pse;
    }

    public static void main(String[] args) {
        Q10_SumOfSubarraysMinimum sq = new Q10_SumOfSubarraysMinimum();

        int[] arr = { 3, 1, 2, 4 };

        System.out.println(sq.subArrSumMinBrute(arr));
        System.out.println(sq.subArrSumMin(arr));
    }
}
