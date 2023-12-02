
public class LinkedList<K, V> {
	private static class Node<K, V> {
		// key is the identifier, value is the data
		K key;
		V value;
		Node<K, V> next;
		
		Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}
	
	private Node<K, V> head;
	
	public void add(K key, V value) {
		Node<K, V> newNode = new Node<>(key, value);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}
	
	public V get(K key) {
		Node<K, V> current = head;
		while (current != null) {
			if (current.key.equals(key)) {
				return current.value;
			}
			current = current.next;
		}
		return null;
	}

	public void remove(K key) {
		if (head == null) {
			return;
		}
		if (head.key.equals(key)) {
			head = head.next;
			return;
		}
		Node<K, V> current = head;
		while (current.next != null && !current.next.key.equals(key)) {
			current = current.next;
		}
		if (current.next != null) {
			current.next = current.next.next;
		}
	}
	
	public boolean containsKey(K key) {
		Node<K, V> current = head;
		while (current != null) {
			if (current.key.equals(key)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	public int size() {
		int count = 0;
		Node<K, V> current = head;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}
}
