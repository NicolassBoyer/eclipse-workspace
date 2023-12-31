import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

//-----------------------------------------------------
//Assignment 23
//COMP 249
//All parts
//Written by: Nicolas Boyer 40263939
//Due Tuesday Aug 8th 2023
//-----------------------------------------------------

/**
 * Represents a book with various attributes.
 */
public class Book {
	String title;
	String author;
	double price;
	long ISBN;
	String genre;
	int year;
}

/**
 * Represents a linked list of books.
 */
class BookList {
	Node head;
	/**
     * Constructor to create an empty BookList.
     */
	public BookList() {
		head = null;
	}
	
	// Other methods
	// add a book to the start of a circular linked list
	public void addToStart(Book b) {
		Node n;
		if (head != null) {
			n = new Node(b,head);
		} else {
			n = new Node(b,null);
		}
		head = n;
		n = null;
	}
	// store the records into a file for the entered year
	public void storeRecordsByYear(int yr) {
		String yrStr = "" + yr;
		boolean createFile = false;
		Node current = head;
		PrintWriter yearWriter = null;
		
		while(current.next != null) {
			if (current.b.year == yr) {
				createFile = true;
				break;
			}
			if (current.next != null) {
				current = current.next;
			}
		}
		
		if (createFile) {
			File yearFile = new File(yrStr+".txt");
			
			try {
				yearWriter = new PrintWriter(yrStr+".txt");
			} catch (FileNotFoundException e) {
				System.out.println("The file for this year wasn't found.");
			}
		}
		
		int count = 0;
		current = head;
		while(current.next != null) {
			if (current.b.year == yr) {
				yearWriter.println(current.b.title + "," + current.b.author + "," + current.b.price + "," + current.b.ISBN + ","
						+ current.b.genre + "," + current.b.year);
			}
			if (current.next != null) {
				current = current.next;
			}
		}
		yearWriter.close();
	}
	// insert a book before the book with the entered isbn
	public boolean insertBefore(long isbn, Book b) {
		Node current = head;
		
		while(current != null && current.next != head) {
			if (current.next.b.ISBN == isbn) {
				Node nodeInsert = new Node(b,current.next);
				current.next = nodeInsert;
				
				if (current.next == head) {
					head = nodeInsert;
				}
				
				return true;
			} else {
				current = current.next;
			}
		}
		return false;
	}
	// insert a book between the too isbn numbers entered
	public boolean insertBetween(long isbn1, long isbn2, Book b) {
		if (head == null || head.next == head) {
			return false;
		}
		
		if (head.b.ISBN == isbn1 && head.next.b.ISBN == isbn2) {
			Node nodeInsert = new Node(b, head.next);
			head.next = nodeInsert;
			return true;
		}
		
		Node current = head;
		while(current.next != null && current.next != head) {
			if ((current.b.ISBN == isbn1 && current.next.b.ISBN == isbn2) || (current.b.ISBN == isbn2 && current.next.b.ISBN == isbn1)) {
				Node nodeInsert = new Node(b,current.next);
				current.next = nodeInsert;
				return true;
			}
			if (current.next != null) {
				current = current.next;
			}
		}
		return false;
	}
	// Show all content in the booklist
	public void displayContent() {
		Node current = head;
		
		while(current != null) {
			System.out.println(current.b.title + ", " + current.b.author + ", " + current.b.price + ", " + current.b.ISBN + ", "
					+ current.b.genre + ", " + current.b.year + " ==>");
			current = current.next;
			if (current == null) {
				System.out.println("===> head");
			}
		}
	}
	// Delete all following duplicates on the circular list
	public void delConsecutiveRepeatedRecords() {
		Node current = head;
		
		while(current.next != null) {
			if (current.b.author.equals(current.next.b.author) &&
				current.b.title.equals(current.next.b.title) &&
				current.b.price == current.next.b.price &&
				current.b.ISBN == current.next.b.ISBN &&
				current.b.genre.equals(current.next.b.genre) &&
				current.b.year == current.next.b.year) {
				current.next = current.next.next;
			}
			if (current.next != null) {
				current = current.next;
			}
		}
	}
	// create a new booklist with only a specific author
	public BookList extractAuthList(String aut) {
		Node current = head;
		BookList newList = new BookList();
		
		while(current != null) {
			if (current.b.author.equals(aut)) {
				newList.addToStart(current.b);
			}
			current = current.next;
		}
		return newList;
	}
	// swap two elements in the circular list
	public boolean swap(long isbn1, long isbn2) {
	    Node current = head;
	    Node temp1 = null;
	    Node temp2 = null;

	    while (current != null) {
	        if (current.b.ISBN == isbn1) {
	            temp1 = current;
	        } else if (current.b.ISBN == isbn2) {
	            temp2 = current;
	        }
	        current = current.next; // Move to the next node
	    }

	    if (temp1 != null && temp2 != null) {
	        // Swap the books within the nodes
	        Book tempBook = temp1.b;
	        temp1.b = temp2.b;
	        temp2.b = tempBook;
	        
	        return true;
	    }

	    return false;
	}

