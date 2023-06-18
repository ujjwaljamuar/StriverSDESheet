package Trees;

import java.util.ArrayList;

public class InOrderTraversal {

    static void inOrderTrav(Node curr, ArrayList<Integer> inOrder) {
        if (curr == null)
            return;

        inOrderTrav(curr.left, inOrder);
        inOrder.add(curr.data);
        inOrderTrav(curr.right, inOrder);
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

        ArrayList<Integer> inOrder = new ArrayList<>();

        inOrderTrav(root, inOrder);

        System.out.println(inOrder);
    }
}
