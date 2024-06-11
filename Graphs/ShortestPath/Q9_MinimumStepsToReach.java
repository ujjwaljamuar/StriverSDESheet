package ShortestPath;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q9_MinimumStepsToReach {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, start));
        
        int[] dist = new int[100000];
        Arrays.fill(dist,(int) 1e9);
        dist[start] = 0;
        
        int mod = 100000;
        int n = arr.length;
        
        while(!q.isEmpty()){
            int steps = q.peek().distance;
            int node = q.peek().node;
            q.remove();
            
            for(int i = 0; i < n; i++){
                int num = (arr[i] * node) % mod;
                
                if(steps + 1 < dist[num]){
                    dist[num] = steps+ 1;
                    
                    if(num == end){
                        return steps+1;
                    }
                    
                    q.add(new Pair(steps+1, num));
                }
            }
        }
        
        return -1;
    }
    public static void main(String[] args) {
        Q9_MinimumStepsToReach graph = new Q9_MinimumStepsToReach();

        int start=3, end=30;
        int[] arr = {2,5,7};

        System.out.print(graph.minimumMultiplications(arr, start, end));
    }

    private class Pair{
        int distance, node;
        
        Pair(int _d, int _n){
            this.distance = _d;
            this.node = _n;
        }
    }
}
