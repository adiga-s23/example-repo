import java.security.NoSuchAlgorithmException;
import java.util.NoSuchElementException;

public class CircularLinkedList {

	
	private ListNode last;
	private int length;
	
	private static class ListNode
	{
		
		private ListNode next;
		private int data;
		
		public ListNode(int data)
		{
			this.data = data;
			
		}
	}
	
	public CircularLinkedList()
	{
		this.last = null;
		this.length = 0;
	}
	
	public boolean isEmpty()
	{
		
		return length == 0;
	}
	
	public int length()
	{
		return length;
	}
	
	
	public void createCircularList()
	{
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(5);
		ListNode third = new ListNode(10);
		ListNode fourth = new ListNode(15);
		
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = first;
		last = fourth;
		
	}
	
	public void display()
	{
		if(last == null)
			return;
		ListNode first = last.next;
		while(first != last)
		{
			System.out.print(first.data +" -->");
			first = first.next;
		}
		System.out.print(first.data+" ");
	}
	
	
	public void insertFirst(int data)
	{
		ListNode temp = new ListNode(data);
		if(last == null)
			last = temp;
		else
		{
			temp.next = last.next;
		}
		last.next = temp;
		length++;
	}
		
	public void insertLast(int data)
	{
		ListNode temp = new ListNode(data);
		
		if(last==null)
		{
			last = temp;
			last.next = last;
		}
		else
		{
			temp.next = last.next;
			last.next = temp;
			last = temp;
		}
		length++;
		
	}
	
	public ListNode removeFirst()
	{
		if(isEmpty())
			throw new NoSuchElementException();
		
		ListNode temp = last.next;
		if(last == last.next)
		{
			last = null;
		}
		else
		{
			last.next = temp.next;
		}	
			temp.next = null;
			length--;
		    return temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		CircularLinkedList ct = new CircularLinkedList();
		ct.insertFirst(12);
		ct.insertFirst(10);
		ct.insertFirst(5);
		//ct.createCircularList();
		//ct.display();
		
		ct.insertLast(9);
		ct.insertLast(11);
		ct.display();
		
		ListNode tempt = ct.removeFirst();
		System.out.print(tempt.data);
	}

}
