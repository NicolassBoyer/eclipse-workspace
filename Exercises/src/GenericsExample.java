import java.util.ArrayList;
import java.util.List;

public class GenericsExample {

	public static void main(String[] args) {
		
		List<Integer> intList = new ArrayList<>();
		Printer<Integer> intPrint = new Printer<>();
		intList.add(3);
		printList(intList);
		
		
	}
	
	private static void printList(List<?> myList) {
		System.out.println();
	}
}
