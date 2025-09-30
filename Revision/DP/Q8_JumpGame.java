package DP;

public class Q8_JumpGame {
    boolean canJump(int[] nums) {
        int n = nums.length;
        int maxJumps = 0;

        for(int i = 0; i < n; i++){
            if(i > maxJumps){
                return false;
            }
        
            maxJumps = Math.max(maxJumps, i+nums[i]);
        }

        return true;
    }
}
