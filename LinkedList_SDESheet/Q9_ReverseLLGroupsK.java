package LinkedList_SDESheet;

public class Q9_ReverseLLGroupsK {
    static Node reverseKGroups(Node head, int k){
        if(head == null || k == 1) return head;

        Node dummy = new Node(0);
        dummy.next = head;

        Node curr = dummy, nex = dummy, pre = dummy;

        int count = 0;
        while(curr != null){
            curr = curr.next;
            count++;
        }

        while(count >= k){
            curr = pre.next;
            nex = curr.next;

            for(int i = 1;i<k;i++){
                curr.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = curr.next;
            }
            pre = curr;
            count -= k;
        }
        return dummy.next;
    }

}
