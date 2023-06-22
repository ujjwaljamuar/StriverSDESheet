package Trees;

import java.util.*;

public class Q6_RightViewTree {

    static void RightViewTrav(TreeNode curr, List<Integer> ds, int level) {
        if (curr == null)
            return;
        if (level == ds.size())
            ds.add(curr.data);

        RightViewTrav(curr.right, ds, level + 1);
        RightViewTrav(curr.left, ds, level + 1);

    }

    static List<Integer> RightView(TreeNode root) {
        List<Integer> ds = new ArrayList<>();

        RightViewTrav(root, ds, 0);

        return ds;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(RightView(root));
    }
}
