public class Q7_JumpGame1 {
    boolean canJump(int[] nums) {
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i > maxIndex) {
                return false;
            }

            maxIndex = Math.max(maxIndex, i + nums[i]);
        }

        return true;
    }

    public static void main(String[] args) {
        Q7_JumpGame1 grd = new Q7_JumpGame1();

        int[] nums = { 4, 3, 7, 1, 2 };

        System.out.println(grd.canJump(nums));
    }
}
