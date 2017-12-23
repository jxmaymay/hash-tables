/*
 * This class sets up the has table data structure along with
 * the utility methods to manipulate it.
 */
public class HashTable {

	private Node[] map;
	private int tableSize;
	public HashTable(int tableSize) {
		map = new Node[tableSize];
		this.tableSize = tableSize;
	}
	
	private int hash(String key) {
		
		if(key == null){
			return 0;
		}
		else{
			int sum = 0;
			for (int i=0; i < key.length(); i++) {
				char place = key.charAt(i);
				sum = sum + place;
			}
			return Math.abs(sum) % 8;
		}
		
	}
	
	public void insert(String key) {
		int num = hash(key);
		Node newNode = new Node(key);
		newNode.next = map[num];
		map[num] = newNode;
		
	}
	public boolean search(String key) {
		int num = hash(key);
		Node point = map[num];
		int i = 0;
		while(point != null && i == 0){
			if(point.record == map[num].record)
			i++;
			else{
				point = point.next;
			}
		}
		if( i > 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void printTable() {

		for (int i = 0; i < tableSize; i++) {
			Node pointer = map[i];
			System.out.println(i + ": ");
			while (pointer != null){
				System.out.println(pointer.record);
				pointer = pointer.next;
			}
			
		}
	}
	
	public void delete(String key) {
		int num = hash(key);
		Node pointer = map[num];
		Node p = null;
		while (pointer != null ) {
			if (pointer.record.equals(key)) {
				pointer.record = null;
			} 
			p = pointer;
			pointer = pointer.next;
		
		}
	}
}
