package Trees_BST;

public class Q10_BSTfromPreOrder {
    static TreeNode bstFromPreOrd(int[] arr){
        return buildFromPreOrder(arr, Integer.MAX_VALUE, new int[]{0});
    }

    static TreeNode buildFromPreOrder(int[] arr, int upperBound, int[] i){
        if(i[0] == arr.length || arr[i[0]] > upperBound){
            return null;
        }

        TreeNode root = new TreeNode(arr[i[0]++]);

        root.left = buildFromPreOrder(arr, root.data, i);
        root.right = buildFromPreOrder(arr, upperBound, i);
        
        return root;
    }
}
