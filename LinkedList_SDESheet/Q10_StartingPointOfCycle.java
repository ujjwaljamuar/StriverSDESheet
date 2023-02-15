package LinkedList_SDESheet;

public class Q10_StartingPointOfCycle {
    static Node detectStartOfLoop(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node slow = head, fast = head, entry = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                while (slow != entry) {
                    slow = slow.next;
                    entry = entry.next;
                }

                return entry;
            }
        }
        
        return null;
    }
}
