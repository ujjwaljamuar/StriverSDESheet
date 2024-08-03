public class Q9_TrappingRainwater {
    int trap2(int[] heights) {
        int left = 0, right = heights.length - 1;
        int totalWaterTrapped = 0, leftMax = 0, rightMax = 0;

        while (left <= right) {
            
            // if height of the left block is less than the right one
            if (heights[left] <= heights[right]) {
                if (heights[left] >= leftMax) {
                    leftMax = heights[left];
                } else {
                    totalWaterTrapped += leftMax - heights[left];
                }

                left++;
            }
            // if height of right is less than left
            else {
                if (heights[right] >= rightMax) {
                    rightMax = heights[right];
                } else {
                    totalWaterTrapped += rightMax - heights[right];
                }
                right--;
            }
        }
        return totalWaterTrapped;
    }

    // Brute force
    int trap1(int[] heights) {
        int totalWaterTrapped = 0;
        for (int i = 0; i < heights.length; i++) {
            int leftmax = 0, rightmax = 0;

            int j = i;

            while (j >= 0) {
                leftmax = Math.max(leftmax, heights[j]);
                j--;
            }

            j = i;

            while (j < heights.length) {
                rightmax = Math.max(rightmax, heights[j]);
                j++;
            }

            // if (leftmax > heights[i] && rightmax > heights[i]) {
            // totalWaterTrapped += (Math.min(leftmax, rightmax)) - heights[i];
            // }
            totalWaterTrapped += Math.min(leftmax, rightmax) - heights[i];
        }
        return totalWaterTrapped;
    }

    public static void main(String[] args) {
        Q9_TrappingRainwater sq = new Q9_TrappingRainwater();

        int[] height = { 4, 2, 0, 3, 2, 5 };

        System.out.println(sq.trap2(height));

    }
}
