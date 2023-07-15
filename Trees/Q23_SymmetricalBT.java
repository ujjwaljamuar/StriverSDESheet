package Trees;

public class Q23_SymmetricalBT {

    static boolean checkSymmetric(TreeNode root) {
        return root == null || isSymmeetric(root.left, root.right);
    }

    static boolean isSymmeetric(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }

        if (left.data != right.data)
            return false;

        return isSymmeetric(left.left, right.right) && isSymmeetric(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        boolean res;
        res = checkSymmetric(root);

        if (res)
            System.out.println("The tree is symmetrical");
        else
            System.out.println("The tree is NOT symmetrical");

    }
}
