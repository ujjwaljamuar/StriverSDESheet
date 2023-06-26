package Trees;

import java.util.*;

public class Q9_EveryOrderTrav {
    static void allOrder(TreeNode root, List<Integer> pre, List<Integer> in, List<Integer> post) {
        Stack<Pair1> st = new Stack<Pair1>();
        st.push(new Pair1(root, 1));

        if (root == null)
            return;

        while (!st.isEmpty()) {
            Pair1 it = st.pop();

            // this is part of pre
            // increment 1 to 2
            // push the left side of the tree
            if (it.num == 1) {
                pre.add(it.node.data);
                it.num++;
                st.push(it);

                if (it.node.left != null) {
                    st.push(new Pair1(it.node.left, 1));
                }
            }

            // this is a part of in
            // increment 2 to 3
            // push right
            else if (it.num == 2) {
                in.add(it.node.data);
                it.num++;
                st.push(it);

                if (it.node.right != null) {
                    st.push(new Pair1(it.node.right, 1));
                }
            }
            // don't push it back again
            else {
                post.add(it.node.data);
            }
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        allOrder(root, pre, in, post);

        System.out.println("Pre Order: " + pre);
        System.out.println("In order: " + in);
        System.out.println("Post Order: " + post);
    }
}

class Pair1 {
    TreeNode node;
    int num;

    public Pair1(TreeNode _node, int _num) {
        num = _num;
        node = _node;
    }
}