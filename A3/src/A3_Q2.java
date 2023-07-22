
// --------------------------------------------------------------------
// Assignment 3
// Written by: Nicolas Boyer 40263939
// For COMP 248 Section W 2224 – Winter 2023
// --------------------------------------------------------------------

import java.util.Scanner;

public class A3_Q2 {
	
	public static void main(String[] args) {
		// scanner for user input
		Scanner in = new Scanner(System.in);
		
		// display welcome message
		System.out.println("=======****=======****=======****=======****=======****=====");
		System.out.println("Welcome to Concordia ACSD Exam Registration Program (CAERP):");
		System.out.println("=======****=======****=======****=======****=======****=====\n");
		
		// ask user to enter a list of courses
		System.out.println("Please enter a list of courses having ACSD students: ");
		String coursesInput = in.next();
		
		int courseCount = 1;
		
		// for every semicolon we have in the coursesInput we have an additional course.
		for (int i=0; i < coursesInput.length(); i++) {
			/* add a course count only if i is less than length. That way, a semicolon
			at the very end of the inputed courses will no add an additional course.*/
			if (coursesInput.charAt(i) == ';' && i < coursesInput.length()) {
				courseCount++;
			}
		}
		// create an array for course names and numbers based off the amount of courses we have
		String courseList[] = new String[courseCount];
		String courseNumbers[] = new String[courseCount];
		int numberOfStudents[] = new int[courseCount];
		
		// set the starting number of students for each class to 0
		for (int ii = 0; ii < numberOfStudents.length; ii++) {
			numberOfStudents[ii] = 0;
		}
		
		// beginIndex is where each substring will start
		int beginIndex = 0;
		// i is used to reference which entry in the courseList and courseNumbers array we are currently at
		int i = 0;
		
		// for every character in courses input, check for a ; and a -
		for (int ii = 0; ii < coursesInput.length(); ii++) {
			// if there is a semicolon that isn't the last string add the substring to the array
			// add a course name once it is broken with a '-'
			if (coursesInput.charAt(ii) == '-' && ii < coursesInput.length()-1) {
				courseList[i] = coursesInput.substring(beginIndex,ii);
				System.out.print(courseList[i]+ " ");
				beginIndex = ii+1;
			}
			// add a course number once it is broken with a ';' and go to the next array entry
			else if (coursesInput.charAt(ii) == ';' && ii < coursesInput.length()-1) {
				courseNumbers[i] = coursesInput.substring(beginIndex,ii);
				System.out.print(courseNumbers[i]+ " ");
				beginIndex = ii+1;
				i++;
			// if  it is the last character entered, add the last substring to the array
			} else if (ii == coursesInput.length()-1){
				// check for semicolon at the end and exclude it if there is one.
				// add the substring from the inputted courses to the courseNumbers array
				// last one added is always a number because the courses should end with a number
				if (coursesInput.charAt(coursesInput.length()-1) != ';' && coursesInput.charAt(coursesInput.length()-1) != '-') {
					courseNumbers[i] = coursesInput.substring(beginIndex,coursesInput.length());
				} else {
					courseNumbers[i] = coursesInput.substring(beginIndex,coursesInput.length()-1);
				}
				System.out.println(courseNumbers[i]);
			}
		}
		
		
		
		// display menu options
		System.out.println("===================================");
		System.out.println("| 1.	List of courses		  |");
		System.out.println("| 2.	Add a student		  |");
		System.out.println("| 3.	Add courses(s)		  |");
		System.out.println("| 4.	Display details		  |");
		System.out.println("| 0.	Exit CAERP	          |");
		System.out.println("===================================");
		
		// set initial enter value to -1 to show the while loop
		int enterValue = -1;
		// set the user's choosing to close the input to false
		boolean inputClose = false;
		
		// keeping allowing menu choices until the user chooses to exit CERP
		while (inputClose == false) {
			System.out.print("\nKindly enter a valid choice from the menu: ");
			// if the entered value isnt valid, check for next integer
			while (enterValue < 0 || enterValue > 4) {
				if (in.hasNextInt()) {
					enterValue = in.nextInt();
				} else {
					in.next(); // discard non-integer input
				}
				// if input isnt valid, ask user to input a valid choice
				if (enterValue < 0 || enterValue > 4) {
					System.out.println("\nInvalid input. Please enter a valid choice from the menu.");
				}
			}
			if (enterValue == 1) {
				// if user enters 1, display course name and number
				System.out.println("\n===================================");
				System.out.println("| Course Name-Course Number       |");
				System.out.println("===================================");
				for (int j = 0; j < courseList.length; j++) {
					System.out.println("|  " + courseList[j].toUpperCase() + "            " + courseNumbers[j] + "            |");
				}
				System.out.println("===================================");
				enterValue = -1;
			}
			if (enterValue == 2) {
				System.out.print("\nPlease enter the course name you want to add student to: ");
				// check if course entered is found
				boolean foundCourse = false;
				// have user enter course
				String courseNext = in.next();
				// try to find matching course name in courseList
				for (int j = 0; j < courseList.length; j++) {
					// if a course is found, add 1 student to that course
					if (courseNext.equals(courseList[j])) {
						numberOfStudents[j] += 1;
						// show that a student has been added to the course
						System.out.println("A student has been added to the course: " + courseList[j].toUpperCase() + "-" + courseNumbers[j]);
						foundCourse = true;
					}
				}
				if (!foundCourse) {
					// if no course matching the entered course was found, notify the user
					System.out.println("Course name : " + courseNext.toUpperCase() + " is inexistent in the list of courses.");
				}
				enterValue = -1;
			}
			if (enterValue == 3) {
				System.out.println("\nPlease enter a NEW list of courses to add to the ACSD:");
				String newCourses = in.next();
				
				// if the last character of the originally inputted courses isn't a semicolon, add one
				if (coursesInput.charAt(coursesInput.length()-1) != ';') {
					coursesInput += ";";
				}
				// add new courses and reset the courseCount to 0.
				coursesInput += newCourses;
				courseCount = 0;
				
				// count courses of the NEW string
				for (int ii=0; ii < coursesInput.length(); ii++) {
					/* add a course count only if i is less than length. That way, a semicolon
					at the very end of the inputed courses will no add an additional course.*/
					if (coursesInput.charAt(i) == ';' && i < coursesInput.length()) {
						courseCount++;
					}
				}
				// new number of students array based off the new amount of courses
				int[] newNumOfStudents = new int[courseCount];
				
				// set the starting number of students for each class to 0, for the new array
				for (int ii = 0; ii < newNumOfStudents.length; ii++) {
					newNumOfStudents[ii] = 0;
				}
				
				// copy array to new num of strings
				System.arraycopy(numberOfStudents, 0, newNumOfStudents, 0, numberOfStudents.length-1);
				
				// old variable to the new array size, keeping its previous student counts
				numberOfStudents = newNumOfStudents;
				
				// compute a similar way to the beginning
				// beginIndex is where each substring will start
				beginIndex = 0;
				// i is used to reference which entry in the courseList and courseNumbers array we are currently at
				i = 0;
				
				// for every character in courses input, check for a ; and a -
				for (int ii = 0; ii < coursesInput.length(); ii++) {
					// if there is a semicolon that isn't the last string add the substring to the array
					// add a course name once it is broken with a '-'
					if (coursesInput.charAt(ii) == '-' && ii < coursesInput.length()-1) {
						courseList[i] = coursesInput.substring(beginIndex,ii);
						System.out.print(courseList[i]+ " ");
						beginIndex = ii+1;
					}
					// add a course number once it is broken with a ';' and go to the next array entry
					else if (coursesInput.charAt(ii) == ';' && ii < coursesInput.length()-1) {
						courseNumbers[i] = coursesInput.substring(beginIndex,ii);
						System.out.print(courseNumbers[i]+ " ");
						beginIndex = ii+1;
						i++;
					// if  it is the last character entered, add the last substring to the array
					} else if (ii == coursesInput.length()-1){
						// check for semicolon at the end and exclude it if there is one.
						// add the substring from the inputted courses to the courseNumbers array
						// last one added is always a number because the courses should end with a number
						if (coursesInput.charAt(coursesInput.length()-1) != ';' && coursesInput.charAt(coursesInput.length()-1) != '-') {
							courseNumbers[i] = coursesInput.substring(beginIndex,coursesInput.length());
						} else {
							courseNumbers[i] = coursesInput.substring(beginIndex,coursesInput.length()-1);
						}
						System.out.println(courseNumbers[i]);
					}
				}
				// once the courses are added, display a confirmation language and go back to menu selection
				System.out.println("Successfully added a NEW set of courses to Concordia ACSD Exam Registration (CAERP).");
				enterValue = -1;
			}
			if (enterValue == 4) {
				System.out.println("==============================================");
				System.out.println("| Rank | #students | Course Name - Number|");
				System.out.println("==============================================");
				// temporary variables used for bubble sorting the arrays
				int tempSNum = 0;
				String tempCNum = "", tempCName = "";
				for(int ii=0; ii < numberOfStudents.length; ii++) {
					for(int j=1; j < (numberOfStudents.length-ii); j++) {
						if(numberOfStudents[j-1] > numberOfStudents[j]) {
							//Swap data/elements
							// bubble sort each array
							// bubble sort number of students
							tempSNum = numberOfStudents[j-1];
							numberOfStudents[j-1] = numberOfStudents[j];
							numberOfStudents[j] = tempSNum;
							// bubble sort course numbers
							tempCNum = courseNumbers[j-1];
							courseNumbers[j-1] = courseNumbers[j];
							courseNumbers[j] = tempCNum;
							// bubble sort course names
							tempCName = courseList[j-1];
							courseList[j-1] = courseList[j];
							courseList[j] = tempCName;
						}
					}
				}
				// show rankings for each course
				int rank = 1;
				// go through the array backwards because highest numbers are sorted at the top
				for(int ii=numberOfStudents.length-1; ii > 0; ii--) {
					// display identical rank to the one above if the student count is the same
					if (ii != numberOfStudents.length-1) {
						if (numberOfStudents[ii-1] == numberOfStudents[ii]) {
							System.out.println("|   " + (rank-1) + " |       " + numberOfStudents[ii] + "  |  " + courseList[ii] + " - " + courseNumbers[ii] + "          |");
						} else {
							// rank increase only if isnt identical to the one above
							System.out.println("|   " + rank + " |       " + numberOfStudents[ii] + "  |  " + courseList[ii] + " - " + courseNumbers[ii] + "          |");
							rank++;
						}
					} else {
						System.out.println("|   " + rank + " |       " + numberOfStudents[ii] + "  |  " + courseList[ii] + " - " + courseNumbers[ii] + "          |");
						rank++;
					}
				}
				enterValue = -1;
			}
			if (enterValue == 0) {
				// closes the input and displays goodbye message
				System.out.println("Thank you for using Concordia CAERP Exam Registration Program!");
				inputClose = true;
			}
		}
	}

}
