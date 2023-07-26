package Trees_BST;

public class Q11_InOrderPredecessor {
    static void findInOrderPredecessor(TreeNode root, TreeNode p) {
        TreeNode predecessor = null;

        while (root.data != p.data) {

            if (p.data >= root.data) {
                predecessor = root;
                root = root.right;
            } else {
                root = root.left;
            }

        }

        TreeNode leftSubtree = root.left;

        while (leftSubtree != null) {
            predecessor = leftSubtree;
            leftSubtree = leftSubtree.right;
        }

        System.out.println(predecessor.data);

    }

    static void findInOrderPredSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        TreeNode predecessor = null;

        while (root.data != p.data) {
            if (p.data >= root.data) {
                predecessor = root;
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

        TreeNode leftSubtree = root.left;

        while (leftSubtree != null) {
            predecessor = leftSubtree;
            leftSubtree = leftSubtree.right;
        }

        System.out.println(predecessor.data + " " + successor.data);

    }

    static Pair findInOrderPredSuccessorPair(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        TreeNode predecessor = null;

        while (root.data != p.data) {
            if (p.data >= root.data) {
                predecessor = root;
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

        TreeNode leftSubtree = root.left;

        while (leftSubtree != null) {
            predecessor = leftSubtree;
            leftSubtree = leftSubtree.right;
        }

        // System.out.println(predecessor.data + " " + successor.data);

        Pair pair = new Pair(predecessor.data, successor.data);

        return pair;
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

        findInOrderPredecessor(root, root.left.right.left);

    }
}

class Pair {
    int a;
    int b;

    Pair(int _a, int _b) {
        this.a = _a;
        this.b = _b;
    }
}