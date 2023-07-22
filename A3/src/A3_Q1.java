
// --------------------------------------------------------------------
// Assignment 3
// Written by: Nicolas Boyer 40263939
// For COMP 248 Section W 2224 – Winter 2023
// --------------------------------------------------------------------

import java.util.Scanner;
public class A3_Q1 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		// display welcome message
		System.out.println("____****_______****_______****_______****_______****___");
		System.out.println("   Welcome to the Simple Brilliant Mind Game Jackpot!");
		System.out.println("____****_______****_______****_______****_______****___\n");
		
		// initialize user age
		int userAge = 0;
		
		// Ask the user how old they are
		System.out.println("How old are you? Enter an age higher than 15 and less than 125.");
		// If userAge is not between 15 and 125, check for next integer
		while (userAge <= 15 || userAge >= 125) {
			// if user enters an integer, set userAge to that integer
			if (in.hasNextInt()) {
				userAge = in.nextInt();
			} else {
				in.next(); // discord non-integer output
			}
			if (userAge <= 15 || userAge >= 125) {
				System.out.println("Invalid age. Please enter an age higher than 15 and less than 125.");
				System.out.println("How old are you? Enter an age higher than 15 and less than 125.");
			}
		}
		
		// close input
		in.close();
		
		// display game start message
		System.out.println("\n____****_______****_______****_______****_______****___");
		System.out.println("   Your Jackpot for the Simple Brilliant Mind Game is:");
		System.out.println("____****_______****_______****_______****_______****___\n\n\n");
		
		// initialize category and score
		String category = "";
		int score = 0;
		
		// amount of cryptom generated
		int multipleAmnt = 0;
		// Loop through numbers 1 to 10
		for (int i = 1; i <= 10; i++) {
			switch (i) {
				// list all categories and scores
				case 1:
					category = "Science";
					score = 19;
				break;
				case 2:
					category = "Literature";
					score = 18;
				break;
				case 3:
					category = "Sports";
					score = 19;
				break;
				case 4:
					category = "Animals";
					score = 20;
				break;
				case 5:
					category = "Television";
					score = 19;
				break;
				case 6:
					category = "Music";
					score = 18;
				break;
				case 7:
					category = "Business";
					score = 19;
				break;
				case 8:
					category = "Geography";
					score = 19;
				break;
				case 9:
					category = "Cities";
					score = 18;
				break;
				case 10:
					category = "Opera";
					score = 19;
				break;
			}
			
			// print a message for each category and i
			System.out.println("In the score of " + category + ", the numbers that are not multiple of category " + i + " are:");
			for (int ii = 1; ii <= score; ii++) {
				// if the remainder of the category divided by i number isnt 0 add that to the total since it is not a multiple
				if (ii%i != 0) {
					System.out.print(ii + ", ");
					multipleAmnt += ii;
				}
			}	
			// if there is no value gained from the for loop, print out the corresponding message
			if (multipleAmnt == 0) {
				System.out.print("No numbers are found in this category!");
			}
			// print out the current cryptom value afterwards
			System.out.println("==>The Cryptom value " + multipleAmnt + ".\n\n");
		}
		
		// display goodbye message
		System.out.println("Thank you for using my bespoke the Simple Brilliant Mind Game Jackpot Program!");
		


	}

}
