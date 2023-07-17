package Trees;

public class Q25_CheckChildrenSum {

    static void changeTree(TreeNode root) {
        if (root == null)
            return;
        int child = 0;
        if (root.left != null) {
            child += root.left.data;
        }
        if (root.right != null) {
            child += root.right.data;
        }

        if (child < root.data) {
            if (root.left != null)
                root.left.data = root.data;
            else if (root.right != null)
                root.right.data = root.data;
        }

        changeTree(root.left);
        changeTree(root.right);

        int total = 0;
        if (root.left != null)
            total += root.left.data;
        if (root.right != null)
            total += root.right.data;
        if (root.left != null || root.right != null)
            root.data = total;
    }

    public static void main(String[] args) {

    }
}
