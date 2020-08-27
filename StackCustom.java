
public class StackCustom {
	
	int size;
	int arr[];
	int top;
	
	public StackCustom(int size)
	{
		this.size = size;
		this.arr = new int[size];
		this.top = -1;
	}
	
	public boolean isFull()
	{
		return size-1 == top;
	}
	
	public boolean isEmpty()
	{
		return top == -1;
	}
	
	public void push(int pushElement)
	{
		if(!isFull())
		{
			top++;
			arr[top] = pushElement;
			System.out.println("Pushed element:" + pushElement);
		}
		else
		{
			System.out.println("stack is full");
		}
	}
	
	public int pop()
	{
		if(!isEmpty())
		{
			int returnedtop = top;
			top--;
			System.out.println("Popped element :" + arr[returnedtop]);
			return arr[returnedtop];
		}
		else
		{
			System.out.println("stack is empty");
			return -1;
		}
	}
	
	public int peek()
	{
		if(!isEmpty())
		{
			return arr[top];
		}
		else
		{
			System.out.println("stack is empty");
			return -1;
		}
	}
	
	public static void main(String[] args) {
		StackCustom StackCustom = new StackCustom(10);
		StackCustom.pop();
		System.out.println("=================");
		StackCustom.push(10);
		StackCustom.push(30);
		StackCustom.push(50);
		StackCustom.push(40);
		System.out.println("=================");
		StackCustom.pop();
		StackCustom.pop();
		StackCustom.pop();
		System.out.println("=================");
	}

}
