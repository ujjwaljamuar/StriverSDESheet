package Trees_BST;

public class Q11_InOrderSuccessor {
    static TreeNode findInOrderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        TreeNode predecessor = null;

        while (root != null) {
            if (p.data >= root.data) {
                predecessor = root;
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }

        // System.out.println(predecessor.data + " " + successor.data);

        return successor;
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

    public static void inorderTraversal(TreeNode root) {

        // Check whether tree is empty
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        } else {

            if (root.left != null)
                inorderTraversal(root.left);
            System.out.print(root.data + " ");
            if (root.right != null)
                inorderTraversal(root.right);

        }

        
    }

    public static void main(String[] args) {
        TreeNode root = null;

        int[] arr = { 5,2,4,3,1,8,9,10,7,6 };

        for (int a : arr) {
            root = insertIntoBST(root, a);
        }

        inorderTraversal(root);

        System.out.println();
        findInOrderSuccessor(root, root);

    }
}
