
public class TestBinarySearch {
	
	
	
	
	private static int binarySearch(int[] array,int key)
	{
		int low = 0;
		int high = array.length-1;
		
		while(low<=high)
		{
			int mid = (low+high)/2;
			
			if(array[mid] == key) return mid;
			
			if(key < array[mid])
				high = mid - 1;
			else
				low = mid + 1;
			
		}
		return -1;	
	}
	

	public static void main(String[] args) {
		
		int [] nums = {10,20,47,59,65,75,88,91};
		
		int result = binarySearch(nums,91);
		
		System.out.println("position is"+result);

	}

}
