import java.util.Arrays;

public class Q1_MergeTwoSortedArrays {
    void merger(int[] nums1, int m, int[] nums2, int n) {

        if (m == 0) {
            nums1 = nums2;
        } else if (n == 0) {
            return;
        } else {
            int left = nums1.length - 1;
            int right = 0;
            while (left >= 0 && right < n) {
                if (nums1[left] > nums2[right]) {
                    // int temp = nums1[left];
                    // nums1[left] = nums2[right];
                    // nums2[right] = temp;

                    nums1[left] = nums1[left] ^ nums2[right];
                    nums2[right] = nums1[left] ^ nums2[right];
                    nums1[left] = nums1[left] ^ nums2[right];
                    left--;
                    right++;
                } else {
                    break;
                }
            }

            Arrays.sort(nums1);
            System.out.println(Arrays.toString(nums1));

            Arrays.sort(nums2);
            System.out.println(Arrays.toString(nums2));

            // nums1 = new int[m+n];
            // for(int i = 0, j = m; j < nums1.length; i++,j++){
            //     nums1[i] = nums1[j];
            // }
            // System.out.println(Arrays.toString(nums1));
            // System.out.println(Arrays.toString(nums2));
            // for(int i = n, j = 0; j < nums2.length; i++, j++){
            //     nums1[i] = nums2[j];
            // }

            // System.out.println(Arrays.toString(nums1));
        }
    }

    public static void main(String[] args) {
        Q1_MergeTwoSortedArrays lc = new Q1_MergeTwoSortedArrays();

        int[] nums1 = { 1, 2, 3};
        int[] nums2 = { 2, 5, 6 };

        int m = 3, n = 3;

        lc.merger(nums1, m, nums2, n);

        // System.out.println(Arrays.toString(nums1));

    }
}
