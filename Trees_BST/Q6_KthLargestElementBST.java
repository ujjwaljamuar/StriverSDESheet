package Trees_BST;

public class Q6_KthLargestElementBST {
    static int counter = 0, node = 0;

    static int kthLargest(TreeNode root, int k) {
        counter = k;
        revInOrder(root);
        return node;
    }

    static void revInOrder(TreeNode root) {
        if (root.right != null) {
            revInOrder(root.right);
        }

        counter--;
        if (counter == 0) {
            node = root.data;
            return;
        }

        if (root.left != null) {
            revInOrder(root.left);
        }
    }

    static TreeNode createBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.data) {
            root.left = createBST(root.left, val);
        } else {
            root.right = createBST(root.right, val);
        }
        return root;
    }

    public static void main(String args[]) {
        int arr[] = { -1, -1, -1, -1, -1, -1, 1, 2, 3, 5, 6 };
        int arrSize = arr.length;

        TreeNode root = null;

        for (int i = 0; i < arrSize; i++) {
            root = createBST(root, arr[i]);
        }

        int k = 2;

        int kthSmallestEle = kthLargest(root, k);
        System.out.println("Kth Largest element is " + kthSmallestEle);
    }
}
