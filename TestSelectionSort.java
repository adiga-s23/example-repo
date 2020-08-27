
public class TestSelectionSort {

	public static void main(String[] args) {


	int A[] = new int[]{2,7,4,1,5,3};
	
	int B[] = TestSelectionSort.selectionSort(6,A);
	
	for(int i = 0 ; i<B.length;i++)
	{
		System.out.print(B[i]+" ");
	}

	}
	
	
	public static int[] selectionSort(int n, int[] A)
	{
		int temp = 0;
		
		for(int i = 0;i<n-1;i++)
		{
			int iMin = i;
			
			for(int j=i+1;j<n;j++)
			{
				
				if(A[j] < A[iMin])
					iMin = j;
			}
			temp = A[i];
			A[i] = A[iMin];
			A[iMin] = temp;
			
		}	
			
		return A;	
			
		}
		
		
}

