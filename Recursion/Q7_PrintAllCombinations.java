import java.util.ArrayList;
import java.util.List;

//package Recursion;

public class Q7_PrintAllCombinations {

    static void findPermutation(int[] nums, boolean[] marked, List<Integer> ds, List<List<Integer>> result) {
        // base case
        if (ds.size() == nums.length) {
            result.add(new ArrayList<>(ds));
            return;
        }

        // loop through non marked ones
        for (int i = 0; i < nums.length; i++) {
            if (!marked[i]) {
                marked[i] = true;
                ds.add(nums[i]);
                findPermutation(nums, marked, ds, result);
                marked[i] = false;
                ds.remove(ds.size() - 1);
            }
        }
    }

    static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] marked = new boolean[nums.length];

        findPermutation(nums, marked, ds, result);

        return result;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        System.out.println(permute(nums));
    }
}
