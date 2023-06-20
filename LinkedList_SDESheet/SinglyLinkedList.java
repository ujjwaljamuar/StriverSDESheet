package LinkedList_SDESheet;

class NodeSLL{
    int val;
    NodeSLL next;

    NodeSLL(int x){
        val = x;
        next = null;
    }
}

public class SinglyLinkedList {
    NodeSLL head = null;
    NodeSLL tail = null;

    static void printLL(NodeSLL head){
        NodeSLL curr = head;
        while(curr != null){
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    void insertAtLast(int value){
        NodeSLL newNode = new NodeSLL(value);

        if(head == null){
            head = newNode;
            tail = newNode;
        }
        tail.next = newNode;
        tail = newNode;

    }

    void insertAtFirst(int value){
        // first create a node
        NodeSLL newNode = new NodeSLL(value);

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
