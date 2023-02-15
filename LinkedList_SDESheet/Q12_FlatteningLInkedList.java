package LinkedList_SDESheet;

public class Q12_FlatteningLInkedList {
    ListNode merge(ListNode a, ListNode b){
        ListNode temp = new ListNode(0);
        ListNode res = temp;
        
        while(a != null && b!= null){
            if(a.data < b.data){
                temp.bottom = a;
                temp = temp.bottom;
                a = a.bottom;
            }else{
                temp.bottom = b;
                temp = temp.bottom;
                b = b.bottom;
            }
        }
        
        if(a != null)
            temp.bottom = a;
        else
            temp.bottom = b;
            
        return res.bottom;
    }
    
    ListNode flatten(ListNode root)
    {
	// Your code here
	    if(root == null || root.next == null){
	        return root;
	    }
	    
	    root.next = flatten(root.next);
	    
	    root = merge(root,root.next);
	    
	    return root;
	
    }
}

class ListNode
{
	int data;
	ListNode next;
	ListNode bottom;
	
	ListNode(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}