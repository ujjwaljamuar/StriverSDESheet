import java.util.ArrayList;
import java.util.List;

// package Recursion_BackTracking

class Q1_PrintAllCombination{

    static void findPermutation(int index, int[] nums, List<List<Integer>> result){
        List<Integer> ds = new ArrayList<>();
        if(index == nums.length){
            for(int i = 0; i<nums.length; i++){
                ds.add(nums[i]);
            }

            result.add(new ArrayList<>(ds));
            return;
        }

        for(int i = index; i< nums.length;i++){
            swap(i, index, nums);
            findPermutation(index + 1, nums, result);
            swap(i, index, nums);
        }
    }

    static void swap(int i, int j, int[] nums){
        int a = nums[i];
        nums[i] = nums[j];
        nums[j] = a;
    }

    static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> result = new ArrayList<>();

        findPermutation(0, nums, result);

        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
}