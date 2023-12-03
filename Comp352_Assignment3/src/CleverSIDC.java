import java.util.Random;

public class CleverSIDC<K, V> {
	private Object dataStructure;
	private int size;
	private static final int DEFAULT_MAX = 100;
	
	public CleverSIDC() {
		this.dataStructure = new Object[DEFAULT_MAX];
		this.size = 100;
	}
	public Object getDataStructure() {
		return dataStructure;
	}
	public void setDataStructure(Object structure) {
		this.dataStructure = structure;
	}
	public int getSize() {
		return size;
	}
	// creates a SIDC TH
	public void SetSIDCThreshold(int size) {
		/*where 100 ≤ Size ≤ ~500,000 is an integer number that defines
		the size of the list. This size is very important as it will determine what data types or data
		structures will be used (i.e. a Tree, Hash Table, AVL tree, binary tree, sequence, etc.)
		 */
		if (100 <= size && size <= 500000) {
			if (size <= 1000) {
				dataStructure = new HashTable<Integer, Integer>(size);
			} else {
				dataStructure = new AVLTree<Integer>();
			}
			this.size = size;
		} else {
			System.out.println("Invalid size. Must be 100 <= size <= 500,000");
		}
	}
	public static long generate() {
		// randomly generates new non-existing key of 8 digits
		String numbers = "0123456789";
		Random random = new Random();
		// new StringBuilder with 8 digits
		StringBuilder keyGenerator = new StringBuilder(8);
		// randomize each number
		for (int i = 0; i < 8; i++) {
			int randomIndex = random.nextInt(numbers.length());
			char randomChar = numbers.charAt(randomIndex);
			keyGenerator.append(randomChar);
		}
		String keyString = keyGenerator.toString();
		return Long.parseLong(keyString);
	}
	@SuppressWarnings("unchecked")
	public Sequence allKeys() {
		if (getDataStructure() instanceof HashTable) {
			HashTable<Integer, Integer> hashTable = (HashTable<Integer, Integer>) getDataStructure();
			return hashTable.showAll();
		} else if (getDataStructure() instanceof AVLTree) {
			AVLTree<Integer> tree = (AVLTree<Integer>) getDataStructure();
			return tree.traverse();
		}
		return null; // If somehow data structure doesn't work
	}
	@SuppressWarnings("unchecked")
	public void add(CleverSIDC<K, V> cleverSIDC, K key, V value) {
		if (getDataStructure() instanceof HashTable) {
			HashTable<Integer, Integer> hashTable = (HashTable<Integer, Integer>) getDataStructure();
			hashTable.put((int) key, (int) value);
			setDataStructure(hashTable);
		} else if (getDataStructure() instanceof AVLTree) {
			AVLTree<Integer> tree = (AVLTree<Integer>) getDataStructure();
			tree.insert((int) value); // no need for a key in an AVL tree, it is sorted
			setDataStructure(tree);
		}
	}
	@SuppressWarnings("unchecked")
	public void remove(CleverSIDC<K, V> cleverSIDC, K key) {
		if (getDataStructure() instanceof HashTable) {
			HashTable<Integer, Integer> hashTable = (HashTable<Integer, Integer>) getDataStructure();
			hashTable.remove((int) key);
			setDataStructure(hashTable);
		} else if (getDataStructure() instanceof AVLTree) {
			AVLTree<Integer> tree = (AVLTree<Integer>) getDataStructure();
			tree.delete(tree. ); // no need for a key in an AVL tree, it is sorted
			setDataStructure(tree);
		}
	}
	public V getValues(CleverSIDC<K, V> cleverSIDC, K key) {
		return null;
	}
	public K nextKey(CleverSIDC<K, V> cleverSIDC, K key) {
		return null;
	}
	public K prevKey(CleverSIDC<K, V> cleverSIDC, K key) {
		return null;
	}
	public int rangeKey(K key1, K key2) {
		return 0;
	}
	
	public static void main(String[] args) {
		
		
	}

}
