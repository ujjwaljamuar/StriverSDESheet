package LinkedList_SDESheet;

import java.util.HashSet;

public class Q7_IntersectionYLL {
    // 1 : optimal 2 best // Time Complexity: O(2*max(length of list1,length of
    // list2))

    static Node intersecY(Node headA, Node headB) {
        if (headA == null || headB == null) {
            return null;
        }

        Node a = headA;
        Node b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;

    }

    // 2 : optimal 1 : lengthy : Time Complexity:

    // O(2max(length of list1,length of list2))+O(abs(length of list1-length of
    // list2))+O(min(length of list1,length of list2))

    static int getDifference(Node head1, Node head2) {
        int len1 = 0, len2 = 0;
        while (head1 != null || head2 != null) {
            if (head1 != null) {
                ++len1;
                head1 = head1.next;
            }
            if (head2 != null) {
                ++len2;
                head2 = head2.next;
            }

        }
        return len1 - len2;// if difference is neg-> length of list2 > length of list1 else vice-versa
    }

    static Node intersectionPresent1(Node head1, Node head2) {
        int diff = getDifference(head1, head2);
        if (diff < 0)
            while (diff++ != 0)
                head2 = head2.next;
        else
            while (diff-- != 0)
                head1 = head1.next;
        while (head1 != null) {
            if (head1 == head2)
                return head1;
            head2 = head2.next;
            head1 = head1.next;
        }
        return head1;

    }

    // 3 hashing : Time Complexity: O(n+m)

    static Node intersectionPresent(Node head1, Node head2) {
        HashSet<Node> st = new HashSet<>();
        while (head1 != null) {
            st.add(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            if (st.contains(head2))
                return head2;
            head2 = head2.next;
        }
        return null;

    }

    // brute : TC : Time Complexity: O(m*n)

    static Node intersectionPresent0(Node head1, Node head2) {
        while (head2 != null) {
            Node temp = head1;
            while (temp != null) {
                // if both nodes are same
                if (temp == head2)
                    return head2;
                temp = temp.next;
            }
            head2 = head2.next;
        }
        // intersection is not present between the lists return null
        return null;
    }

    static Node insertNode(Node head, int val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            return head;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
        return head;
    }

    static void printList(Node head) {
        while (head.next != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println(head.val);
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertNode(head, 1);
        head = insertNode(head, 3);
        head = insertNode(head, 1);
        head = insertNode(head, 2);
        head = insertNode(head, 4);
        Node head1 = head;
        head = head.next.next.next;
        Node headSec = null;
        headSec = insertNode(headSec, 3);
        Node head2 = headSec;
        headSec.next = head;
        // printing of the lists
        System.out.print("List1: ");
        printList(head1);
        System.out.print("List2: ");
        printList(head2);
        // checking if intersection is present
        Node answerNode = intersectionPresent(head1, head2);
        if (answerNode == null)
            System.out.println("No intersection\n");
        else
            System.out.println("The intersection point is " + answerNode.val);
    }
}

