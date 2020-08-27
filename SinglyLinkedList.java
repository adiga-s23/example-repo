
public class SinglyLinkedList {
	
	private ListNode head;
	//it is a static inner class
	
	private static class ListNode 
	{
		int data;
		ListNode next;
		
		public ListNode(int data)
		{
			this.data = data;
			this.next = null;
		}
		
	}
	
	public void display(ListNode head)
	{
		ListNode current = head;
		while(current != null)
		{
			System.out.print(current.data +"-->");
			current = current.next;
		}
		System.out.println("null");
		
		
	}
	
	public int length()
	{
		ListNode current = head;
		int count = 0;
		while(current!=null)
		{
			count++;
			current = current.next;
			
		}
		System.out.println(count);
		return count;
	}
		
		
	public void insertFirst(int data)
	{
		ListNode newNode = new ListNode(data);
		
		if(head == null)
			head = newNode;
		
		newNode.next = head;
		head = newNode;
		
	}
	
	public void insertLast(int data)
	{
		
		ListNode newNode = new ListNode(data);
		if(head == null)
		{
			head = newNode;
			return;
		}
		
		ListNode current = head;
		
		while(current.next !=null)
			current = current.next;
		
		current.next = newNode;
		
	}	
	
	public boolean search(int key)
	{
		ListNode current = head;
		
		if(head==null)	
			return false;
		
		while(current!=null)
		{
			if(current.data == key)
				return true;
			current=current.next;
		}
		return false;
		
	}
	
	public ListNode reverse()
	{
		ListNode current = head;
		ListNode previous = null;
		ListNode next = null;
		while(current!=null)
		{
			next = current.next;
			current.next=previous;
			previous=current;
			current=next;
		}
		
		return previous;
		
	}	
		
	public ListNode findMiddle()
	{
		
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
			
		}
		
		return slow;
		
	}
	
	public ListNode nodeFromLast(int n)
	{
		ListNode refPtr = head;
		ListNode mainPtr = head;
		int count = 0;
		
		while(count<n)
		{
			refPtr = refPtr.next;
			count++;
		}
		while(refPtr != null)
		{
			refPtr = refPtr.next;
			mainPtr = mainPtr.next;
			
		}
		
		return mainPtr;
	}
	
	public ListNode insertIntoSortList(int data)
	{
		ListNode newNode = new ListNode(data);
		
		ListNode current=head;
		ListNode temp = null;
		
		while(current != null && current.data < newNode.data)
		{
			
			temp = current;
			current=current.next;
			
		}
		newNode.next=current;
		if(temp == null)
		{
			head = newNode;
			return head;
		}
		temp.next=newNode;
		return head;
		
	}
	
		
		
	

	public static void main(String[] args) {
		
		//Lets create a linked list in demo
		SinglyLinkedList sl = new SinglyLinkedList();
		//10-->8-->1-->11-->null
		
		sl.head = new ListNode(8);
		ListNode first = new ListNode(10);
		ListNode second = new ListNode(12);
		ListNode third = new ListNode(14);
		
		
		sl.head.next = first;
		first.next = second;
		second.next = third;
		third.next = null;
		
		sl.insertFirst(6);
		
		sl.display(sl.head);
		sl.length();
		
		//sl.insertFirst(15);
		sl.insertLast(17);
		sl.display(sl.head);
		
		System.out.println(sl.search(19));
		
		
		//ListNode reverseNode = sl.reverse();
		//sl.display(reverseNode);
		
		//ListNode result = sl.findMiddle();
		//System.out.println("the middle node is "+ result.data);
		
		
		
		//ListNode resultN = sl.nodeFromLast(2);
		//System.out.println("the Nth node "+resultN.data);
		
		
		sl.display(sl.head);
		ListNode result = sl.insertIntoSortList(18);
		sl.display(result);
		
		
	}

}
