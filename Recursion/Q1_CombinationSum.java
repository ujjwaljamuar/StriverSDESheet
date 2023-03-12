//package Recursion;

import java.util.*;

public class Q1_CombinationSum {

    static void findCombination(int index, int[] arr, int target, List<Integer> ds, List<List<Integer>> result){
        if(index == arr.length){
            if(target == 0){
                result.add(new ArrayList<>(ds));
            }
            return;
        }

        // picked
        if(arr[index] <= target){
            ds.add(arr[index]);
            findCombination(index, arr, target-arr[index], ds, result);
            ds.remove(ds.size() - 1);
        }

        // not picked
        findCombination(index+1, arr, target, ds, result);
    }

    static List<List<Integer>> comboSum(int[] arr, int target){
        List<List<Integer>> result = new ArrayList<>();

        findCombination(0, arr, target, new ArrayList<>(), result);

        return result;
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};

        int target = 7;

        System.out.println(comboSum(candidates, target).toString());
    }
}

    