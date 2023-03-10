package Recursion;

import java.util.*;

public class Q3_SubsetSum {
    
    static void findSum(int index, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> subsetSums){

        // if (pointer reached the last index)
        if(index == N){
            subsetSums.add(sum);
            return;
        }

        // if the element gets picked
        findSum(index+1, sum+arr.get(index), arr, N, subsetSums);

        // if the element did not get picked
        findSum(index+1, sum, arr, N, subsetSums);
    }

    static ArrayList<Integer> subsetSumPrb(ArrayList<Integer> arr, int N){
        ArrayList<Integer> subsetSums = new ArrayList<>();

        findSum(0,0,arr,N, subsetSums);
        Collections.sort(subsetSums);

        return subsetSums;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(3);
        input.add(1);
        input.add(2);

        ArrayList<Integer> result = subsetSumPrb(input, input.size());

        System.out.println(result);
    }
}
