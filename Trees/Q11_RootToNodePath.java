package Trees;

import java.util.ArrayList;

public class Q11_RootToNodePath {
    static Boolean getPath(TreeNode root, ArrayList<Integer> arr, int x) {
        if (root == null)
            return false;
        
        arr.add(root.data);

        if(root.data == x)
            return true;

        if(getPath(root.left, arr, x) || getPath(root.right, arr, x)){
            return true;
        } 

        arr.remove(arr.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(3);

        ArrayList < Integer > arr = new ArrayList < > ();

        getPath(root, arr, 7);

        System.out.print("The path is ");
        for (int it: arr) {
            System.out.print(it + " ");
        }
    }
}
