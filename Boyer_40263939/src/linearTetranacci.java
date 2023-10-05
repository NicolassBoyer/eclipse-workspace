import java.io.FileWriter;
import java.io.IOException;

//Nicolas Boyer
//40263939

public class linearTetranacci {
	// recursive method linearTetra
	public static int[] linearTetra(int k, int[] terms) {
		int[] newTerms = new int[terms.length+1]; // create new array with 1 extra term
		int newSum = 0; 						  // create sum to enter into newTerms array
		for (int i = 0; i < terms.length; i++) {  // add each term from the old array to the new one
			newTerms[i] = terms[i];
		}
		for (int i = terms.length-4; i < terms.length; i++) { // add only the last 4 terms of the array together to the sum
			newSum += terms[i];
		}
		
		newTerms[newTerms.length-1] = newSum; // add the sum to the array
		
		if (k == 1) {
			return newTerms; // once the algorithm has run k amount of times the increment is 1 and the final array is returned
		}
		else { // otherwise, recursive call to k - 1
			return linearTetra(k - 1, newTerms);
		}
	}

	public static void main(String[] args) {
		FileWriter writer = null; // create FileWriter to write results to
		long startTime = System.nanoTime(); // start recording time in nanoseconds to find program runtime
		
		try { // open to fileWriter to file LinearTetraOut.txt
			writer = new FileWriter("LinearTetraOut.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		int[] initialTerms = { 0,0,0,1 }; // initialize an array of terms to use
		
		for (int i = 5; i <= 40; i += 5) { // for loop in increments of 5
			int[] currentNum = linearTetra(i, initialTerms); // run recursive method, which will determine this new array
			try {
				writer.write(currentNum[i] + "\n");
				System.out.println("Content written to file:" + currentNum[i]); // print only the increment of 5
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// program ends, calculate final runtime
		long endTime = System.nanoTime();
		long runTime = endTime - startTime;
		
		try { // write runtime and close the file
			writer.write("\nRuntime: " + runTime + " nanoseconds");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
