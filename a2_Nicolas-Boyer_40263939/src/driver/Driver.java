package driver;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;


import java.io.Serializable;

// -----------------------------------------------------
// Assignment 2 
// COMP 249
// All parts
// Written by: Nicolas Boyer 40263939
// Due Friday July 28th 2023
// -----------------------------------------------------

/* The purpose of this program is to take in files as an input, sort through them to find syntax and semantic errors,
 * print out the errors, and then allow the user to view the modified files with valid entries in them. The files contain
 * lines of different games and results, though only some inputs are valid. The text in the files is then turned into objects
 * and serialized into a separate file.
 */

public class Driver {

	public static void main(String[] args) throws FileNotFoundException, UnknownSportException,
	TooManyFieldsException, TooFewFieldsException, MissingFieldException {
		do_part1(); 	// validating syntax, partition book records based on genre.
        do_part2(); 	// validating semantics, read the genre files each into arrays of Book objects,
        				// then serialize the arrays of Book objects each into binary files.
        do_part3(); 	// reading the binary files, deserialize the array objects in each file, and
	} 					// then provide an interactive program to allow the user to navigate the arrays. 
	
	public static void do_part1() throws FileNotFoundException, UnknownSportException,
	TooManyFieldsException, TooFewFieldsException, MissingFieldException {
		// Creates a new file for syntax errors and each different sport
		File newFile = new File("syntax_error_file.txt");
		File hokeyFile = new File("Hokey.csv");
		File footballFile = new File("Football.csv");
		File basketFile = new File("Basketball.csv");
		
		// Creates scanner and printwriter objects who need to be null in order to catch exceptions when they are defined.
		Scanner in =  null;
		PrintWriter hokeyWriter = null;
		PrintWriter footballWriter = null;
		PrintWriter basketWriter = null;
		PrintWriter syntaxError = null;

		try {
			// Creates a new scanner to get the file names from
			in = new Scanner(new FileInputStream("part1 input file names.txt"));
			hokeyWriter = new PrintWriter(new FileOutputStream("Hokey.csv"));
			footballWriter = new PrintWriter(new FileOutputStream("Football.csv"));
			basketWriter = new PrintWriter(new FileOutputStream("Basketball.csv"));
			syntaxError = new PrintWriter(new FileOutputStream("syntax_error_file.txt"));
		} catch (FileNotFoundException e){
			System.out.println("Cannot find the name of one of these files");
		}

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
		
		// Create null objects for a file scanner, a string array, and a trimmed string array
		Scanner fileScan = null;
		String[] sArray = null;
		String[] sArrayTrimmed = null;

		// check each file
		for (int i = 0; i < fileNames.length; i++) {
			// create a scanner for the specific file
			fileScan = new Scanner(new FileInputStream(fileNames[i]));
			// loop whilst there are still lines in the file to read
			while (fileScan.hasNextLine()) {
				// create an array of each element on a line, and proceed to trim and split it
				boolean syntacticallyValid = true;
				String s = fileScan.nextLine();
				sArray = s.split(",");
				sArrayTrimmed = trimArray(sArray);
				// check if there are not too few fields and handle necessary exceptions
				try {
					if (sArray.length < 5) {
						throw new TooFewFieldsException(fileNames[i]);
					}
				} catch (TooFewFieldsException e) {
					syntaxError.println("syntax error in file: " + fileNames[i]);
					syntaxError.println("============================");
					syntaxError.println("Error: this line has too few fields.");
					syntaxError.println("Record: " + s + "\n");
					syntacticallyValid = false;
				}
				// check if there are not too many fields and catch necessary exceptions
				try {
					if (sArray.length > 5) {
						throw new TooManyFieldsException(fileNames[i]);
					}
				} catch (TooManyFieldsException e) {
					syntaxError.println("syntax error in file: " + fileNames[i]);
					syntaxError.println("============================");
					syntaxError.println("Error: this line has too many fields.");
					syntaxError.println("Record: " + s + "\n");
					syntacticallyValid = false;
				}
				// check for missing fields
				try {
					for (int j = 0; j < sArrayTrimmed.length; j++) {
						if (sArrayTrimmed[j].equals("")) {
							throw new MissingFieldException(fileNames[i]);
						}
					}
				// if missing field is found, find which one is missing
				} catch (MissingFieldException e) {
					syntaxError.println("syntax error in file: " + fileNames[i]);
					syntaxError.println("============================");
					if (sArrayTrimmed[0] == "") {
						syntaxError.println("Error: missing team field");
					}
					if (sArrayTrimmed[1] == "") {
						syntaxError.println("Error: missing sport field");
					}
					if (sArrayTrimmed[2] == "") {
						syntaxError.println("Error: missing year field");
					}
					if (sArrayTrimmed[3] == "") {
						syntaxError.println("Error: missing record field");
					}
					if (sArrayTrimmed[4] == "") {
						syntaxError.println("Error: missing championship field");
					}
					syntaxError.println("Record: " + s + "\n");
					syntacticallyValid = false;
					continue;
				}
				// check for valid sport name and throw an exception if name is not found
				try {
					if (syntacticallyValid) {
						if (sArrayTrimmed[1].equals("Hokey")){
							if (fileScan.hasNextLine()) {
								for (int j = 0; j < sArrayTrimmed.length; j++) {
									hokeyWriter.print(sArrayTrimmed[j]+",");
								}
								hokeyWriter.println("");
							}
							hokeyWriter.flush();
						} else if (sArrayTrimmed[1].equals("Basketball")){
							if (fileScan.hasNextLine()) {
								for (int j = 0; j < sArrayTrimmed.length; j++) {
									basketWriter.print(sArrayTrimmed[j]+",");
								}
								basketWriter.println("");
							}
							basketWriter.flush();
						} else if (sArrayTrimmed[1].equals("Football")) {
							if (fileScan.hasNextLine()) {
								for (int j = 0; j < sArrayTrimmed.length; j++) {
									footballWriter.print(sArrayTrimmed[j]+",");
								}
								footballWriter.println("");
							}
							footballWriter.flush();
						} else {
							throw new UnknownSportException(fileNames[i]);
						}
					}
				// add error to syntax file
				} catch (UnknownSportException e) {
					syntaxError.println("syntax error in file: " + fileNames[i]);
					syntaxError.println("============================");
					syntaxError.println("Error: " + sArrayTrimmed[1] + " is an unknown sport.");
					syntaxError.println("Record: " + s + "\n");
				}
			}
			// close file scanner
			fileScan.close();
		}
		
		// close file writers
		hokeyWriter.close();
		basketWriter.close();
		footballWriter.close();
		syntaxError.close();
		in.close();
		
		// print out syntaxError file
		Scanner syntaxErrorPrint = new Scanner(new FileInputStream("syntax_error_file.txt"));
		while (syntaxErrorPrint.hasNextLine()) {
			System.out.println(syntaxErrorPrint.nextLine());
		}

	}
	
