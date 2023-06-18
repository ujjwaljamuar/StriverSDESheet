package Trees;

class Node {
    int data;
    Node left, right;

    public Node(int key) {
        this.data = key;
        left = null;
        right = null;
    }
}

public class BinaryTree {
    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(4);
        root.right = new Node(5);

        root.left.right = new Node(7);
    }
}
