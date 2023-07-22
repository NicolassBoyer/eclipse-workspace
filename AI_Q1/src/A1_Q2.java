
// --------------------------------------------------------------------
// Assignment 1
// Written by: Nicolas Boyer 40263939
// For COMP 248 Section W 2224 – Winter 2023 (Feb 3rd, 2023)
// --------------------------------------------------------------------

import java.util.Scanner;
public class A1_Q2 {
	
	/* The purpose of this program is to simulate a movie theater that runs movies at a ticket price of $6.99.
	 * It asks the user for the retailer of the prepaid gift card that they will use to pay as well as the amount on the card.
	 * It then informs the user how many tickets they are able to buy with the funds and the remaining money they would have if
	 * they bought the maximum amount of tickets.
	 * It asks the user to enter the amount of tickets they would like to buy.
	 * It finishes by displaying the total price and asking the user to enter the date of purchase.
	 * A receipt is then printed displaying the date, the cost of the tickets, and the remaining money on the prepaid card.
	 */

	public static void main(String[] args) {
		// add a scanner for user input
		Scanner input = new Scanner(System.in);
		
		// Displays the welcome message
		System.out.println("Welcome to the Simple Cinema Tickets Invoice Program!");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.print("Enter the prepaid gift card retailer/bank name: ");
		
		// Prompt the user to enter the retailer and then set the retailer string to uppercase letters
		String retailer = input.nextLine().toUpperCase();
		
		// Confirm the retailer by printing it out
		System.out.println("You will be using " + retailer + " gift card for your ticket(s) purchase.");
		System.out.print("Enter the amount on the gift card: ");
		
		// Prompt the user to enter the amount of money on the gift card
		double amount = input.nextDouble();
		
		// declare the amount on the gift card, and round to 2 decimal places if the user entered a double of more than 2 decrbcimal places
		System.out.printf("There is a fund of $%.2f on your prepaid " + retailer + " gift card.\n", amount);
		
		// Initialize the values for the cost of buying as many tickets as possible and how many tickets the user can buy
		// dividing the amount by the ticketCost gives a number of tickets which needs to be turned into an integer to find the ticket amount
		double ticketCost = 6.99;
		double maxTicketCost = amount/ticketCost;
		int tickets = (int) maxTicketCost;
		
		/* Initialize the money remaining after buying the maximum amount of tickets which is equal to the amount on the card 
		 * minus the amount of tickets multiplied by the price of a single ticket
		 */
		double rest = amount-(ticketCost*tickets);
		
		// Uses printf to round rest to two decimal places because money does not go further than two decimal places
		System.out.printf("Using your " + retailer + " gift card you can purchase " +  tickets + " tickets and have a balance of $%.2f on the gift card.", rest);
		System.out.print("\nEnter the amount of tickets you want to purchase: ");
		
		// Prompts the user to enter an amount of tickets and totalTicketCost calculates the price of those tickets
		int ticketAmount = input.nextInt();
		double totalTicketCost = ticketCost*ticketAmount;
		
		// Shows the user the cost of those tickets
		System.out.printf("The purchase of " + ticketAmount + " ticket(s) costs $%.2f.\n", totalTicketCost);
		
		// Subtract the ticket cost from the amount on the card
		amount -= totalTicketCost;
		
		// Shows the remaining funds on the card
		System.out.printf("The balance left on your " + retailer + " gift card is $%.2f.\n", amount);
		System.out.println("\nPlease enter your purchase info: \n");
		
		// Prompts the user to enter the day, month and year of purchase which are represented as integers
		System.out.print("Day of purchase (between 1 and 31): ");
		
		int dayOfPurchase = input.nextInt();
		
		System.out.print("Month of purchase (between 1 and 12): ");
		
		int monthOfPurchase = input.nextInt();
		
		System.out.print("Year of purchase (between 2023 and 2028): ");
		
		int yearOfPurchase = input.nextInt();
		
		input.close();
		
		// Display transaction results
		System.out.println("_______________________________________________________________________________________________________");
		System.out.println("				Cinema Concordia	 " + dayOfPurchase + "/" + monthOfPurchase + "/" + yearOfPurchase);
		System.out.println("\n\n_______________________________________________________________________________________________________\n");
		System.out.printf(ticketAmount + " Tickets											$%.2f\n", totalTicketCost);
		System.out.printf("$%.2f was redeemed from + " + retailer + " prepaid gift card.\n", totalTicketCost);
		System.out.printf(retailer + " gift card balance   									  $%.2f\n", amount);
		System.out.println("_______________________________________________________________________________________________________");
		System.out.println("Invoice generated successfully.\n\n");
		System.out.println("Thank you for using my bespoke Cinema Tickets Invoice Program!");
	}

}
