import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//package Recursion;

public class Q4_SubsetSumsII {

    public static void findSubsets(int index, int[] arr, List<Integer> ds, List<List<Integer>> result) {

        result.add(new ArrayList<>(ds));

        for (int i = index; i < arr.length; i++) {
            if (i != index && arr[i] == arr[i - 1])
                continue;

            ds.add(arr[i]);
            findSubsets(i + 1, arr, ds, result);
            ds.remove(ds.size() - 1);
        }

    }

    public static List<List<Integer>> subsetsWithDup(int[] arr) {
        Arrays.sort(arr);

        List<List<Integer>> result = new ArrayList<>();
        findSubsets(0, arr, new ArrayList<>(), result);
        
        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 2 };
        
        System.out.println(subsetsWithDup(arr).toString());
    }
}
