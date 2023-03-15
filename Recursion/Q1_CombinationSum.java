//package Recursion;

import java.util.*;

public class Q1_CombinationSum {

    static void findCombination(int index, ArrayList<Integer> arr, int target, List<Integer> ds, ArrayList<ArrayList<Integer>> result){
        if(index == arr.size()){
            if(target == 0){
                result.add(new ArrayList<>(ds));
            }
            return;
        }

        // picked
        if(arr.get(index) <= target){
            ds.add(arr.get(index));
            findCombination(index, arr, target-arr.get(index), ds, result);
            ds.remove(ds.size() - 1);
        }

        // not picked
        findCombination(index+1, arr, target, ds, result);
    }

    static ArrayList<ArrayList<Integer>> comboSum(ArrayList<Integer> arr, int target){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        findCombination(0, arr, target, new ArrayList<>(), result);

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> candidates = new ArrayList<>();
        candidates.add(8);
        candidates.add(1);
        candidates.add(8);
        candidates.add(6);
        candidates.add(8);

        int target = 12;

        System.out.println(comboSum(candidates, target).toString());
    }
}

    