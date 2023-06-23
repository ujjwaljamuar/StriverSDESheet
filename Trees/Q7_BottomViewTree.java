package Trees;

import java.util.*;

public class Q7_BottomViewTree {

    static ArrayList<Integer> bottomView(NodeBV root) {
        ArrayList<Integer> res = new ArrayList<>();

        if (root == null)
            return res;

        Queue<NodeBV> q = new LinkedList<NodeBV>();
        Map<Integer, Integer> map = new TreeMap<>();

        root.hd = 0;
        q.add(root);

        while (!q.isEmpty()) {
            NodeBV temp = q.remove();
            int hd = temp.hd;
            map.put(hd, temp.data);

            if (temp.left != null) {
                temp.left.hd = hd - 1;
                q.add(temp.left);
            }

            if (temp.right != null) {
                temp.right.hd = hd + 1;
                q.add(temp.right);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
    }

    public static void main(String[] args) {
        NodeBV root = new NodeBV(1);
        root.left = new NodeBV(2);
        root.right = new NodeBV(3);
        root.left.left = new NodeBV(4);
        root.left.right = new NodeBV(5);
        root.left.right.left = new NodeBV(8);
        root.left.right.right = new NodeBV(9);
        root.right.left = new NodeBV(6);
        root.right.right = new NodeBV(7);

        System.out.println(bottomView(root));
    }
}

class NodeBV {
    int data, hd;
    NodeBV left, right;

    public NodeBV(int key) {
        this.data = key;
        left = null;
        right = null;
    }
}