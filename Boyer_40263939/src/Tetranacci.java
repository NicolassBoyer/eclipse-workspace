import java.io.FileWriter;
import java.io.IOException;

public class Tetranacci {
	public static int multipleTetranacci(int k) {
		if (k == 1 || k == 0) {
			return k;
		}
		else {
			return multipleTetranacci(k - 1) + multipleTetranacci(k - 2);
		}
	}
	
	public static int[] linearTetranacci(int k) {
		if (k == 1) {
			int[] result = { 1, 0 };
			return result;
		}
		else {
			int [] lastResult = linearTetranacci(k - 1);
			int i = lastResult[0];
			int j = lastResult[1];
			
			int[] currentResult = { i + j, i };
			return currentResult;
		}
	}
	
	 public static void main(String[] args) {
	        int k = 5; // Change this value to calculate a different Fibonacci number
	        
	        int[] result = linearTetranacci(k);
	        int fk = result[0];
	        int fkMinus1 = result[1];
	        
	        System.out.println("F_" + k + " = " + fk);
	        System.out.println("F_" + (k - 1) + " = " + fkMinus1);
	    }
	
}