package LinkedList_SDESheet;

public class Q13_RotateALinkedList {
    static Node rotate(Node head, int k){
        if(head == null || head.next == null || k < 1) return head;

        int len = 1;
        Node cur = head;

        while(cur.next != null){
            len += 1;
            cur = cur.next;
        }

        cur.next = head;
        k = k%len;
        k = len - k;

        while(k-- > 0) cur = cur.next;

        head = cur.next;
        cur.next = null;

        return head;
    }
}
