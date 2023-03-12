//package Recursion;

import java.util.*;

public class Q2_CombinationSumII {

    static void findCombinationII(int index, int arr[], int target, List<List<Integer>> ans, List<Integer> comb) {
        if(target == 0){
            ans.add(new ArrayList<>(comb));
            return;
        }

        for(int i = index;i < arr.length; i++){
            if(i > index && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;

            comb.add(arr[i]);
            findCombinationII(i + 1, arr, target - arr[i], ans, comb);
            comb.remove(comb.size() - 1);
        }
    }

    static List<List<Integer>> returnCombinationSumII(int arr[], int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

        findCombinationII(0, arr, target, ans, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 1,1,1,2,2 };
        int target = 4;

        // System.out.println(returnCombinationSumII(arr, target));
        List < List < Integer >> comb = returnCombinationSumII(arr,target);
        System.out.println(comb.toString().replace(",", " "));
    }
}
