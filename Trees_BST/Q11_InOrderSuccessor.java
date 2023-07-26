package Trees_BST;

public class Q11_InOrderSuccessor {
    static TreeNode findInOrderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;

        while (root != null) {
            if (p.data >= root.data) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }

        return successor;
    }
}
