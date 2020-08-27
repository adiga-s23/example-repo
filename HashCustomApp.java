class HashCustomMap<K,V>
{
	private Entry<K,V>[] table;
	private int capacity = 4;
	
	static class Entry<K,V>
	{
		K key;
		V value;
		Entry<K,V> next;
		
		public Entry(K key,V value,Entry<K,V> next)
		{
			
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	@SuppressWarnings("unchecked")
	public HashCustomMap()
	{
		table = new Entry[capacity];
	}
	
	public int hash(K newkey)
	{
		return Math.abs(newkey.hashCode()) % capacity;
	}
	
	public void put(K newKey, V data){
	       if(newKey==null)
	           return;    //does not allow to store null.
	      
	       //calculate hash of key.
	       int hash=hash(newKey);
	       //create new entry.
	       Entry<K,V> newEntry = new Entry<K,V>(newKey, data, null);
	      
	       //if table location does not contain any entry, store entry there.
	        if(table[hash] == null){
	         table[hash] = newEntry;
	        }else{
	           Entry<K,V> previous = null;
	           Entry<K,V> current = table[hash];
	           
	           while(current != null){ //we have reached last entry of bucket.
	           if(current.key.equals(newKey)){           
	               if(previous==null){  //node has to be insert on first of bucket.
	                     newEntry.next=current.next;
	                     table[hash]=newEntry;
	                     return;
	               }
	               else{
	                   newEntry.next=current.next;
	                   previous.next=newEntry;
	                   return;
	               }
	           }
	           previous=current;
	             current = current.next;
	         }
	         previous.next = newEntry;
	        }
	    }
	
	public V get(K Key)
	{
		int hash = hash(Key);
		if(table[hash] == null)
		{
			return null;
		}
		else
		{
			Entry<K,V> temp = table[hash];
			while(temp!=null)
			{
				if(temp.key.equals(Key))
				{
					return temp.value;
				}
				temp = temp.next;
			}
		}
		return null;
	}
	
	public boolean remove(K deleteKey)
	{
		
		int hash = hash(deleteKey);
		if(table[hash] == null)
			return false;
		else
		{
			Entry<K,V> current = table[hash];
			Entry<K,V> previous = null;
			while(current != null)
			{
				if(current.key.equals(deleteKey)){
					if(previous == null)
					{
						table[hash] = table[hash].next;
						return true;
					}
					else
					{
						previous.next = current.next;
						return true;
					}
					
				}
				previous = current;
				current = current.next;
			}
			return false;
		}
	}
	
	public void display()
	{
		for(int i=0;i<capacity;i++)
		{
			if(table[i] != null)
			{
			Entry<K,V> entry = table[i];
			while(entry != null)
			{
			System.out.println("{"+entry.key+"="+entry.value+"}" +" ");
			entry = entry.next;
			}
		}
	}
	}
	
}

public class HashCustomApp{
    
    public static void main(String[] args) {
           HashCustomMap<Integer, Integer> hashMapCustom = new HashCustomMap<Integer, Integer>();
           hashMapCustom.put(21, 12);
           hashMapCustom.put(25, 121);
           hashMapCustom.put(30, 151);
           hashMapCustom.put(33, 15);
           hashMapCustom.put(35, 89);
 
           System.out.println("value corresponding to key 21="
                        + hashMapCustom.get(21));
           System.out.println("value corresponding to key 51="
                        + hashMapCustom.get(51));
 
           System.out.print("Displaying : ");
           hashMapCustom.display();
 
           System.out.println("\n\nvalue corresponding to key 21 removed: "
                        + hashMapCustom.remove(21));
           System.out.println("value corresponding to key 51 removed: "
                        + hashMapCustom.remove(51));
 
           System.out.print("Displaying : ");
           hashMapCustom.display();
 
    }
}
	

		






