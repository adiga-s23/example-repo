import java.util.NoSuchElementException;

public class SimpleHashTable {
	
	private StoredEmployee [] hashtable;
	
	
	public SimpleHashTable()
	{
		hashtable = new StoredEmployee[10];
		
	}
	
	public void put(String key,Employee emp)
	{
		
		int index = hashKey(key);
		if(occupied(index))
		{
			int stop = index;
			if(index == hashtable.length -1)
				index = 0;
			else
				index++;
			while(occupied(index) && index != stop)
			{
				index = (index+1)%hashtable.length;
			}
		}
		if(occupied(index))
		{
			System.out.println("Sorry there is already an employee at position"+index);
		}
		else
		{
			hashtable[index] = new StoredEmployee(key, emp);
		}
	}
	
	public Employee get(String key)
	{
		int index = findKey(key);
		if(index == -1)
			return null;
		return hashtable[index].emp;
	}
	
	private int findKey(String key)
	{
		int index = hashKey(key);
		if(hashtable[index]!= null && hashtable[index].key.equals(key))
			return index;
		
			int stop = index;
			if(index == hashtable.length -1)
				index = 0;
			else
				index++;
			while(index != stop && hashtable[index] != null && !hashtable[index].key.equals(key))
			{
				index = (index+1)%hashtable.length;
			}
			if(hashtable[index] != null &&
				hashtable[index].key.equals(key))
				return index;
			else
				return -1;		
	}
	
	
	private int hashKey(String key)
	{
		
		return key.length() % hashtable.length;
	}
	
	private boolean occupied(int index)
	{
		return hashtable[index] != null;
		
	}
	
	public Employee remove(String key)
	{
		
		int index = findKey(key);
		if(index == -1)
			return null;
				
		Employee employee = hashtable[index].emp;
		//hashtable[index] = null;	
		StoredEmployee [] oldHashTable = hashtable;
		hashtable = new StoredEmployee[oldHashTable.length];
		for (int i = 0; i < oldHashTable.length; i++) {
			if(oldHashTable[i] != null)
				put(oldHashTable[i].key,oldHashTable[i].emp);
			
		}
		return employee;
	}
	
	public void printHashTable()
	{
		
		for (int i = 0; i < hashtable.length; i++) {
			if(hashtable[i] == null)
				System.out.println("empty");
			else
			System.out.println("Position "+ i +":"+hashtable[i].emp);
			
		}
		
	}
}
