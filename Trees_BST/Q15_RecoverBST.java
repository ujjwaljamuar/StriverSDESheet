package Trees_BST;

public class Q15_RecoverBST {
    private TreeNode first;
    private TreeNode prev;
    private TreeNode middle;
    private TreeNode last;

    public void inOrder(TreeNode root) {
        if (root == null)
            return;

        inOrder(root.left);

        if (prev != null && (root.data < prev.data)) {

            // If this is first violation, mark these two nodes as
            // 'first' and 'middle'
            if (first == null) {
                first = prev;
                middle = root;
            }

            // If this is second violation, mark this node as last
            else
                last = root;
        }

        // Mark this node as previous
        prev = root;
        inOrder(root.right);
    }

    public void recover(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);

        if (first != null && last != null) {
            int t = first.data;
            first.data = last.data;
            last.data = t;
        } else if (first != null && middle != null) {
            int t = first.data;
            first.data = middle.data;
            middle.data = t;
        }
    }
}
