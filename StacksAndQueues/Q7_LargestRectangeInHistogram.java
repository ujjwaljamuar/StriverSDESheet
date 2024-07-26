import java.util.Stack;

public class Q7_LargestRectangeInHistogram {

    // using dual pass
    // figure out which element on right is smaller than ith height, that will be
    // your boundary
    // and do that for right also
    int maxArea2(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];

        for (int i = 0; i < n; i++) {
            // find the boundary
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                leftSmall[i] = 0;
            } else {
                leftSmall[i] = st.peek() + 1;
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            st.pop();
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                rightSmall[i] = n - 1;
            } else {
                rightSmall[i] = st.peek() - 1;
            }

            st.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
        }

        return maxArea;
    }

    /*
     * brute
     * run a for loop for every element with finding the number of elements before
     * next smaller element
     */
    int maxArea1(int arr[], int n) {
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, arr[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Q7_LargestRectangeInHistogram sq = new Q7_LargestRectangeInHistogram();

        int[] heights = { 2, 1, 5, 6, 2, 3 };
        System.out.println(sq.maxArea2(heights));
    }
}
