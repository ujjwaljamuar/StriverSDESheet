package Trees_BST;

class NodeVal {
    int minNode;
    int maxNode;
    int maxSize;

    public NodeVal(int _minNode, int _maxNode, int _maxSize) {
        this.maxNode = _maxNode;
        this.minNode = _minNode;
        this.maxSize = _maxSize;
    }
}

public record Q16_LargestBSTsubTree() {

    NodeVal largestBstSubTreeHelper(TreeNode root) {
        // An empty tree is a BST of size 0.
        if (root == null) {
            return new NodeVal(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        // Get values from left and right subtree of current tree.
        NodeVal left = largestBstSubTreeHelper(root.left);
        NodeVal right = largestBstSubTreeHelper(root.right);

        // Current node is greater than max in left AND smaller than min in right, it is
        // a BST.
        if (left.maxNode < root.data && root.data < right.minNode) {
            // It is a BST.
            return new NodeVal(Math.min(root.data, left.minNode), Math.max(root.data, right.maxNode),
                    left.maxSize + right.maxSize + 1);
        }

        // Otherwise, return [-inf, inf] so that parent can't be valid BST
        return new NodeVal(Integer.MIN_VALUE, Integer.MAX_VALUE,
                Math.max(left.maxSize, right.maxSize));
    }

    int largestBstSubTree(TreeNode root) {
        return largestBstSubTreeHelper(root).maxSize;
    }
}
