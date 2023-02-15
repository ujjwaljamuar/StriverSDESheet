package LinkedList_SDESheet;

public class Q4_DeleteNthFromEnd {
    public Node removeNthFromEnd(Node head, int n) {
        
        Node fast = head,slow = head;
        for(int i = 0;i<n;i++){
            fast = fast.next;
        }
        if(fast == null){
            return head.next;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}

