package Trees_BST;

public class Q4_InsertNodeBST {
    static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        TreeNode curr = root;

        while (true) {

            // if current value is less than val assign to right
            if (curr.data <= val) {

                // if there is a right then move to right
                // else create a right and assign val
                if (curr.right != null) {
                    curr = curr.right;
                } else {
                    curr.right = new TreeNode(val);
                    break;
                }
            }

            // if current value is greater than val assign to left
            else {
                if (curr.left != null) {
                    curr = curr.left;
                } else {
                    curr.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}
