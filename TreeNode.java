
public class TreeNode {
	
	private int data;
	private TreeNode left;
	private TreeNode right;
	
	
	public TreeNode(int data)
	{
		this.data = data;
	}
	
	
	public void insert(int value)
	{
		if(value == data)
			return;
		if(value < data)
		{
			if(left == null)
				left = new TreeNode(value);
			else
				left.insert(value); // call on left 
		}
		else
		{
			if(right == null)
				right = new TreeNode(value);
			else
				right.insert(value); // call on right
			
		}	
	}
		
	public void traverseInOrder()	
	{
		if(left != null)
			left.traverseInOrder();
		System.out.print(data + ",");
		
		if(right != null)
			right.traverseInOrder();	
	}
	
	public void traversePreOrder()
	{
		System.out.print(data + ",");
		if(left != null)
			left.traversePreOrder();
		if(right != null)
			right.traversePreOrder();
	
	}
		
	public void traversePostOrder()
	{
		if(left != null)
			left.traversePostOrder();
		if(right != null)
			right.traversePostOrder();
		System.out.print(data + ",");
	
	}
	
	public TreeNode get(int value)
	{
		if(value == data)
			return this;
		
		if(value < data)
		{
			if(left != null)
				return left.get(value);
		}
		else
		{
			if(right != null)
				return right.get(value);
		}
		
		return null;
	}
		
	public int min()
	{
		if(left == null)
			return data;
		else
			return left.min();
	}
	
	public int max()
	{
		if(right == null)
			return data;
		else
			return right.max();
	}
		
		
	
	
	
	@Override
	public String toString() {
		return "TreeNode [data=" + data + "]";
	}


	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}

}
