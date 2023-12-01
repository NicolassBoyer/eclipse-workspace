import java.util.Collection;
import java.util.LinkedList;
public class ReverseSequence {
	// Sequence ADT
    static class Sequence<T> extends LinkedList<T> {
        // Additional methods if needed
    }

    // Tail-recursive reverse function
    @SuppressWarnings("unchecked")
	static <T> Sequence<T> reverse(Sequence<T> original, Sequence<T> reversed) {
        if (original.isEmpty()) {
            return reversed;
        } else {
        	Sequence<Integer> leftovers = new Sequence<>();
        	leftovers.addAll((Collection<? extends Integer>) original);
            T head = original.removeFirst(); // Remove the first element
            reversed.addFirst(head);         // Add it to the front of the reversed sequence
            return reverse(original, reversed);
        }
    }

	public static void main(String[] args) {
		// Example usage
        Sequence<Integer> originalSeq = new Sequence<>();
        originalSeq.add(1);
        originalSeq.add(2);
        originalSeq.add(3);
        
        Sequence<Integer> leftovers = new Sequence<>();
    	leftovers.addAll(originalSeq);

        Sequence<Integer> reversedSeq = reverse(originalSeq, new Sequence<>());

        // Print the reversed sequence
        System.out.println("Original Sequence: " + originalSeq);
        System.out.println("Reversed Sequence: " + reversedSeq);
	}
}
