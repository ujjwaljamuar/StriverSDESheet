package Trees;

class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int key) {
        this.data = key;
        left = null;
        right = null;
    }
}

public class BinaryTree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(4);
        root.right = new TreeNode(5);

        root.left.right = new TreeNode(7);
    }
}
