package Trees;

public class Q21_MaxPathSum {

    static int maxDownSum(TreeNode root, int[] maxValue) {
        if (root == null)
            return 0;

        int leftSum = Math.max(0, maxDownSum(root.left, maxValue));
        int rightSum = Math.max(0, maxDownSum(root.right, maxValue));

        maxValue[0] = Math.max(maxValue[0], leftSum + rightSum + root.data);

        return root.data + Math.max(leftSum, rightSum);

    }

    static int maxPSum(TreeNode root) {
        int[] maxValue = new int[1];
        maxValue[0] = Integer.MIN_VALUE;

        maxDownSum(root, maxValue);
        return maxValue[0];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int answer = maxPSum(root);
        System.out.println("The Max Path Sum for this tree is " + answer);
    }
}
