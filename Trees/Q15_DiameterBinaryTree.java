package Trees;

public class Q15_DiameterBinaryTree {

    static int getDiameter(TreeNode root) {
        int[] diameter = new int[1];

        getHeight(root, diameter);

        return diameter[0];
    }

    static int getHeight(TreeNode root, int[] diameter) {
        if (root == null)
            return 0;

        int leftHeight = getHeight(root.left, diameter);
        int rightHeight = getHeight(root.right, diameter);

        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(5);
        root.right.left.left.left = new TreeNode(9);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);
        root.right.right.right.right = new TreeNode(8);

        System.out.println("Diameter of the Binary Tree is : " + getDiameter(root));
    }
}
