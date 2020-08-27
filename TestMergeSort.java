
public class TestMergeSort {
	
	
	
	private static void printArray(int[] array)
	{
		for (int i:array)
			System.out.print(i+" ");
		
	}
	
	private static int[] mergeSort(int[] array)
	{
		
		if(array.length <= 1)
			return array;
		
		int midPoint = array.length /2;
		
		int[] left = new int[midPoint];
		
		int [] right = new int[array.length - midPoint];
		
		for(int i = 0 ; i < midPoint;i++)
			left[i] = array[i];
		for(int j = 0; j <right.length;j++)
			right[j] = array[midPoint +j];
		
		int[] result = new int[array.length];
		
		left = mergeSort(left);
		right = mergeSort(right);
		
		result = merge(left,right);
		
		return result;
	}
	
	
	
	private static int[] merge(int[] left,int[] right)
	{
		
		int [] result = new int[left.length+right.length];
		
		int leftPointer,rightPointer,resultPointer;
		leftPointer = rightPointer = resultPointer = 0;
		
		while(leftPointer < left.length || rightPointer < right.length)
		{
			if(leftPointer < left.length && rightPointer < right.length)
			{
				if(left[leftPointer] < right[rightPointer])
				{
					
					result[resultPointer] = left[leftPointer];
					resultPointer++;
					leftPointer++;
					
				} else {
					
					result[resultPointer] = right[rightPointer];
					resultPointer++;
					rightPointer++;
					
				}
			} else if(leftPointer < left.length) {
				
				result[resultPointer] = left[leftPointer];
				resultPointer++;
				leftPointer++;
				
				
			}
			else if(rightPointer < right.length)
			{
				result[resultPointer] = right[rightPointer];
				resultPointer++;
				rightPointer++;
				
			}
			
			
		}
		
		return result;
		
		
		
	}
	
	public static void main(String[] args) {
		
		int[] array = { 5,4,3,2,1,0,7,8 };
		
		System.out.println("Initial Array");
		printArray(array);
		
		int[] result = mergeSort(array);
		
		System.out.println("final array after sort");
		
		printArray(result);
		
		
		
		
	}

}
