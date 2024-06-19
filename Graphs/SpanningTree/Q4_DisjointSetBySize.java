package SpanningTree;

import java.util.ArrayList;

public class Q4_DisjointSetBySize {
    private static class DisjointSet {
        ArrayList<Integer> size = new ArrayList<>();
        ArrayList<Integer> parent = new ArrayList<>();
    
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
            }
    
            else if (size.get(ulp_v) < size.get(ulp_u)) {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
    
            else {
                parent.set(ulp_v, ulp_u);
                int sizeU = size.get(ulp_u);
                size.set(ulp_u, sizeU + 1);
            }
        }
    }
    
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);

        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }

        ds.unionBySize(3, 7);

        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }
    }
}

