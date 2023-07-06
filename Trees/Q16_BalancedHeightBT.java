package Trees;

public class Q16_BalancedHeightBT {

    static Boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    static int getHeight(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = getHeight(root.left);
        if (leftHeight == -1)
            return -1;

        int rightHeight = getHeight(root.right);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left = new TreeNode(5);

        String res = isBalanced(root) ? "Balanced" : "Not Balanced";
        System.out.println(res);
    }
}
