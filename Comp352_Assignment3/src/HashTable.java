
public class HashTable<K, V> {
	
	private static class HashNode<K, V> {
		K key; // Can be generic type
		V value; // Can be generic type

		HashNode<K, V> next;
		
		HashNode (K key, V value){
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}
	
	private HashNode<K, V>[] table;
	private int size;
	
	public HashTable(int initialCapacity) {
		this.table = new HashNode[initialCapacity];
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
        HashNode<K, V> newNode = new HashNode<>(key, value);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            newNode.next = table[index];
            table[index] = newNode;
        }

        size++;
    }
	
	public V get(K key) {
		int index = hash(key);
		HashNode<K, V> current = table[index];
		
		while (current != null) {
			if (current.key.equals(key)) {
				return current.value;
			}
			current = current.next;
		}
		return null;
	}

	public void remove(K key) {
		int index = hash(key);
		HashNode<K, V> current = table[index];
		HashNode<K, V> prev = null;
		
		while (current != null) {
			if (current.key.equals(key)) {
				if (prev == null) {
					table[index] = current.next;
				} else {
					prev.next = current.next;
				}
				size--;
				return;
			}
			prev = current;
			current = current.next;
		}
	}
	
	public boolean containsKey(K key) {
		int index = hash(key);
		HashNode<K, V> current = table[index];
		
		while (current != null) {
			if (current.key.equals(key)) return true; // value is found
			current = current.next;
		}
		return false; // not found
	}
	
	public Sequence showAll() {
		Sequence allElements = new Sequence();
		HashNode<K, V> current = table[0];
		for (int i = 0; i < table.length; i++) { // go through the entire table
			while (current != null) { // go through the linkedList to find 
				allElements.add(current);
				current = current.next;
			}
		}
		return allElements;
	}
}
