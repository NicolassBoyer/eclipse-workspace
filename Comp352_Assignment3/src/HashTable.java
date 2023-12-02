
public class HashTable<K, V> {
	
	private class HashNode {
		private K key; // Can be generic type
		private V value; // Can be generic type
		
		public HashNode(K key, V data) {
			this.key = key;
			this.value = data;
		}
	}
	
	private LinkedList<K, V>[] table;
	private int size;
	
	public HashTable(int initialCapacity) {
		this.table = new LinkedList[initialCapacity];
		this.size = 0;
	}
	
	private int hash(K key) {
		return key.hashCode() % table.length;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void put(K key, V value) {
		int index = hash(key);
		if (table[index] == null) {
			table[index] = new LinkedList<>();
		}
		// Check if key already exists in the list
		for (Entry<K, V> entry : table[index]) {
			if (entry.key.equals(key)) {
				entry.value = value;
				return;
			}
		}
	}
	
	public T get(Integer key) {
		
		return null;
	}
	
	public T remove(Integer key) {
		Node<T> returnThis = buckets[key];
		buckets[key] = null;
		return returnThis.getData();
	}
}
