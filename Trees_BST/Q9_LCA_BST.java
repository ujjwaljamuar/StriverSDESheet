package Trees_BST;

public class Q9_LCA_BST {
    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode u, TreeNode v) {
        if (root == null)
            return null;

        int currVal = root.data;

        if (currVal < u.data && currVal < v.data) {
            return lowestCommonAncestor(root.right, u, v);
        }

        if (currVal > u.data && currVal > v.data) {
            return lowestCommonAncestor(root.left, u, v);
        }

        return root;
    }
}
