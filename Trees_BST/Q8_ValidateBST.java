package Trees_BST;

public class Q8_ValidateBST {
    static boolean isValidBST(TreeNode root){
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static boolean validate(TreeNode root, long minVal, long maxVal){
        if(root == null) return true;
        if(root.data >= maxVal || root.data <= minVal){
            return false;
        }

        return validate(root.left, minVal, root.data) && validate(root.right, root.data, maxVal);
    }
}
