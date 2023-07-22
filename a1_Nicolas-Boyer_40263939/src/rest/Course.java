package rest;

// ------------------------------------------------
// Assignment 1
// Part: 1
// Written by: Nicolas Boyer 40263939
// ------------------------------------------------

// Course class
public class Course {
	// instance variables
	private String name;
	private int credits;
	
	// default constructor
	public Course() {
		this.name = "Course";
		this.credits = 3;
	}
	// custom constructor
	public Course(String name, int credits) {
		this.name = name;
		this.credits = credits;
	}
	// copy constructor
	public Course(Course other) {
		this.name = other.name;
		this.credits = other.credits;
	}
	// accessor methods
	public String getName() {
		return name;
	}
	public int getCredits() {
		return credits;
	}
	// mutator methods
	public void setName(String name) {
		this.name = name;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	// toString method
	public String toString() {
		return "Course Name: " + name + ", Credits: " + credits;
	}
	// equals method
	public boolean equals(Object obj) {
		// checks if same object
		if (this == obj) {
			return true;
		} 
		// checks if the classes are the same or that the object being compared is null
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		// if above conditions arent met, cast the object
		Course other = (Course) obj;
		// check all variables to see if they are equal and return the result
		return credits == other.credits && (name != null ? name.equals(other.name) : other.name == null);
	}
		
}
