package LinkedList_SDESheet;

class Node{
    int val;
    Node next;

    Node(int x){
        val = x;
        next = null;
    }
}

public class SinglyLinkedList {
    Node head = null;
    Node tail = null;

    static void printLL(Node head){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    void insertAtLast(int value){
        Node newNode = new Node(value);

        if(head == null){
            head = newNode;
            tail = newNode;
        }
        tail.next = newNode;
        tail = newNode;

    }

    void insertAtFirst(int value){
        // first create a node
        Node newNode = new Node(value);

        // point next of new node to head of created LL
        newNode.next = head;

        // make the newnode as the new head of the LL
        head = newNode;

        
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        
        sll.insertAtLast(0);

    }
}
