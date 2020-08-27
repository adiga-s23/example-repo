
public class Main {

	public static void main(String[] args) {
		
		Employee janeJones = new Employee("Jane","Jones",123);
		Employee johnDoe = new Employee("John","Doe",4567);
		Employee marySmith = new Employee("Mary","Smith",22);
		Employee mikeWilson = new Employee("Mike","Wilson",3245);
		Employee billEnd = new Employee("Bill","End",78);
		

		SimpleHashTable ht = new SimpleHashTable();
		ht.put("Jones", janeJones);
		ht.put("Doe", johnDoe);
		ht.put("Smith", marySmith);
		ht.put("Wilson", mikeWilson);
		//ht.put("End", billEnd);
		
		//ht.printHashTable();
		
		System.out.println("Retreving key "+ht.get("Jones"));
		
		ht.remove("Wilson");
		ht.remove("Jones");
		
		ht.printHashTable();
	}

}