	public static String[] trimArray(String[] array) {
		String[] trimmedArray = new String[array.length];
		for (int i = 0; i < trimmedArray.length; i++) {
			trimmedArray[i] = array[i].trim();
		}
		return trimmedArray;
	}
	
	public static void do_part2() throws FileNotFoundException, UnknownSportException,
	TooManyFieldsException, TooFewFieldsException, MissingFieldException {
		// Creates a new file for semantically correct sports and semantic errors
		File semHokey = new File("HokeySem.csv");
		File semFootball = new File("FootballSem.csv");
		File semBasketball = new File("BasketballSem.csv");
		
		// Create new files to hold serialized arrays
		File hokeyFile = new File("Hokey.csv.ser");
		File footballFile = new File("Football.csv.ser");
		File basketFile = new File("Basketball.csv.ser");
		
		// Create file for semantic errors
		File semanticFile = new File("semantic_error_file.txt");
		
		// Scanners for existing records
		Scanner hokeyReader = null;
		Scanner footballReader = null;
		Scanner basketReader = null;
		
		PrintWriter hokeyWriter = null;
		PrintWriter footballWriter = null;
		PrintWriter basketWriter = null;
		PrintWriter semanticError = null;
		
		try {
			// Creates a new scanner to get the file names from
			hokeyReader = new Scanner(new FileInputStream("Hokey.csv"));
			footballReader = new Scanner(new FileInputStream("Football.csv"));
			basketReader = new Scanner(new FileInputStream("Basketball.csv"));
			
			// Create printWriters for semantically correct records
			hokeyWriter = new PrintWriter(new FileOutputStream("HokeySem.csv"));
			footballWriter = new PrintWriter(new FileOutputStream("FootballSem.csv"));
			basketWriter = new PrintWriter(new FileOutputStream("BasketballSem.csv"));
			
			// create an error text file for semantic errors
			semanticError = new PrintWriter(new FileOutputStream("semantic_error_file.txt"));
		} catch (FileNotFoundException e){
			System.out.println("Cannot find the name of one of these files");
		}
		
		// count number of valid games and write to semantic error file for each file
		int numOfHokeyGames = checkForSemanticErrors(hokeyReader, "Hokey.csv", hokeyWriter, semanticError);
		int numOfFootballGames = checkForSemanticErrors(footballReader, "Football.csv", footballWriter, semanticError);
		int numOfBasketballGames = checkForSemanticErrors(basketReader, "Basketball.csv", basketWriter, semanticError);
		
		hokeyWriter.close();
		footballWriter.close();
		basketWriter.close();
		
		// create new teams for valid games
		Team[] hokeyTeams = new Team[numOfHokeyGames];
		Team[] footballTeams = new Team[numOfFootballGames];
		Team[] basketballTeams = new Team[numOfBasketballGames];
		
		Scanner serHokeyReader = new Scanner(new FileInputStream("HokeySem.csv"));
		Scanner serFootballReader = new Scanner(new FileInputStream("FootballSem.csv"));
		Scanner serBasketReader = new Scanner(new FileInputStream("BasketballSem.csv"));
		
		PrintWriter serHokeyWriter;
		PrintWriter serFootballWriter;
		PrintWriter serBasketWriter;
		
		// create new teams for the arrays and store them in the entries
		for (int i = 0; i < hokeyTeams.length; i++) {
			String currentRecord = serHokeyReader.nextLine();
			String[] currentSplit = currentRecord.split(",");
			Team newTeam = new Team(currentSplit[0],currentSplit[1],currentSplit[2],currentSplit[3],currentSplit[4]);
			hokeyTeams[i] = newTeam;
		}
		for (int i = 0; i < footballTeams.length; i++) {
			String currentRecord = serFootballReader.nextLine();
			String[] currentSplit = currentRecord.split(",");
			Team newTeam = new Team(currentSplit[0],currentSplit[1],currentSplit[2],currentSplit[3],currentSplit[4]);
			footballTeams[i] = newTeam;
		}
		for (int i = 0; i < basketballTeams.length; i++) {
			String currentRecord = serBasketReader.nextLine();
			String[] currentSplit = currentRecord.split(",");
			Team newTeam = new Team(currentSplit[0],currentSplit[1],currentSplit[2],currentSplit[3],currentSplit[4]);
			basketballTeams[i] = newTeam;
		}
		
		//create fileoutput stream in order to store the serializable arrays
		FileOutputStream hokeyOut = new FileOutputStream("HokeySem.csv.ser");
		FileOutputStream footballOut = new FileOutputStream("FootballSem.csv.ser");
		FileOutputStream basketballOut = new FileOutputStream("BasketballSem.csv.ser");
		
		try {
			// write objects to the files
			ObjectOutputStream hokeyTeamOut = new ObjectOutputStream(hokeyOut);
			ObjectOutputStream footballTeamOut = new ObjectOutputStream(footballOut);
			ObjectOutputStream basketballTeamOut = new ObjectOutputStream(basketballOut);
			hokeyTeamOut.writeObject(hokeyTeams);
			footballTeamOut.writeObject(footballTeams);
			basketballTeamOut.writeObject(basketballTeams);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int checkForSemanticErrors(Scanner reader, String fileName, PrintWriter writer, PrintWriter errorFile) {
		// initialize number of games
		int numOfGames = 0;
		// check for next line in reader
		while (reader.hasNextLine()) {
			// if next line exists, split the line by commas into an array
			String thisLine = reader.nextLine();
			String[] thisArray = thisLine.split(",");
			// booleans to check for invalid year or record
			boolean badRecord = false;
			boolean badYear = false;
			// try to catch BadRecordException
			try {
				// 4th entry is the place of the record
				String record = thisArray[3];
				// check for a dash in the string
				boolean foundDash = false;
				for (int i = 0; i < record.length(); i++) {
					if (record.charAt(i) == '-') {
						foundDash = true;
					}
				}
				// if a dash isn't found, it is a bad record
				if (foundDash = false) {
					throw new BadRecordException(fileName);
				} else {
					// if a dash is found, check if there are multiple dashes by splitting
					// if length is not 2, then it is an invalid record
					String[] recordArray = record.split("-");
					if (recordArray.length != 2) {
						throw new BadRecordException(fileName);
					} else {
						// if each String in the record array next to the dash can be parsed to an int, it is valid
						for (int i = 0; i < recordArray.length; i++) {
							try {
								int number = Integer.parseInt(recordArray[i]);
							} catch (NumberFormatException ex) {
								throw new BadRecordException(fileName);
							}
						}
					}
				}
			} catch (BadRecordException e) {
				// write out a bad record exception and set badRecord to true
				System.out.println("Bad record exception found in file " + reader);
				badRecord = true;
				errorFile.println("semantic error in file: " + fileName);
				errorFile.println("============================");
				errorFile.println("Error: this line has an invalid record.");
				errorFile.println("Record: " + thisLine + "\n");
			}
			// try to catch BadYearException
			try {
				// 3rd spot in the array is the year
				String yearString = thisArray[2];
				// if the year can be parsed to an integer and is between 1990 and 2023 it is valid
				try {
					int number = Integer.parseInt(yearString);
					if (number > 1990 && number < 2023) {
						badYear = false;
					} else {
						throw new BadYearException(fileName);
					}
				} catch (NumberFormatException ex) {
					throw new BadYearException(fileName);
				}
			} catch (BadYearException e) {
				// print out bad year exception and write to the file
				System.out.println("Bad year exception found in file " + reader);
				badYear = true;
				errorFile.println("semantic error in file: " + fileName);
				errorFile.println("============================");
				errorFile.println("Error: this line has an invalid year.");
				errorFile.println("Record: " + thisLine + "\n");
			}
			
			// if the record and year are valid, print the line to the semantically correct writer
			if (!badRecord && !badYear) {
				writer.println(thisLine);
				numOfGames++;
			}
		}
		return numOfGames;
	}
	
	public static void do_part3() throws FileNotFoundException, UnknownSportException,
	TooManyFieldsException, TooFewFieldsException, MissingFieldException {
		
		// initialize arrays of teams
		Team[] hokeyObj = null;
		Team[] footballObj = null;
		Team[] basketballObj = null;
		
		// try to take an input stream from the semantically corrected serialized object files
		try {
			FileInputStream hokeyIn = new FileInputStream("HokeySem.csv.ser");
			FileInputStream footballIn = new FileInputStream("FootballSem.csv.ser");
			FileInputStream basketballIn = new FileInputStream("BasketballSem.csv.ser");
			
			// write objects to the files
			ObjectInputStream hokeyObjIn = new ObjectInputStream(hokeyIn);
			ObjectInputStream footballObjIn = new ObjectInputStream(footballIn);
			ObjectInputStream basketballObjIn = new ObjectInputStream(basketballIn);
			
			// read the objects from the files
			hokeyObj = (Team[]) hokeyObjIn.readObject();
			footballObj = (Team[]) footballObjIn.readObject();
			basketballObj = (Team[]) basketballObjIn.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		// create arrays of the string versions of the teams
		String[] toStrHokeyTeams = new String[hokeyObj.length];
		String[] toStrFootballTeams = new String[footballObj.length];
		String[] toStrBasketballTeams = new String[basketballObj.length];
		
		// transfer each object into a string and then store it in the string arrays
		for (int i = 0; i < hokeyObj.length; i++) {
			toStrHokeyTeams[i] = hokeyObj[i].toString();
		}
		for (int i = 0; i < footballObj.length; i++) {
			toStrFootballTeams[i] = footballObj[i].toString();
		}
		for (int i = 0; i < basketballObj.length; i++) {
			toStrBasketballTeams[i] = basketballObj[i].toString();
		}
		
		// create a new scanner to take in user input
		Scanner in = new Scanner(System.in);
		// default file name and record amount
		String fileName = "No file selected";
		int recordAmount = 0;
		// specific record amounts for each sport
		int hokeyRecordAmount = 0;
		int footballRecordAmount = 0;
		int basketballRecordAmount = 0;
		
		// count the amount of records in each array
		for (int i = 0; i < toStrHokeyTeams.length; i++) {
			hokeyRecordAmount++;
		}
		for (int i = 0; i < toStrFootballTeams.length; i++) {
			footballRecordAmount++;
		}
		for (int i = 0; i < toStrBasketballTeams.length; i++) {
			basketballRecordAmount++;
		}
		
		// default choice
		String choice = "";
		
		// whilst the user doesnt exit loop the program
		while (!choice.equals("x")) {
			// print main menu
			System.out.println("");
			System.out.println("-----------------------------");
			System.out.println("Main Menu");
			System.out.println("-----------------------------");
			System.out.println("v View the selected file: " + fileName + " (" + recordAmount + " records)");
			System.out.println("s Select a file to view");
			System.out.println("x Exit");
			System.out.println("-----------------------------");
			System.out.println("Enter your choice: ");
			// user input for choice
			choice = in.next();
			// display the viewed file by printing each entry in the string array depending on the file name
			if (choice.equals("v")) {
				String[] viewingArray = toStrHokeyTeams;
				if (fileName.equals("HokeySem.csv.ser")) {
					System.out.println("viewing: HokeySem.csv.ser (" + recordAmount + " records)");
					for (int i = 0; i < toStrHokeyTeams.length; i++) {
						System.out.println(toStrHokeyTeams[i]);
					}
					viewingArray = toStrHokeyTeams;
				} else if (fileName.equals("BasketballSem.csv.ser")) {
					System.out.println("viewing: BasketballSem.csv.ser (" + recordAmount + " records)");
					for (int i = 0; i < toStrBasketballTeams.length; i++) {
						System.out.println(toStrBasketballTeams[i]);
					}
					viewingArray = toStrBasketballTeams;
				} else if (fileName.equals("FootballSem.csv.ser")) {
					System.out.println("viewing: FootballSem.csv.ser (" + recordAmount + " records)");
					for (int i = 0; i < toStrFootballTeams.length; i++) {
						System.out.println(toStrFootballTeams[i]);
					}
					viewingArray = toStrFootballTeams;
				} 
			int viewCommand = 1000;
			viewCommand = in.nextInt();
			String currentObj = viewingArray[0];
			// move object in array
			while (viewCommand != 0) {
				// move object up
				if (viewCommand < 0) {
					for (int i = Math.abs(viewCommand); i >= 0; i--) {
						System.out.println(viewingArray[i]);
						if (i == 0) {
							currentObj = viewingArray[i];
							System.out.println("BOF has been reached");
						}
					}
				// move object down
				} else if (viewCommand > 0) {
					for (int i = 0; i < viewCommand; i++) {
						System.out.println(viewingArray[i]);
						if (i == viewCommand-1) {
							currentObj = viewingArray[i];
							System.out.println("EOF has been reached");
						}
					}
				}
				// allow subsequent view commands to be entered
				viewCommand = in.nextInt();
			}	
			
			// allow the user to choose one of the files to view
			} else if (choice.equals("s")) {
				System.out.println("-----------------------------");
				System.out.println("File Sub-Menu");
				System.out.println("-----------------------------");
				System.out.println("1 Hokey.csv.ser (" + hokeyRecordAmount + " record(s))");
				System.out.println("2 Football.csv.ser (" + footballRecordAmount + " record(s))");
				System.out.println("3 Basketball.csv.ser (" + basketballRecordAmount + " record(s))");
				System.out.println("4 Exit");
				System.out.println("-----------------------------");
				System.out.println("Enter your choice: ");
				String subchoice = in.next();
				if (subchoice.equals("1")) {
					fileName = "HokeySem.csv.ser";
					recordAmount = hokeyRecordAmount;
				} else if (subchoice.equals("2")) {
					fileName = "FootballSem.csv.ser";
					recordAmount = footballRecordAmount;
				} else if (subchoice.equals("3")) {
					fileName = "BasketballSem.csv.ser";
					recordAmount = basketballRecordAmount;
				} else if (subchoice.equals("4")) {
				}
			}
		}

	}
}

// Team class
class Team implements Serializable {
	// variables
	String name;
	String sport;
	String year;
	String score;
	String championship;
	
	// constructors
	public Team() {
		this.name = "Team";
		this.sport = "Generic";
		this.year = "2003";
		this.score = "34-14";
		this.championship = "championship";
	}
	public Team(String name, String sport, String year, String score, String championship) {
		this.name = name;
		this.sport = sport;
		this.year = year;
		this.score = score;
		this.championship = championship;
	}
	
	// getter methods
	public String getName() {
		return name;
	}
	public String getSport() {
		return sport;
	}
	public String getYear() {
		return year;
	}
	public String getScore() {
		return score;
	}
	public String getChampionship() {
		return championship;
	}
	// setter methods
	public void setName(String name) {
		this.name = name;
	}
	public void setSport(String sport) {
		this.sport = sport;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public void setChampionship(String championship) {
		this.championship = championship;
	}
	// equals and toString method
	public boolean equals(Team anotherTeam) {
		// checks if same object
		if (this == anotherTeam) {
			return true;
		} 
		// checks if the classes are the same or that the object being compared is null
		if (anotherTeam == null || getClass() != anotherTeam.getClass()) {
			return false;
		}
		// check all variables to see if they are equal and return the result
		return getScore().equals(anotherTeam.getScore()) && getName().equals(anotherTeam.getScore()) 
				&& getSport().equals(anotherTeam.getSport()) && getYear().equals(anotherTeam.getYear())
				&& getChampionship().equals(anotherTeam.getChampionship());
	}
	public String toString() {
		return getName() + " " + getSport() + " " + getYear() + " " + getScore() + " " + getChampionship();
	}
}

// Exception classes
class TooManyFieldsException extends Exception {
	public TooManyFieldsException(String fileName) {
		System.out.println("Too many fields in the file " + fileName);
	}
}
class TooFewFieldsException extends Exception {
	public TooFewFieldsException(String fileName) {
		System.out.println("Too few fields in the file " + fileName);
	}
}
class MissingFieldException extends Exception {
	public MissingFieldException(String fileName) {
		System.out.println("Missing field in the file " + fileName);
	}
}
class UnknownSportException extends Exception {
	public UnknownSportException(String fileName) {
		System.out.println("Unknown sport for the file " + fileName);
	}
}
class BadRecordException extends Exception {
	public BadRecordException(String fileName) {
		System.out.println("Bad record in file " + fileName);
	}
}
class BadYearException extends Exception {
	public BadYearException(String fileName) {
		System.out.println("Bad year in file " + fileName);
	}
}
