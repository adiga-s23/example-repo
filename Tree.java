
public class Tree {
	
	private TreeNode root;
	
	
	
	public void insert(int value)
	{
		if(root == null)
			root = new TreeNode(value);
		else
		{
			root.insert(value);
		}
	}
	
	
	public void traverseInOrder()
	{
		if(root != null)
			root.traverseInOrder();
	}
	
	public void traversePreOrder()
	{
		if(root != null)
			root.traversePreOrder();
	}
	
	public void traversePostOrder()
	{
		if(root != null)
			root.traversePostOrder();
	}
	
	public TreeNode get(int value)
	{
		if(root != null)
			return root.get(value);
		
		return null;
	}
	
	
	public int min()
	{
		if(root == null)
			return Integer.MIN_VALUE;
		else
			return root.min();
	}
	
	public int max()
	{
		if(root == null)
			return Integer.MAX_VALUE;
		else
			return root.max();
	}
	
	public void delete(int value)
	{
		root = delete(root,value);
	}
	
	private TreeNode delete(TreeNode node,int value)
	{
		if(node == null)
			return node;
		if(value < node.getData())
			node.setLeft(delete(node.getLeft(),value));
		else if(value > node.getData())
			   node.setRight(delete(node.getRight(),value));
	    else {
	    	// 0 or 1 child
	    	if(node.getLeft() == null)
	    		return node.getRight();
	    	else if(node.getRight() == null)
	    		return node.getLeft();
	    	
	    	
	    	//case 3
	    	//replace the value of subtree root node with smallest of right sub tree
	    	node.setData(node.getRight().min());
	    	//delete the node that has the smallest value in the right subtree.
	    	node.setRight(delete(node.getRight(),node.getData()));
	    }
		return node;
	}
}
