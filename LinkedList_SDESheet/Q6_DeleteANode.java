package LinkedList_SDESheet;

public class Q6_DeleteANode {
    static void deleteNode(Node n){
        if(n == null) return;
        n.val = n.next.val;
        n.next = n.next.next;
    }
}

