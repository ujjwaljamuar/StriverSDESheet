package Recursion;

import java.util.*;

public class PrintSubsequence {
    static int[] arr = { 3, 1, 2 };
    static List<List<Integer>> ans = new ArrayList<>();

    static List<List<Integer>> subseq(int index, List<Integer> list) {
        if (index >= arr.length) {
            ans.add(new ArrayList<>(list));
            return ans;
        }

        // pick
        list.add(arr[index]);
        subseq(index + 1, list);

        // not pick
        list.remove(list.size() - 1);
        subseq(index + 1, list);

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(subseq(0, new ArrayList<>()));
    }
}
