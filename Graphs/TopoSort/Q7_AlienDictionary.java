package TopoSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q7_AlienDictionary {

    String findOrder(String[] dict, int N, int K) {
        // Write your code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int ptr = 0; ptr < len; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }

        List<Integer> topoSort = topoSort(K, adj);

        String ans = "";
        for (int it : topoSort) {
            ans += (char) (it + (int) 'a');
        }

        return ans;

    }

    List<Integer> topoSort(int K, List<List<Integer>> adjList) {
        int[] inDegree = new int[K];
        for (int i = 0; i < K; i++) {
            for (int it : adjList.get(i)) {
                inDegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> topoSort = new ArrayList<>();
        // int count = 0;

        while (!q.isEmpty()) {
            int node = q.remove();
            topoSort.add(node);

            for (int it : adjList.get(node)) {
                inDegree[it]--;

                if (inDegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        return topoSort;
    }

    public static void main(String[] args) {
        Q7_AlienDictionary graph = new Q7_AlienDictionary();
        int N = 5, K = 4;
        String[] dict = { "baa", "abcd", "abca", "cab", "cad" };
        String ans = graph.findOrder(dict, N, K);

        for (int i = 0; i < ans.length(); i++) {
            System.out.print(ans.charAt(i) + " ");
        }
        System.out.println("");
    }
}
