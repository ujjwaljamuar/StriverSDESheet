package Trees;

import java.util.LinkedList;
import java.util.Queue;

class Pairr {
    TreeNode node;
    int num;

    public Pairr(TreeNode _node, int _num) {
        this.node = _node;
        this.num = _num;
    }
}

public class Q12_WidthOfBinaryTree {

    static int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        int ans = 0;
        Queue<Pairr> q = new LinkedList<>();

        q.offer(new Pairr(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int mmin = q.peek().num; // to make the id starting from zero
            int first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                int cur_id = q.peek().num - mmin;
                TreeNode node = q.peek().node;

                q.poll();

                if (i == 0)
                    first = cur_id;
                if (i == size - 1)
                    last = cur_id;
                if (node.left != null)
                    q.offer(new Pairr(node.left, cur_id * 2 + 1));
                if (node.right != null)
                    q.offer(new Pairr(node.right, cur_id * 2 + 2));
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(6);

        int maxWidth = widthOfBinaryTree(root);
        System.out.println("The maximum width of the Binary Tree is " + maxWidth);
    }
}
