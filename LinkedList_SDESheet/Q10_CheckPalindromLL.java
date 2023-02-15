package LinkedList_SDESheet;

import java.util.*;

public class Q10_CheckPalindromLL {

    // Time Complexity: O(N/2)+O(N/2)+O(N/2)

    static boolean isPalindrome(Node head) {
        if (head == null || head.next == null)
            return true;

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = reverse(slow.next);
        slow = slow.next;
        Node dummy = head;

        while (slow != null) {
            if (dummy.val != slow.val)
                return false;
            dummy = dummy.next;
            slow = slow.next;
        }
        return true;
    }

    static Node reverse(Node ptr) {
        Node pre = null;
        Node nex = null;
        while (ptr != null) {
            nex = ptr.next;
            ptr.next = pre;
            pre = ptr;
            ptr = nex;
        }
        return pre;
    }

    // O(n)
    static boolean isPalindrome0(Node head) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }
        for (int i = 0; i < arr.size() / 2; i++)
            if (arr.get(i) != arr.get(arr.size() - i - 1))
                return false;
        return true;
    }
}
