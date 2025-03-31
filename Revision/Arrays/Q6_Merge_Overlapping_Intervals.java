import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q6_Merge_Overlapping_Intervals {
    List<int[]> mergeOptimal(int[][] intervals){
        int n = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < n; i++){
            if(ans.isEmpty() || intervals[i][0] > ans.get(ans.size() - 1)[1]){
                ans.add(intervals[i]);
            }
            else{
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], intervals[i][1]);
            }
        } 
        return ans;
    }

    List<int[]> mergeBrute(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            // check if already merged
            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1)[1]) {
                continue;
            }

            // check the next one
            for (int j = i + 1; j < n; j++) {
                if (intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            }

            ans.add(new int[] { start, end });
        }

        return ans;
        // merged.toArray(new int[merged.size()][])
    }

    public static void main(String[] args) {
        Q6_Merge_Overlapping_Intervals ar = new Q6_Merge_Overlapping_Intervals();

        int[][] intervals = {
                { 1, 3 },
                { 2, 6 },
                { 2, 4 },
                { 15, 18 },
                { 8, 10 },
        };

        // System.out.println(Arrays.deepToString((ar.mergeBrute(intervals).toArray())));
        System.out.println(Arrays.deepToString((ar.mergeBrute(intervals).toArray())));
    }
}
