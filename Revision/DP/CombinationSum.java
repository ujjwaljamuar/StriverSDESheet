package DP;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    static void util(int index, int target, int[] arr, List<Integer> list, List<List<Integer>> result) {
        if (index == arr.length) {
            if (target == 0) {
                result.add(new ArrayList<>(list));
            }
            return;
        }
        // pick
        if (arr[index] <= target) {
            list.add(arr[index]);
            util(index, target - arr[index], arr, list, result);
            list.remove(list.size() - 1);
        }

        // not pick
        util(index + 1, target, arr, list, result);
    }

    static List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();

        util(0, target, arr, new ArrayList<>(), result);

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 6, 7 };
        int target = 7;

        System.out.println(combinationSum(arr, target));
    }
}
