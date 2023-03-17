import java.util.ArrayList;
import java.util.List;

// package Recursion_BackTracking

class Q1_PrintAllCombination{

    // for Array
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

    // for String
    static void findPermutation(int index, char[] charArr, List<String> res){
        if(index == charArr.length){
            String permStr = "";
            for(int i = 0; i< charArr.length; i++){
                permStr = permStr + charArr[i];
            }

            res.add(permStr);
            return;
        }

        for(int i = index; i< charArr.length; i++){
            swap(i, index, charArr);
            findPermutation(index + 1, charArr, res);
            swap(i, index, charArr);
        }
    }

    static void swap(int i, int j, char[] charArr){
        char a = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = a;
    }


    static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> result = new ArrayList<>();

        findPermutation(0, nums, result);

        return result;
    }

    static List<String> permute(String s){
        List<String> res = new ArrayList<>();

        char[] charArr = s.toCharArray();

        findPermutation(0, charArr, res);

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        String s = "abc";
        System.out.println(permute(nums));
        System.out.println(permute(s));
    }
}