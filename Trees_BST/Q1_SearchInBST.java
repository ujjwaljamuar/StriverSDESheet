package Trees_BST;

public class Q1_SearchInBST {
    static TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.data != val) {
            root = val < root.data ? root.left : root.right;
        }

        return root;
    }
}
