package SpanningTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q8_AccountsMerge {

    List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (map.containsKey(mail) == false) {
                    map.put(mail, i);
                }

                else {
                    ds.unionBySize(i, map.get(mail));
                }
            }
        }

        ArrayList<ArrayList<String>> mergedMails = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            mergedMails.add(new ArrayList<>());
        }

        for (Map.Entry<String, Integer> it : map.entrySet()) {
            String mail = it.getKey();
            int node = ds.findUPar(it.getValue());
            mergedMails.get(node).add(mail);
        }

        List<List<String>> newAccounts = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (mergedMails.get(i).size() == 0) {
                continue;
            }

            Collections.sort(mergedMails.get(i));

            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));

            for (String it : mergedMails.get(i)) {
                temp.add(it);
            }

            newAccounts.add(temp);
        }

        return newAccounts;
    }

    public static void main(String[] args) {
        Q8_AccountsMerge graph = new Q8_AccountsMerge();
        List<List<String>> accounts = List.of(
                new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com")),
                new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com")),
                new ArrayList<>(Arrays.asList("Mary", "mary@mail.com")),
                new ArrayList<>(Arrays.asList("John", "johnnybravo@mail.com")));

        System.out.println(accounts + "\n");

        System.out.println("merged \n" + graph.accountsMerge(accounts));
    }

    private static class DisjointSet {
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                size.add(0);
                parent.add(i);
            }
        }

        int findUPar(int node) {
            if (node == parent.get(node)) {
                return node;
            }

            parent.set(node, findUPar(parent.get(node)));
            return parent.get(node);
        }

        void unionBySize(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);

            if (ulp_u == ulp_v) {
                return;
            }

            if (size.get(ulp_u) < size.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
            } else {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }

    }
}
