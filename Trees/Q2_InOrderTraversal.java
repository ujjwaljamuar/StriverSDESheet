package Trees;

import java.util.ArrayList;

public class Q2_InOrderTraversal {

    static void inOrderTrav(TreeNode curr, ArrayList<Integer> inOrder) {
        if (curr == null)
            return;

        inOrderTrav(curr.left, inOrder);
        inOrder.add(curr.data);
        inOrderTrav(curr.right, inOrder);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(10);

        ArrayList<Integer> inOrder = new ArrayList<>();

        inOrderTrav(root, inOrder);

        System.out.println(inOrder);
    }
}
