package Trees;

import java.util.*;

public class Q4_MorrisTraversal {

    static List<Integer> morrInOrderTrav(TreeNode root) {
        List<Integer> morrInorder = new ArrayList<>();

        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                morrInorder.add(curr.data);
                curr = curr.right;
            }

            // if curr.left is not null
            else {
                TreeNode prev = curr.left;

                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = curr; // threading to the root
                    curr = curr.left;
                }

                // prev.right is not null
                else {
                    prev.right = null;
                    morrInorder.add(curr.data);
                    curr = curr.right;
                }
            }
        }

        return morrInorder;
    }
    // time complexity: O(N)
    // space complexity: O(1)

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(10);

        System.out.println(morrInOrderTrav(root));
    }
}
