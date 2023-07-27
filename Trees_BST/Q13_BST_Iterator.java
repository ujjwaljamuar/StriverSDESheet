package Trees_BST;

import java.util.Stack;

public class Q13_BST_Iterator {
    Stack<TreeNode> st = new Stack<>();

    void bstIterator(TreeNode root){
        pushAll(root);
    }

    boolean hasNext(){
        return !st.isEmpty();
    }

    int next(){
        TreeNode temp = st.pop();
        pushAll(temp.right);
        return temp.data;
    }

    void pushAll(TreeNode root){
        for(; root != null; st.push(root), root= root.left);
    }
}
