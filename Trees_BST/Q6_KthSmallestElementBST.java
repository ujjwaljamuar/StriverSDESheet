package Trees_BST;

public class Q6_KthSmallestElementBST {

    static int counter = 0, node = 0;

    static int kthSmallest(TreeNode root, int k) {
        counter = k;
        inOrder(root);
        return node;
    }

    static void inOrder(TreeNode root) {
        if (root.left != null) {
            inOrder(root.left);
        }

        counter--;
        if (counter == 0) {
            node = root.data;
            return;
        }

        if (root.right != null) {
            inOrder(root.right);
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
        int arr[] = { 10, 40, 45, 20, 25, 30, 50 };
        int arrSize = arr.length;

        TreeNode root = null;

        for (int i = 0; i < arrSize; i++) {
            root = createBST(root, arr[i]);
        }

        int k = 3;

        int kthSmallestEle = kthSmallest(root, k);
        System.out.println("Kth Smallest element is " + kthSmallestEle);
    }
}
