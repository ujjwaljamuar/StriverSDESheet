//package Recursion;

import java.util.*;

public class Q2_CombinationSumII {

    static void findCombinationII(int index, int arr[], int target, List<Integer> ds, List<List<Integer>> ans) {
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = index;i < arr.length; i++){
            if(i > index && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;

            ds.add(arr[i]);
            findCombinationII(i + 1, arr, target - arr[i], ds, ans);
            ds.remove(ds.size() - 1);
        }
    }

    static List<List<Integer>> returnCombinationSumII(int arr[], int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

        findCombinationII(0, arr, target,new ArrayList<>(), ans );
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 45 };
        int target = 5;

        System.out.println(returnCombinationSumII(arr, target));
        
    }
        
}
