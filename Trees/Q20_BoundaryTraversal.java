package Trees;

import java.util.ArrayList;

public class Q20_BoundaryTraversal {

    static boolean isLeaf(TreeNode root) {
        return (root.left == null) && (root.right == null);
    }

    static void addLeftBoundary(TreeNode root, ArrayList<Integer> ans) {
        TreeNode curr = root.left;

        while (curr != null) {
            if (isLeaf(curr) == false)
                ans.add(curr.data);

            if (curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }

    static void addLeaves(TreeNode root, ArrayList<Integer> ans) {
        if (isLeaf(root)) {
            ans.add(root.data);
            return;
        }

        if (root.left != null)
            addLeaves(root.left, ans);
        if (root.right != null)
            addLeaves(root.right, ans);
    }

    static void addRightBoundary(TreeNode root, ArrayList<Integer> ans) {
        ArrayList<Integer> temp = new ArrayList<>();
        TreeNode curr = root.right;

        while (curr != null) {
            if (isLeaf(curr) == false)
                temp.add(curr.data);

            if (curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }

        for (int i = temp.size() - 1; i >= 0l; --i) {
            ans.add(temp.get(i));
        }
    }

    static ArrayList<Integer> boundaryTraversalAntiClockwise(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (isLeaf(root) == false)
            ans.add(root.data);

        addLeftBoundary(root, ans);
        addLeaves(root, ans);
        addRightBoundary(root, ans);

        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(4);
        root.left.left.right.left = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.left.left = new TreeNode(10);
        root.right.right.left.right = new TreeNode(11);

        ArrayList<Integer> boundaryTraversal;
        boundaryTraversal = boundaryTraversalAntiClockwise(root);

        System.out.println("The Boundary Traversal is : ");
        for (int i = 0; i < boundaryTraversal.size(); i++) {
            System.out.print(boundaryTraversal.get(i) + " ");
        }
    }
}
