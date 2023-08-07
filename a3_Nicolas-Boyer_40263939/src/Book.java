import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class Book {
	String title;
	String author;
	double price;
	long ISBN;
	String genre;
	int year;
	
}

class BookList {
	Node head;
	
	public BookList() {
		head = null;
	}
	public void addToStart(Book b) {
		if (head != null) {
			head.next = head.b;
		}
		head.b = b;
	}
	public void storeRecordsByYear(int yr) {
		

	}
	public boolean insertBefore(long isbn, Book b) {
		
	}
	public boolean insetBetween(long isbn1, long isbn2, Book b) {
		
	}
	public void displayContent() {
		
	}
	public void delConsecutiveRepeatedRecords() {
		
	}
	public BookList extractAuthList(String aut) {
		
	}
	public boolean swap(long isbn1, long isbn2) {
		
	}
	
	private class Node {
		private Book b;
		private Book next;
	}
}

class Driver {
	public static void main(String[] args) {
		ArrayList<Book> arrLst = new ArrayList<Book>();
		BookList bkLst = new BookList();
		
		// Creates scanner and printwriter objects who need to be null in order to catch exceptions when they are defined.
		Scanner booksIn =  null;
		PrintWriter yearValidWriter = null;
		PrintWriter yearErrorWriter = null;
		
		File yearValid = new File("YearValid.txt");
		File yearError = new File("YearErr.txt");

		try {
			// Creates a new scanner to get the file names from
			booksIn = new Scanner(new FileInputStream("Books.txt"));
			yearValidWriter = new PrintWriter(new FileOutputStream(yearValid));
			yearErrorWriter = new PrintWriter(new FileOutputStream(yearError));
		} catch (FileNotFoundException e){
			System.out.println("Cannot find the name of one of these files");
		}
		
		int bookCount = 0;
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
			
			if (currentBook.year > 2023 || currentBook.year < 1900) {
				arrLst.add(currentBook);
			} else {
				bkLst.addToStart(currentBook);
			}
		}
		
		for (int i = 0; i < lines.length; i++){
			
		}	
		
		
		System.out.println("1)	Give me a year # and I would extract all records of that year and store them in a file for that year");
		System.out.println("2)	Ask me to delete all consecutive repeated records");
		System.out.println("3)	Give me an author name and I will create a new list with the records of this author and display them;");
		System.out.println("4)	Give me an ISBN number and a Book object, and I will insert Node with the book before the record with this ISBN;");
		System.out.println("5)	Give me 2 ISBN numbers and a Book object, and I will insert a Node between them, if I find them!");
		System.out.println("6)	Give me 2 ISBN numbers and I will swap them in the list for rearrangement of records; of course if they exist!");
		System.out.println("7)	Tell me to STOP TALKING.");
	}
	
	public static String[] trimArray(String[] array) {
		String[] trimmedArray = new String[array.length];
		for (int i = 0; i < trimmedArray.length; i++) {
			trimmedArray[i] = array[i].trim();
		}
		return trimmedArray;
	}
}


