package LinkedList_SDESheet;

public class Q1_ReverseLinkedList {
    public Node reverseList(Node head) {
        Node newHead = null;
        while (head != null) {
            Node next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}

class Node {
    int val;
    Node next;
    Node(int num) {
        val = num;
        next = null;
    }
}
