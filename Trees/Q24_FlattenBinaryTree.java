package Trees;

import java.util.Stack;

// use reverse post order(right left root)
public class Q24_FlattenBinaryTree {

    static TreeNode prev = null;

    // using morris traversal - O(N), O(1)
    static void flattenMorris(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                prev = curr.left;

                while (prev.right != null) {
                    prev = prev.right;
                }

                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    // using stack - 2nd approach - O(N), O(N)
    // push right then left, then connect right to top
    static void flattenStack(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> st = new Stack<>();

        st.push(root);

        while (!st.isEmpty()) {
            TreeNode curr = st.peek();
            st.pop();

            if (curr.right != null) {
                st.push(curr.right);
            }
            if (curr.left != null) {
                st.push(curr.left);
            }

            if (!st.isEmpty()) {
                curr.right = st.peek();
            }

            curr.left = null;

        }

    }

    // using recursion - first approach - O(N), O(N)
    static void flattenRecursion(TreeNode root) {
        if (root == null)
            return;
        flattenRecursion(root.right);
        flattenRecursion(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(7);
        // flattenRecursion(root);
        // flattenStack(root);
        flattenMorris(root);
        while (root.right != null) {
            System.out.print(root.data + " -> ");
            root = root.right;
        }
        System.out.print(root.data);
    }
}

// Morris Traversal
// At a node(say cur) if there exists a left child, we will find the rightmost
// node in the left subtree(say prev).
// We will set prev’s right child to cur’s right child,
// We will then set cur’s right child to it’s left child.
// We will then move cur to the next node by assigning cur it to its right child
// We will stop the execution when cur points to NULL.