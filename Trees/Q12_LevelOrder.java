package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q12_LevelOrder {

    static List<Integer> levelOrderTrav(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> levelOrder = new ArrayList<>();

        if (root == null)
            return levelOrder;
        q.offer(root);

        while (!q.isEmpty()) {
            if (q.peek().left != null) {
                q.offer(q.peek().left);
            }

            if (q.peek().right != null) {
                q.offer(q.peek().right);
            }

            levelOrder.add(q.poll().data);
        }

        return levelOrder;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(levelOrderTrav(root));
    }
}
