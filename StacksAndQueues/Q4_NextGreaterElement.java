
import java.util.Stack;

public class Q4_NextGreaterElement {

    int[] nge(int[] arr) {
        int n = arr.length;

        int[] nge = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!st.empty() && st.peek() <= arr[i % n]) {
                st.pop();
            }

            if (i < n) {
                if (!st.isEmpty()) {
                    nge[i] = st.peek();
                } else {
                    nge[i] = -1;
                }
            }

            st.push(arr[i % n]);
        }

        return nge;
    }

    public static void main(String[] args) {

        Q4_NextGreaterElement sq = new Q4_NextGreaterElement();

        int[] arr = { 5, 7, 1, 2, 6, 0 };

        int[] nge = sq.nge(arr);

        for (int it : nge) {
            System.out.print(it + " ");
        }
    }
}
