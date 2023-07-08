package Trees;

public class Q18_IdenticalCheck {
    static boolean checkIdentical(TreeNode p, TreeNode q){
        if(p == null || q == null){
            return p==q;
        }

        return (p.data ==  q.data) && checkIdentical(p.left, q.left) && checkIdentical(p.right, q.right);
    }
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);

        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);

        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        System.out.println(checkIdentical(root1, root2));
    }
}
