package Trees;

import java.util.ArrayList;

public class PreOrderTraversal {

    static void preOrderTrav(Node curr, ArrayList<Integer> preOrder) {
        if (curr == null)
            return;

        preOrder.add(curr.data);
        preOrderTrav(curr.left, preOrder);
        preOrderTrav(curr.right, preOrder);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        ArrayList<Integer> preOrder = new ArrayList<>();

        preOrderTrav(root, preOrder);

        System.out.println(preOrder);
    }
}
