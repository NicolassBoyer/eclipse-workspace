// -------------------------------------------------------
// Assignment 2
// Written by: Nicolas Boyer 40263939
// For COMP 248 Section W 2224 – Winter 2023
// --------------------------------------------------------

import java.util.Scanner;
public class A2_Q1 {

	/*
	 * The purpose of this program is to monitor point-to-point connections between computing nodes to ensure that every
	 * communication/network link is alive with reference to its defined bandwidth on a given communication medium
	 */
	
	public static void main(String[] args) {
		//create a scanner for the user's input
		Scanner input = new Scanner(System.in);
		
		//use these booleans to verify when numbers and characters are correctly entered
		boolean charCorrect = true;
		boolean numCorrect = false;
		
		//Welcome message and prompt user to enter bandwidth
		System.out.println("Welcome to the Static Latency-Computer Program:");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++\n");
		System.out.print("Please enter the bandwidth, in {n}{x}bps format, for the network link: ");
		
		// bandwidth is the user's next line
		String bandwidth = input.nextLine();
		// bwLen is the length of bandwidth
		int bwLen = bandwidth.length();
		// bwPrefix is the bandwidth's character (this works IF the format ends in bps, so equal to the length minus 4)
		char bwPrefix = bandwidth.charAt(bwLen-4);
		/* bwNumLen is the length of the number at the beginning, we find this by removing the 4 characters at the end being
		 * the prefix and the "bps"
		 */
		int bwNumLen = bwLen - 4;
		// bwNum is the bandwidth number, which starts at the beginning and ends at the number's length
		String bwNum = bandwidth.substring(0,bwNumLen);
		//bps should be the end of what the user entered
		String bps = "bps";
		
		// check if you can parse the number into an integer (it is a string when entered) if yes, it is a valid integer
		try {
			Integer.parseInt(bwNum);
			numCorrect = true;
		} catch (NumberFormatException e) {
			numCorrect = false;
		}
		
		int power = 0;
		
		if (numCorrect) {
			// depending on the prefix the power of the bytes will vary
		switch (bwPrefix) {
			case 'K':
				power = 10;
			break;
			case 'M':
				power = 20;
			break;
			case 'G':
				power = 30;
			break;
			case 'T':
				power = 40;
			break;
			case 'P':
				power = 50;
			break;
			case 'E':
				power = 60;
			break;
			case 'Z':
				power = 70;
			break;
			case 'Y':
				power = 80;
			break;
			default:
				charCorrect = false;
			break;
			}
		}
		
		// convert to bits
		double bwNumBits = 0;
		if (numCorrect == true && charCorrect == true) {
			bwNumBits = Double.parseDouble(bwNum)*Math.pow(2, power)*8;
		}
		
		// if the number or the character are not valid or the end of the string is not "bps", an error is thrown
		if (numCorrect == false || charCorrect == false || !bandwidth.substring(bwLen-3, bwLen).equals(bps)) {
			System.out.println("Invalid input for bandwidth; please re-run and enter the bandwidth in {n}{x}bps format.");
		} else {
			// if the bandwidth is valid, prompt the user to enter the source and destination ips
			System.out.print("Please enter the source IP address: ");
			
			int part1_ip1 = input.nextInt();
			int part2_ip1 = input.nextInt();
			int part3_ip1 = input.nextInt();
			int part4_ip1 = input.nextInt();
			
			System.out.print("Please enter the destination IP address: ");
			
			int part1_ip2 = input.nextInt();
			int part2_ip2 = input.nextInt();
			int part3_ip2 = input.nextInt();
			int part4_ip2 = input.nextInt();
			
			// check if the ips entered are valid (all parts are from 0 to 250, not higher not lower)
			if (part1_ip1 >= 0 && part1_ip1 <= 255 && part2_ip1 >= 0 && part2_ip1 <= 255 && part3_ip1 >= 0 && part3_ip1 <= 255
					&& part4_ip1 >= 0 && part4_ip1 <= 255 && part1_ip2 >= 0 && part1_ip2 <= 255 && part2_ip2 >= 0 && part2_ip2 <= 255
					&& part3_ip2 >= 0 && part3_ip2 <= 255
					&& part4_ip2 >= 0 && part4_ip2 <= 255) {
					System.out.print("Please enter data amount, in {n}{y}B format, for transmission over the network link: ");
					// Transmission is the user's next input
					String transmission = input.next();
					// traLen is the length of the user's next input
					int traLen = transmission.length();
					// The prefix entered by the user comes before the end of the string character B, so it is equal to length minus 1
					char traPrefix = transmission.charAt(traLen-2);
					// There are only 2 characters that arent a number, so the rest is the number n, which is equal to the length minus 2
					int traNumLen = traLen - 2;
					// traNum is the transmission number, which starts at the beginning and ends at the number's length
					String traNum = transmission.substring(0,traNumLen);
					
					// same try statement as before but for the transmission number this time
					try {
						Integer.parseInt(traNum);
						numCorrect = true;
					} catch (NumberFormatException e) {
						numCorrect = false;
					}
					
					charCorrect = true;
					
					// depending on the prefix the power of the bytes will vary
					switch (traPrefix) {
					case 'K':
						power = 10;
					break;
					case 'M':
						power = 20;
					break;
					case 'G':
						power = 30;
					break;
					case 'T':
						power = 40;
					break;
					case 'P':
						power = 50;
					break;
					case 'E':
						power = 60;
					break;
					case 'Z':
						power = 70;
					break;
					case 'Y':
						power = 80;
					break;
					default:
						charCorrect = false;
					break;
					}
					
					// convert to bits
					double transNumBits = 0;
					if (numCorrect == true && charCorrect == true) {
						transNumBits = Double.parseDouble(bwNum)*Math.pow(2, power)*8;
					}
					
					// check to throw an error if conditions aren't met
					if (numCorrect == false || charCorrect == false || transmission.charAt(traLen-1) != 'B') {
						// throw error 
						System.out.println("Invalid input for the amount of data, please retry with the data amount in {n}{y}B format.");
					} else {
						//data entered is valid
						//ip parts put together
						String sourceIP = part1_ip1 + "." + part2_ip1 + "." + part3_ip1 + "." + part4_ip1;
						String destinationIP = part1_ip2 + "." + part2_ip2 + "." + part3_ip2 + "." + part4_ip2;
					
						
						//calculate latency in milliseconds
						double latency = (transNumBits/bwNumBits)*1000;

						//Print out the results of the program
						System.out.println("Latency " + "(" + sourceIP + " --> " + destinationIP + ") = " + latency + "ms");
					}
					
					
				}  else if (!(part1_ip1 >= 0) || !(part1_ip1 <= 255) || !(part2_ip1 >= 0) || !(part2_ip1 <= 255) || !(part3_ip1 >= 0) || !(part3_ip1 <= 255)
						|| !(part4_ip1 >= 0) || !(part4_ip1 <= 255)) {
					// if source ip isnt valid, display an error
					System.out.println("Error: Your entry for source IP address is incorrect. Kindly retry with valid inputs.");
				} else {
					// if destination ip isnt valid, display an error
					System.out.println("Error: Your entry for destination IP address is incorrect. Kindly retry with valid inputs.");
				}
		}
		//close the input
		input.close();
		
		//Display program termination message
		System.out.println("\nThank you for your contribution to Project-S.");
	}
}
