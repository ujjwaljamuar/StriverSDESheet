package Trees;

class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(){}

    public TreeNode(int key) {
        this.data = key;
    }

    public TreeNode(int key, TreeNode _left, TreeNode _right) {
        this.data = key;
        this.left = _left;
        this.right = _right;
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
