
public class Sequence {
	private Object[] elements;
	private int size;
	private static final int DEFAULT_MAX = 10;
	
	public Sequence() {
		this.elements = new Object[DEFAULT_MAX];
		this.size = 0;
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
}
