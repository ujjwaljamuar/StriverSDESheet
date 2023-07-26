package Trees_BST;

class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode() {
    }

    public TreeNode(int key) {
        this.data = key;
    }

    public TreeNode(int key, TreeNode _left, TreeNode _right) {
        this.data = key;
        this.left = _left;
        this.right = _right;
    }

}

public class BST {
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

    public static void inorderTraversal(TreeNode root) {

        // Check whether tree is empty
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        } else {

            if (root.left != null)
                inorderTraversal(root.left);
            System.out.print(root.data + " ");
            if (root.right != null)
                inorderTraversal(root.right);

        }

    }

    public static void main(String[] args) {
        TreeNode root = null;

        int[] arr = { 5, 2, 4, 3, 1, 8, 9, 10, 7, 6 };

        for (int a : arr) {
            root = insertIntoBST(root, a);
        }

        inorderTraversal(root);
    }

}
