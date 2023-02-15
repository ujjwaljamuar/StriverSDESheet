package LinkedList_SDESheet;

import java.util.*;

public class Q8_DetectCycle {

    // two pointer : TC O(n)
    static boolean cycleDetect1(Node head) {
        if(head == null) return false;
        Node fast = head;
        Node slow = head;
            
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
    
    // Hashing : Time Complexity: O(N)
    static boolean cycleDetect(Node head) {
        HashSet <Node> hashTable=new HashSet<>();
        while(head != null) {
            if(hashTable.contains(head)) return true;
            hashTable.add(head);
            head = head.next;
        }
        return false;
    }

    static void createCycle(Node head,int a,int b) {
        int cnta = 0,cntb = 0;
        Node p1 = head;
        Node p2 = head;
        while(cnta != a || cntb != b) {
            if(cnta != a) 
            {p1 = p1.next; ++cnta;}
            if(cntb != b) 
            {p2 = p2.next; ++cntb;}
        }
        p2.next = p1;
    }


    public static void main(String[] args) {
        
    }
}
