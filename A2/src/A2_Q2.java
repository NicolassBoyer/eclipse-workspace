// -------------------------------------------------------
// Assignment 2
// Written by: Nicolas Boyer 40263939
// For COMP 248 Section W 2224 – Winter 2023
// --------------------------------------------------------

import java.util.Scanner;
public class A2_Q2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//display a welcome message
		System.out.println("Welcome to the Dynamic Latency-Computer Program:");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++\n");
		// prompt the user to enter a weekday, mode, and data quantitity
		System.out.print("Please enter a Weekday, Mode, and Data Quantity, respectively: ");
		
		// have the user enter the weekday first
		String weekday = input.next();
		// have the user enter the mode second
		String mode = input.next();
		// have the user enter the data third
		String data = input.next();
		
		double latency = 0;
		
		// check if the lowercase version of the weekday is valid
		switch (weekday.toLowerCase()) {
			case "monday":
				switch (mode.toLowerCase()) {
				case "latency":
				case "bandwidth":
					// check if the uppercase version of the data is valid
					switch (data.toUpperCase()) {
						// after this we need to run another switch statement for day of the week
						// this is because the quantifier conversion is different for each day
						case "10GB":
							latency = ((10*Math.pow(2, 30))/(999*Math.pow(2, 20)))*1000;
						case "20PB":
							latency = ((20*Math.pow(2, 50))/(999*Math.pow(2, 20)))*1000;
						case "30ZB":
							latency = ((30*Math.pow(2, 70))/(999*Math.pow(2, 20)))*1000;
						break;
						// If isnt valid, use default, therefore display error message
						default:
							System.out.println("Error: invalid value entered for the 'Data Quantity' variable. Kindly retry with a valid input.");
						break;
					}
				break;
				// If isnt valid, use default, therefore display error message
				default:
					System.out.println("Error: invalid value entered for the 'Mode' variable. Kindly retry with a valid input.");
				break;
			}
				// switch within case
				// mode to uppercase
				// if latency or bandwidth
				// calaculate latency or bandwidth
				// if latency data*2^whatever = latency*data*2^whatever
				
			case "tueday":
			case "wednesday":
			case "thursday":
			case "friday":
			case "saturday":
			case "sunday":
			break;
			default:
				// If isnt valid, use default, therefore display error message
				System.out.println("Error: invalid value entered for the 'Weekday' variable. Kindly retry with a valid input.");
			break;
		}

		
		// check if the lowercase version of the mode is valid
		switch (mode.toLowerCase()) {
			case "latency":
			case "bandwidth":
				// check if the uppercase version of the data is valid
				switch (data.toUpperCase()) {
					// after this we need to run another switch statement for day of the week
					// this is because the quantifier conversion is different for each day
					case "10GB":
						
					case "20PB":
						
					case "30ZB":
						
					break;
					// If isnt valid, use default, therefore display error message
					default:
						System.out.println("Error: invalid value entered for the 'Data Quantity' variable. Kindly retry with a valid input.");
					break;
				}
			break;
			// If isnt valid, use default, therefore display error message
			default:
				System.out.println("Error: invalid value entered for the 'Mode' variable. Kindly retry with a valid input.");
			break;
		}
		
		
		
		
		System.out.println("Latency incurred in transmitting " + data + " of data, over Project-S microwave network link, is: " + latency + "ms\n");
		System.out.println("Once again, thanks for your contribution to Project-S.");
		
	}
}
