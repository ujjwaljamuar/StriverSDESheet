import java.util.Stack;

public class Q8_PreviousSmallerElement {
    int[] pseII(int[] arr) {
        int pse[] = new int[arr.length];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }

            pse[i] = st.isEmpty() ? -1 : st.peek();

            st.push(arr[i]);
        }

        return pse;
    }

    public static void main(String[] args) {
        Q8_PreviousSmallerElement sq = new Q8_PreviousSmallerElement();

        int[] arr = { 5, 7, 9, 6, 7, 4, 5, 1, 3, 7 };
        int[] nse = sq.pseII(arr);
        for (int i : nse) {
            System.out.print(i + " ");
        }
    }
}
