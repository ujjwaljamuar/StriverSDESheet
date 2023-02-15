package Recursion;

import java.util.*;

public class Q1_CombinationSum {

    static void findCombination(int index, int arr[], int target, List<List<Integer>> ans, List<Integer> comb) {
        if (index == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(comb));
            }
            return;
        }

        if (arr[index] <= target) {
            comb.add(arr[index]);
            findCombination(index, arr, target - arr[index], ans, comb);
            comb.remove(comb.size() - 1);
        }
        findCombination(index + 1, arr, target, ans, comb);
    }

    static List<List<Integer>> returnCombinationSum(int arr[], int target) {
        List<List<Integer>> ans = new ArrayList<>();

        findCombination(0, arr, target, ans, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 6, 7 };
        int target = 7;

        System.out.println(returnCombinationSum(arr, target));
    }
}
