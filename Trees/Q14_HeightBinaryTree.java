package Trees;

public class Q14_HeightBinaryTree {
    static int maxHeight(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = maxHeight(root.left);
        int rightHeight = maxHeight(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(6);

        System.out.println("Height of the Binary Tree is : " + maxHeight(root));
    }
}
