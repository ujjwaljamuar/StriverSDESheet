package Trees;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;

public class Q19_ZigZagTraversal {

    static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ds = new ArrayList<>();

        if (root == null)
            return ds;

        q.offer(root);

        boolean isLeftToRight = true;

        while (!q.isEmpty()) {
            int level = q.size();
            ArrayList<Integer> subList = new ArrayList<>();

            for (int i = 0; i < level; i++) {
                if (q.peek().left != null)
                    q.offer(q.peek().left);

                if (q.peek().right != null)
                    q.offer(q.peek().right);

                if (isLeftToRight) {
                    subList.add(q.poll().data);
                } else {
                    subList.add(0, q.poll().data);
                }
            }

            isLeftToRight = !isLeftToRight;
            ds.add(subList);
        }

        return ds;
    }

    static ArrayList<Integer> zigzagLevelOrder2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> ds = new ArrayList<>();

        if (root == null)
            return ds;

        q.offer(root);

        boolean isLeftToRight = true;

        while (!q.isEmpty()) {
            int level = q.size();
            ArrayList<Integer> subList = new ArrayList<>();

            for (int i = 0; i < level; i++) {
                if (q.peek().left != null) {
                    q.offer(q.peek().left);
                }

                if (q.peek().right != null) {
                    q.offer(q.peek().right);
                }

                if (isLeftToRight) {
                    subList.add(q.poll().data);
                } else {
                    subList.add(0, q.poll().data);
                }
            }

            for (int val : subList) {
                ds.add(val);
            }

            isLeftToRight = !isLeftToRight;

        }

        return ds;
    }

    public static void main(String[] args) {
        int i, j;
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        ArrayList<ArrayList<Integer>> ans;
        ans = zigzagLevelOrder(root);
        System.out.println("Zig Zag Traversal of Binary Tree ");
        for (i = 0; i < ans.size(); i++) {
            for (j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }

        System.out.println(zigzagLevelOrder2(root));

    }
}
