package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q9_NearestCell1 {
    ArrayList<ArrayList<Integer>> nearestCellwithOne(ArrayList<ArrayList<Integer>> mat) {
        int n = mat.size();
        int m = mat.get(0).size();

        int[][] isVisited = new int[n][m];
        ArrayList<ArrayList<Integer>> disMat = mat;

        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat.get(i).get(j) == 1) {
                    isVisited[i][j] = 1;
                    q.add(new Node(i, j, 0));
                }
            }
        }

        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().third;

            q.remove();
            disMat.get(row).set(col, steps);

            for (int i = 0; i < 4; i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && isVisited[nRow][nCol] == 0) {
                    isVisited[nRow][nCol] = 1;
                    q.add(new Node(nRow, nCol, steps + 1));
                }
            }
        }

        return disMat;
    }

    public static void main(String[] args) {
        Q9_NearestCell1 graph = new Q9_NearestCell1();

        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();

        // Adding elements to ArrayList of ArrayList using hardcoding
        mat.add(new ArrayList<>());
        mat.get(0).add(0);
        mat.get(0).add(1);
        mat.get(0).add(1);
        mat.get(0).add(0);

        mat.add(new ArrayList<>());
        mat.get(1).add(1);
        mat.get(1).add(1);
        mat.get(1).add(0);
        mat.get(1).add(0);

        mat.add(new ArrayList<>());
        mat.get(2).add(0);
        mat.get(2).add(0);
        mat.get(2).add(1);
        mat.get(2).add(1);

        System.out.println(graph.nearestCellwithOne(mat));
    }
}

class Node {
    int first, second, third;

    Node(int _first, int _second, int _third) {
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}