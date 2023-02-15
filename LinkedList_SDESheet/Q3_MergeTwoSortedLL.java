package LinkedList_SDESheet;

public class Q3_MergeTwoSortedLL {
    static Node mergeLL(Node l1, Node l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.val > l2.val) {
            Node temp = l1;
            l1 = l2;
            l2 = temp;
        }

        Node res = l1;

        while (l1 != null && l2 != null) {
            Node tmp = null;

            while (l1 != null && l1.val <= l2.val) {
                tmp = l1;
                l1 = l1.next;
            }

            tmp.next = l2;

            Node temp = l1;
            l1 = l2;
            l2 = temp;
        }

        return res;

    }
}

