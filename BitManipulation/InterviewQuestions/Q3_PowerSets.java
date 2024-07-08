package InterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class Q3_PowerSets {
    List<List<Integer>> printSubset(int[] numsArr){
        List<List<Integer>> subsets = new ArrayList<>();

        int totalSubset = 1 << numsArr.length;
        int n = numsArr.length;

        for(int num = 0; num < totalSubset; num++){
            List<Integer> list = new ArrayList<>();
            
            for(int i = 0; i < n ; i++){

                // if its a non zero number
                if((num & (1 << i)) != 0){
                    list.add(numsArr[i]);
                }
            }

            subsets.add(list);
        }

        return subsets;
    }
    public static void main(String[] args) {
        Q3_PowerSets bitwise = new Q3_PowerSets();

        int[] nums = {1,2,3};

        System.out.println(bitwise.printSubset(nums));

    }
}
