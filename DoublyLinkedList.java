import java.util.NoSuchElementException;

public class DoublyLinkedList {
	
	
	private ListNode head;
	private ListNode tail;
	private int length;
	
	public static class ListNode
	{
		private int data;
		private ListNode previous;
		private ListNode next;
		
		
		public ListNode(int data)
		{
			this.data = data;
			
		}
		
		
		
	}
	
	public DoublyLinkedList()
	{
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	
	
	public boolean isEmpty()
	{
		return length == 0; // head is null
	}
	
	public int length()
	{
		return length;
	}	
	
	public void displayForward()
	{
		if(head == null)
			return;
		
		ListNode temp = head;
		while(temp != null)
		{
			System.out.print(temp.data +" -->");
			temp = temp.next;
		}
		System.out.println("null");
		
	}
		
	public void displayBackward()
	{
		if(tail == null)
			return;
		
		ListNode temp = tail;
		while(temp != null)
		{
			System.out.print(temp.data +" -->");
			temp = temp.previous;
		}
		System.out.println("null");
		
		
	}
	
	public void insertFirst(int data)
	{
		ListNode newNode = new ListNode(data);
		if(isEmpty())
		{
			tail = newNode;
		}
		else
		{
			head.previous = newNode;
		}
		newNode.next = head;
		head=newNode;
		length++;
	}

	
	public void insertLast(int data)
	{
		ListNode newNode = new ListNode(data);
		if(isEmpty())
			head = newNode;
		else
		{
			tail.next=newNode;
			newNode.previous = tail;
		}
		tail = newNode;
		length++;
	}
	
	public ListNode deleetFirst()
	{
		if(isEmpty())
			throw new NoSuchElementException();
		ListNode temp = head;
		if(head == tail)
			tail =null;
		else
		{
			head.next.previous = null;
		}
		head=head.next;
		temp.next=null;
		length--;
		return temp;
	}
	
	
	public ListNode deleteLast()
	{
		if(isEmpty())
			throw new NoSuchElementException();
		ListNode temp = tail;
		if(head == tail)
			head = null;
		else
			tail.previous.next = null;
		tail = tail.previous;
		temp.previous = null;
		length --;
		return temp;
	}
	public static void main(String[] args) {
	
		DoublyLinkedList db = new DoublyLinkedList();
		//db.insertFirst(10);
		//db.insertFirst(13);
		//db.insertFirst(15);
		//db.insertFirst(8);
		
		//db.displayForward();
		//db.displayBackward();

		
		db.insertLast(20);
		db.insertLast(15);
		db.insertLast(30);
		
		//db.displayBackward();
		db.displayForward();
		
		//ListNode temp = db.deleetFirst();
		//System.out.println("the deleted node is "+temp.data);
		
		ListNode tempd = db.deleteLast();
		System.out.println("the deleted node is "+tempd.data);
		
	}

}
