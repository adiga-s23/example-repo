
public class TestInsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int A[] = new int[]{7,8,3,2,1,5,4,3};
		
		int B[] = TestInsertionSort.insertSort(8,A);
		
		for(int i = 0;i<B.length;i++)
		System.out.print(B[i]+" ");
	}
	
	public static int [] insertSort(int n, int [] A)
	{
		for(int i = 1;i<n;i++)
		{
			int value = A[i];
			int hole = i;
			
			while(hole > 0 && A[hole-1]>value)
			{
				
				A[hole] = A[hole-1];
				hole = hole-1;
			}
			
			A[hole] = value;
		}
		
		return A;
		
	}

}
