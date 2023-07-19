package Trees_BST;

public class Q5_DeleteNodeBST {

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.data == key) {
            return helper(root);
        }
        TreeNode dummy = root;
        while (root != null) {
            if (root.data > key) {
                if (root.left != null && root.left.data == key) {
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if (root.right != null && root.right.data == key) {
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return dummy;
    }

    public static TreeNode helper(TreeNode root) {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else {
            TreeNode rightChild = root.right;
            TreeNode lastRight = findLastRight(root.left);
            lastRight.right = rightChild;
            return root.left;
        }
    }

    public static TreeNode findLastRight(TreeNode root) {
        if (root.right == null) {
            return root;
        }
        return findLastRight(root.right);
    }
}
