
public class TestBubbleSort {
	
	
	public static void main(String[] args) {
		
		
	int [] A = new int []{2,1,3,4,5,7};
	
	TestBubbleSort.BubbleSort(6,A);
	
	int [] B = TestBubbleSort.BubbleSort(6,A);
	
	for(int i=0 ; i<B.length;i++)
	{
	System.out.print(B[i]+" ");	
	}
	
	
	}
	
	
	public static int [] BubbleSort(int n, int[] A)
	{
		System.out.println("Inside the bubblesort");
		int temp = 0;
		boolean flag = false;
		for(int k=1;k<n-1;k++)
		{
			//System.out.println("the values are K "+k+" n "+n);
			for(int i=0;i<n-k-1;i++)
			{
				//System.out.println("the values are i "+i+" n "+n);
			  if(A[i] > A[i+1])
			  {
				  temp = A[i];
				  A[i] = A[i+1];
				  A[i+1] = temp;
				  flag = true;
			  }
			}
		    if(flag == false)
		    	break;
		}
		return A;
		
	}	
		
		
		
	
	

}
