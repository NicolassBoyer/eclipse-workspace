import java.util.Random;

public class CleverSIDC {
	private Object[] elements;
	private int size;
	private static final int DEFAULT_MAX = 100;
	
	public CleverSIDC() {
		this.elements = new Object[DEFAULT_MAX];
		this.size = 100;
	}
	// creates a SIDC TH
	public void SetSIDCThreshold(int size) {
		/*where 100 ≤ Size ≤ ~500,000 is an integer number that defines
		the size of the list. This size is very important as it will determine what data types or data
		structures will be used (i.e. a Tree, Hash Table, AVL tree, binary tree, sequence, etc.)
		 */
		if (100 <= size && size <= 500000) {
			this.size = size;
		} else {
			System.out.println("Invalid size. Must be 100 <= size <= 500,000");
		}
	}
	public static String generate() {
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
		return keyGenerator.toString();
	}
	public Object[] allKeys() {
		
	}
	
	public int getSize() {
		return size;
	}
	public boolean isEmpty() {
		return (size==0);
	}
	public Object first() {
		return elements[0];
	}
	public Object last() {
		return elements[size-1];
	}

	public void add(Object element) {
		ensureCapacity();
		elements[size++] = element;
	}
	
	public void remove(Object element) {
		for (int i = 0; i < elements.length; i++) {
			if (elements[i].equals(element)) {
				// Shift elements
				System.arraycopy(elements, i + 1, elements, i, size - i - 1);
				elements[--size] = null; // last element (removed) now null
				return;
			}
		}
	}
	
	private void ensureCapacity() {
		if (size == elements.length) {
			// resize if the array doesn't have space
			int capacity = elements.length * 2;
			Object[] newElements = new Object[capacity];
			for (int i = 0; i < elements.length; i++) {
				newElements[i] = elements[i];
			}
			elements = newElements;
		}
	}
	
	public void printSeq() {
		System.out.print("Printing the sequence:");
		for (int i = 0; i < elements.length; i++) {
			System.out.println(elements[i]);
		}
	}
	
	public Object set(Object p, Object e) {
		Object temp = p;
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] == temp) {
				elements[i] = e;
				break;
			}
		}
		return temp;
	}
	
	public Object atIndex(int index) {
		Object foundObject = null;
		for (int i = 0; i < elements.length; i++) {
			if (i == index) {
				foundObject = elements[i];
			}
		}
		return foundObject;
	}
	
	
	

	public static void main(String[] args) {
		Queue newQueue = new Queue();
		
	}

}
