package driver;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException {

		
		do_part1(); 	// validating syntax, partition book records based on genre.
        //do_part2(); 	// validating semantics, read the genre files each into arrays of Book objects,
        			// then serialize the arrays of Book objects each into binary files.
        //do_part3(); 	// reading the binary files, deserialize the array objects in each file, and
	} 				// then provide an interactive program to allow the user to navigate the arrays. 
	
	public static void do_part1() throws FileNotFoundException {
		// Creates a new file for syntax errors and each different sport
		File newFile = new File("syntax_error_file.txt");
		File hokeyFile = new File("Hokey.csv");
		File footballFile = new File("Football.csv");
		File basketFile = new File("Basketball.csv");
		// Creates a new scanner to get the file names from
		Scanner in = new Scanner(new FileInputStream("part1 input file names.txt"));
		PrintWriter hokeyWriter = new PrintWriter(new FileOutputStream("Hokey.csv"));
		PrintWriter footballWriter = new PrintWriter(new FileOutputStream("Football.csv"));
		PrintWriter basketWriter = new PrintWriter(new FileOutputStream("Basketball.csv"));
		// finds the number of file names
		int numOfFiles = in.nextInt();
		// skip the line that has a number
		in.nextLine();
		// make an array of file names
		String[] fileNames = new String[numOfFiles];
		// go through the text file and add each file name to an entry in the array
		for (int i = 0; i < numOfFiles; i++) {
			fileNames[i] = in.nextLine();
		}
		
		Scanner fileScan = null;
		for (int i = 0; i < fileNames.length; i++) {
			fileScan = new Scanner(new FileInputStream(fileNames[i]));
			while (fileScan.hasNextLine()) {
				String s = fileScan.nextLine();
				String[] sArray = s.split(",");
				
			}
		}
		Scanner inHokey = new Scanner(new FileInputStream("Hokey.csv"));
		while(inHokey.hasNext()) {
			System.out.println(inHokey.next());
		}
		
		try {
			PrintWriter syntaxError = new PrintWriter(new FileOutputStream("syntax_error_file.txt"));
		} catch (FileNotFoundException f) {
			System.out.println("This file doesn't exist.");
		}
		
	}
	
	public String[] trimArray(String[] array) {
		String[] trimmedArray = new String[array.length];
		for (int i = 0; i < trimmedArray.length; i++) {
			trimmedArray[i] = array[i].trim();
		}
		return trimmedArray;
	}
	
	public static void do_part2() throws FileNotFoundException {
		Scanner in = new Scanner(new FileInputStream("games2001.csv"));
		while (in.hasNextLine()) {
			System.out.println(in.nextLine());
		}
		System.out.println();
		in = new Scanner(new FileInputStream("games2011.csv"));
		while (in.hasNextLine()) {
			System.out.println(in.nextLine());
		}
		System.out.println();
		in = new Scanner(new FileInputStream("games2019.csv"));
		while (in.hasNextLine()) {
			System.out.println(in.nextLine());
		}
		System.out.println();
		in = new Scanner(new FileInputStream("part1 input file names.txt"));
		while (in.hasNextLine()) {
			System.out.println(in.nextLine());
		}
		/*
		while (fileScan.hasNext()) {
			switch (fileScan.next()) {
				case "Hokey":
					hokeyWriter.flush();
					hokeyWriter.print(fileScan.nextLine());
					break;
				case "Football":
					footballWriter.flush();
					footballWriter.print(fileScan.nextLine());
					break;
				case "Basketball":
					basketWriter.flush();
					basketWriter.print(fileScan.nextLine());
					break;
				}
			}
		*/
	}
	
	public static void do_part3() throws FileNotFoundException {
		
	}
}

class TooManyFieldsException extends Exception {
	
}
class TooFewFieldsException extends Exception {
	
}
class MissingFieldException extends Exception {
	
}
class UnknownSportException extends Exception {
	
}
