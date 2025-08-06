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

    static void solve(int i, String s, String f) {
        if (i == s.length()) {
            System.out.print(f + " ");
            return;
        }
        // picking
        // f = f + s.charAt(i);
        solve(i + 1, s, f + s.charAt(i));
        // poping out while backtracking
        // f.pop_back();
        solve(i + 1, s, f);
    }

    public static void main(String[] args) {
        System.out.println(subseq(0, new ArrayList<>()));
    }
}
