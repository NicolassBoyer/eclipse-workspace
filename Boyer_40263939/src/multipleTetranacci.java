import java.io.FileWriter;
import java.io.IOException;

//Nicolas Boyer
//40263939

public class multipleTetranacci {
	// recursive method multipleTetra
	public static int multipleTetra(int k) {
		if (k < 3) { // for the first 3 terms are always 0
			return 0;
		} else if (k == 3) { // make the 4th term 1
			return 1;
		}
		else { // any other term (5 onwards) will add the previous 4 terms together, so on and so forth
			return multipleTetra(k - 1) + multipleTetra(k - 2) + multipleTetra(k - 3) + multipleTetra(k - 4);
		}
	}

	public static void main(String[] args) {
		FileWriter writer = null; // fileWriter in order to show results
		long startTime = System.nanoTime(); // calculate runtime in nanoseconds
		
		try { // try and open a new fileWriter for MultipleTetraOut.txt
			writer = new FileWriter("MultipleTetraOut.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i <= 20; i++) { // run for first 40 numbers, not 200 this time to avoid overloading the stack call
			 int currentNum = multipleTetra(i);
	         try {
	        	 if (i % 5 == 0 && i != 0) { // add the current number only if its an increment of 5
	        		 writer.write(currentNum + "\n");
	    	         System.out.println("Content written to file :" + currentNum); // confirm in console that content was written
	        	 }
	         } catch (IOException e) {
	             e.printStackTrace();
	         }
		}
		
		// Program has ended, calculate total runtime
		long endTime = System.nanoTime();
		long runTime = endTime - startTime;
		
		try { // print out runtime and close writer
			writer.write("\nRuntime: " + runTime + " nanoseconds");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
