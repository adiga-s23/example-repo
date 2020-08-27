
public class TestStack {

	public static void main(String[] args) {
		
		
		ArrayStack ar = new ArrayStack(20);
		
		ar.push(10);
		ar.push(20);
		ar.push(30);
		System.out.println(ar.peek());
	}

	
	private static class ArrayStack
	{
		
		private int[] stack;
		private int top;
		
		
		public ArrayStack(int capacity)
		{
			this.stack = new int[capacity];
			
		}
		
		public void push(int newElement)
		{
			if(top == stack.length){
				System.out.println("stack is full");
			   int[] newArray = new int[2*stack.length];
			   System.arraycopy(stack, 0, newArray, 0, stack.length);
			   stack = newArray;
			}
			stack[top++] = newElement;
		}
		
		public int pop()
		{
			int popelement = 0;
			if(top == 0)
			{	System.out.println("stack is empty");
				return -1; }
			else
			{
				popelement = stack[top];
				top--;
			}	
			return 	popelement;
		}
		
		public int peek()
		{
			if(top == 0)
				return -1;
			return stack[top-1];
			
		
		}
		
		
	}
}
