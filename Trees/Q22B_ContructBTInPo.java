package Trees;

import java.util.HashMap;
import java.util.Map;

public class Q22B_ContructBTInPo {
    static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;

        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = build(inorder, 0,
                inorder.length - 1, postorder, 0, postorder.length - 1, inMap);
        return root;
    }

    static TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd,
            Map<Integer, Integer> inMap) {

        if (postStart > postEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = inMap.get(postorder[postEnd]);
        int numsLeft = inRoot - inStart;

        root.left = build(inorder, inStart, inRoot - 1, postorder,
                postStart, postStart + numsLeft - 1, inMap);
        root.right = build(inorder, inRoot + 1, inEnd, postorder,
                postStart + numsLeft, postEnd - 1, inMap);

        return root;
    }

    public static void main(String[] args) {
        int postorder[] = { 10, 20, 40, 50, 30, 60 };
        int inorder[] = { 40, 20, 50, 10, 60, 30 };
        TreeNode root = buildTree(inorder, postorder);

        System.out.println(root.data);
    }
}
