package Trees_BST;

public class Q12_InOrderSuccessor {
    static void findInOrderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;

        while (root.data != p.data) {

            if (p.data >= root.data) {
                root = root.right;
            } else {
                successor = root;

                root = root.left;
            }

        }

        TreeNode rightSubtree = root.right;

        while (rightSubtree != null) {
            successor = rightSubtree;
            rightSubtree = rightSubtree.left;
        }

        System.out.println(successor.data);

    }

    static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        TreeNode curr = root;

        while (true) {

            // if current value is less than val assign to right
            if (curr.data <= val) {

                // if there is a right then move to right
                // else create a right and assign val
                if (curr.right != null) {
                    curr = curr.right;
                } else {
                    curr.right = new TreeNode(val);
                    break;
                }
            }

            // if current value is greater than val assign to left
            else {
                if (curr.left != null) {
                    curr = curr.left;
                } else {
                    curr.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {

        TreeNode root = null;

        int[] arr = { 5, 2, 4, 3, 1, 8, 9, 10, 7, 6 };

        for (int a : arr) {
            root = insertIntoBST(root, a);
        }

        findInOrderSuccessor(root, root.left.right.left);

    }
}
