package Medium;

public class AddTwoNumbers2 {

	public static void main(String[] args) {
		ListNode l1 = null;		
		ListNode l2 = null;
		System.out.println(addTwoNumbers(l1, l2));

	}
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    	ListNode head = new ListNode(0);
	    	ListNode current = head;
	    	
	    	int sum=0;
	    	boolean extend = false;
	    	
	    	while(l1!=null||l2!=null){
	    		if(l1==null){
	    			sum=l2.val;
	    			l2 = l2.next;
	    		}
	    		else if(l2==null){
	    			sum=l1.val;
	    			l1 = l1.next;
	    		}
	    		
	    		else{
	    			sum=l1.val+l2.val;
	    			l1=l1.next;
	    			l2=l2.next;
	    		}
	    		
	    		if(extend){
	    			sum++;
	    		}
	    		
	    		if(sum>=10){
	    			sum = sum-10;
	    			extend = true;
	    		}
	    		else
	    			extend = false;
	    		current.next=new ListNode(sum);
	    		current = current.next;
	    	}
	    	
	    	if(extend){
	    		current.next=new ListNode(1);
	    	}
	    	
			return head.next;	    
	}
}
