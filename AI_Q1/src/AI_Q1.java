
// --------------------------------------------------------------------
// Assignment 1
// Written by: Nicolas Boyer 40263939
// For COMP 248 Section W 2224 – Winter 2023 (Feb 3rd, 2023)
// --------------------------------------------------------------------

import java.util.Scanner;
public class AI_Q1 {
	
	/* The purpose of this program is to determine the change that a 3rd millennium scalper would receive selling tickets to a
	 * grimvalor game. The scalper pays with a Pesico, which translates to 7500 in Cryptom. The program calculates the change
	 * given to the scalper maximizing larger denominations of Cryptom.
	 */
	
	
	public static void main(String[] args) {
		// Create a scanner for user input
		Scanner input = new Scanner(System.in);
		
		// Prints out a welcome message
		System.out.println("Welcome to the Crypto Change Program:");
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.print("Please enter a valid price for a ticket in Cryptom coins: ");
		
		// User's input
		int price = input.nextInt();
		input.close();
		// The change received is equivalent to how much is equivalent to what is given (a Pesico, so 7500 minus the price)
		int change = 7500 - price;
		
		// Initialization for the value of each denomination of their value in the Cryptom that is given in change
		// The remainder of division is used to calculate the lower denominations so that the higher ones are prioritized
		// bitomRem, for example, is the remains after converting as much Cryptom to bitom as possible
		
		int bitom = change/500;
		int bitomRem = change%500;
		
		int ditom = bitomRem/200;
		int ditomRem = bitomRem%200;
		
		int zitom = ditomRem/50;
		int zitomRem = ditomRem%50;
		
		int cryptom = zitomRem;
		
		// Print out results
		System.out.println("\nYou bought a ticket for " + price + " Cryptom, and gave me a Pesico, so your change is:");
		System.out.println(bitom + " Bitom");
		System.out.println(ditom + " Ditom");
		System.out.println(zitom + " Zitom");
		System.out.println(cryptom + " Cryptom\n\n");
		System.out.println("Thank you for using my bespoke Crypto Change Program!\n");
		System.out.println("Enjoy the Game!");
	}

}
