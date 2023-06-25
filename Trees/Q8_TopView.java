package Trees;

import java.util.*;

public class Q8_TopView {

    static ArrayList<Integer> topView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<Pair>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair it = q.remove();
            int hd = it.hd;
            TreeNode temp = it.node;

            if (map.get(hd) == null)
                map.put(hd, temp.data);

            if (temp.left != null) {
                q.add(new Pair(temp.left, hd - 1));
            }

            if (temp.right != null) {
                q.add(new Pair(temp.right, hd + 1));
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(topView(root));
    }
}

class Pair {
    TreeNode node;
    int hd;

    public Pair(TreeNode val, int hd) {
        this.node = val;
        this.hd = hd;
    }

}