	private class Node {
		private Book b;
		Node next;
		
		/**
         * Default constructor for Node.
         */
		public Node() {
			b = null;
			next = null;
		}
		
		/**
         * Constructor for Node with data and next node reference.
         *
         * @param b    The Book data for this node.
         * @param next Reference to the next node.
         */
		public Node(Book b, Node next) {
			this.b = b;
			this.next = next;
		}
	}
}

/**
 * Main class to demonstrate the usage of BookList and related classes.
 */
class Driver {
	public static void main(String[] args) {
		ArrayList<Book> arrLst = new ArrayList<Book>();
		BookList bkLst = new BookList();
		
		// Creates scanner and printwriter objects who need to be null in order to catch exceptions when they are defined.
		Scanner booksIn =  null;
		PrintWriter yearErrorWriter = null;
		
		File yearError = new File("YearErr.txt");

		try {
			// Creates a new scanner to get the file names from
			booksIn = new Scanner(new FileInputStream("Books.txt"));
			yearErrorWriter = new PrintWriter(new FileOutputStream(yearError));
		} catch (FileNotFoundException e){
			System.out.println("Cannot find the name of one of these files");
		}
		
		int bookCount = 0;
		// store all books into either the circular list at the start or print them into a year array file
		while (booksIn.hasNextLine()) {
			String strBook = booksIn.nextLine();
			String[] bookArr = strBook.split(",");
			String[] bookArrTrim = trimArray(bookArr);
			
			Book currentBook = new Book();
			currentBook.title = bookArrTrim[0];
			currentBook.author = bookArrTrim[1];
			currentBook.price = Double.parseDouble(bookArrTrim[2]);
			currentBook.ISBN = Long.parseLong(bookArrTrim[3]);
			currentBook.genre = bookArrTrim[4];
			currentBook.year = Integer.parseInt(bookArrTrim[5]);
			
			if (currentBook.year > 2023 || currentBook.year < 1900) { // print into year arraylist if year isnt correct
				arrLst.add(currentBook);
			} else {
				bkLst.addToStart(currentBook);
			}
		}
		
		try {
			// create buffered writer to write all arraylist items into the error file
			BufferedWriter writer = new BufferedWriter(new FileWriter("YearErr.txt"));
			
			for (Book element : arrLst){
				writer.write(element.title + ", " + element.author + ", " + element.price + ", " + element.ISBN
						+ ", " + element.genre + ", " + element.year);
				writer.newLine();
			}
			
			writer.close();
		} catch (IOException e) {
			System.out.println("Error writing to the file: " + e.getMessage());
		}
		// display menu for users
		System.out.println("1)	Give me a year # and I would extract all records of that year and store them in a file for that year");
		System.out.println("2)	Ask me to delete all consecutive repeated records");
		System.out.println("3)	Give me an author name and I will create a new list with the records of this author and display them;");
		System.out.println("4)	Give me an ISBN number and a Book object, and I will insert Node with the book before the record with this ISBN;");
		System.out.println("5)	Give me 2 ISBN numbers and a Book object, and I will insert a Node between them, if I find them!");
		System.out.println("6)	Give me 2 ISBN numbers and I will swap them in the list for rearrangement of records; of course if they exist!");
		System.out.println("7)	Tell me to STOP TALKING.");
		
		Scanner in = new Scanner(System.in);
		int choice;
		// menu continues to function whilst the user has not entered 7
		do {
			choice = in.nextInt();
			in.nextLine();
			switch (choice) {
			case 1:
				System.out.println("Enter a year: ");
				int year = in.nextInt();
				in.nextLine();
				bkLst.storeRecordsByYear(year);
				
				bkLst.displayContent();
				break;
			case 2:
				bkLst.delConsecutiveRepeatedRecords();
				System.out.println();
				bkLst.displayContent();
				break;
			case 3:
				System.out.println("Enter an author name: ");
				String author = in.nextLine();
				BookList authList = bkLst.extractAuthList(author);
				authList.displayContent();
				System.out.println("");
				bkLst.displayContent();
				break;
			case 4:
				System.out.println("Give me an ISBN number to find: ");
				long isbnID = in.nextLong();
				in.nextLine();
				Book bkEnter = new Book();
				System.out.println("Enter the book's title:");
				bkEnter.title = in.nextLine();
				System.out.println("Enter the book's author:");
				bkEnter.author = in.nextLine();
				System.out.println("Enter the book's price:");
				bkEnter.price = in.nextDouble();
				in.nextLine();
				System.out.println("Enter the book's ISBN:");
				bkEnter.ISBN = in.nextLong();
				in.nextLine();
				System.out.println("Enter the book's genre:");
				bkEnter.genre = in.nextLine();
				System.out.println("Enter the book's year:");
				bkEnter.year = in.nextInt();
				in.nextLine();
				boolean canInsert = bkLst.insertBefore(isbnID, bkEnter);
				if (canInsert) { System.out.println("Inserted!"); }
				else { System.out.println("Cannot insert into this position."); } 
				System.out.println();
				bkLst.displayContent();
				break;
			case 5:
				System.out.println("Give me an ISBN number to find: ");
				long isbnID1 = in.nextLong();
				in.nextLine();
				System.out.println("Give me a second one: ");
				long isbnID2 = in.nextLong();
				in.nextLine();
				Book bkEnter2 = new Book();
				System.out.println("Enter the book's title:");
				bkEnter2.title = in.nextLine();
				System.out.println("Enter the book's author:");
				bkEnter2.author = in.nextLine();
				System.out.println("Enter the book's price:");
				bkEnter2.price = in.nextDouble();
				in.nextLine();
				System.out.println("Enter the book's ISBN:");
				bkEnter2.ISBN = in.nextLong();
				in.nextLine();
				System.out.println("Enter the book's genre:");
				bkEnter2.genre = in.nextLine();
				System.out.println("Enter the book's year:");
				bkEnter2.year = in.nextInt();
				in.nextLine();
				boolean canInsert2 = bkLst.insertBetween(isbnID1, isbnID2, bkEnter2);
				if (canInsert2) { System.out.println("Inserted!"); }
				else { System.out.println("Cannot insert into this position."); } 
				bkLst.displayContent();
				break;
			case 6:
				System.out.println("Give me an ISBN number to find: ");
				long isbnSwap1 = in.nextLong();
				in.nextLine();
				System.out.println("Give me a second one: ");
				long isbnSwap2 = in.nextLong();
				in.nextLine();
				boolean canSwap = bkLst.swap(isbnSwap1, isbnSwap2);
				if (canSwap) { System.out.println("Swapped!"); }
				else { System.out.println("Cannot swap these."); } 
				bkLst.displayContent();
				break;
			case 7:
				break;
			default:
				System.out.println("Please enter a valid choice.");
				bkLst.displayContent();
				break;
			}
		} while (choice != 7);
		// termination message
		System.out.println("Thank you for using my program!");
	}
	/**
     * Trims whitespace from each element of the given array.
     *
     * @param array The array to be trimmed.
     * @return A new array with trimmed elements.
     */
	public static String[] trimArray(String[] array) {
		String[] trimmedArray = new String[array.length];
		for (int i = 0; i < trimmedArray.length; i++) {
			trimmedArray[i] = array[i].trim();
		}
		return trimmedArray;
	}
}


