package programsClasses;

// ------------------------------------------------
// Assignment 1
// Part: 1
// Written by: Nicolas Boyer 40263939
// ------------------------------------------------


import rest.Course;

// Parent class program
public class Program {
	// instances variables
	private String name;
	private String specialization;
	private int totalCredits;
	private String institution;
	private Course[] requiredCourses;
	private Course[] electiveCourses;
	Course defCourse = new Course();
	Course[] defCourseBundle = {defCourse};
	
	
	// Default constructor
	public Program() {
		this.name = "default";
		this.specialization = "general";
		this.totalCredits = 90;
		this.institution = "Concordia";
		this.requiredCourses = defCourseBundle;
		this.electiveCourses = defCourseBundle;
	}
	// Custom constructor
	public Program(String name, String specialization, int totalCredits, String institution, Course[] requiredCourses, Course[] electiveCourses) {
		this.name = name;
		this.specialization = specialization;
		this.totalCredits = totalCredits;
		this.institution = institution;
		this.requiredCourses = requiredCourses;
		this.electiveCourses = electiveCourses;
	}
	// Copy constructor
	public Program(Program other) {
		this.name = other.name;
		this.specialization = other.specialization;
		this.totalCredits = other.totalCredits;
		this.institution = other.institution;
		this.requiredCourses = other.requiredCourses;
		this.electiveCourses = other.electiveCourses;
	}
	// Accessor methods
	public String getName() {
		return name;
	}
	public String getSpecialization() {
		return specialization;
	}
	public int getTotalCredits() {
		return totalCredits;
	}
	public String getInstitution() {
		return institution;
	}
	public Course[] getRequiredCourses() {
		return requiredCourses;
	}
	public Course[] getElectiveCourses() {
		return electiveCourses;
	}
	// Mutator methods
	public void setName(String name) {
		this.name = name;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public void setTotalCredits(int totalCredits) {
		this.totalCredits = totalCredits;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public void setRequiredCourses(Course[] requiredCourses) {
		this.requiredCourses = requiredCourses;
	}
	public void setElectiveCourses(Course[]	electiveCourses) {
		this.electiveCourses = electiveCourses;
	}
	// toString method
	public String toString() {
		// create Strings for both required courses and elective courses containing all the toString methods of each course in their arrays
		int n = getRequiredCourses().length;
		String requiredCoursesStr = "";
		for (int i = 0; i < n; i++) {
			requiredCoursesStr += getRequiredCourses()[i].toString();
			if (i < n - 1) {
				requiredCoursesStr += ", ";
			}
		}
		int j = getElectiveCourses().length;
		String electiveCoursesStr = "";
		for (int i = 0; i < j; i++) {
			electiveCoursesStr += getElectiveCourses()[i].toString();
			if (i < j - 1) {
				electiveCoursesStr += ", ";
			}
		}
		
		return "name: " + getName() + ", specialization: " + getSpecialization() + ", total credits: " + getTotalCredits()
		+ ", institution: " + getInstitution() + ", required courses: " + requiredCoursesStr + ", elective courses: " + electiveCoursesStr;
	}
}

// child class GraduateProgram
class GraduateProgram extends Program {
	// instance variables
	private String coordinator;
	private static int creditCost;
	// default constructor
	public GraduateProgram() {
		super();
		this.coordinator = "Jamie";
		creditCost = 60;
	}
	// custom constructor
	public GraduateProgram(String coordinator, int cost, String name, String specialization, int totalCredits, String institution, Course[] requiredCourses, Course[] electiveCourses) {
		super(name, specialization, totalCredits, institution, requiredCourses, electiveCourses);
		this.coordinator = coordinator;
		creditCost = cost;
	}
	// copy constructor
	public GraduateProgram(GraduateProgram other) {
		super(other);
		this.coordinator = other.coordinator;
	}
	// accessor methods
	public String getCoordinator() {
		return coordinator;
	}
	public int getCreditCost()	{
		return creditCost;
	}
	// mutator methods
	public void setCoordinator(String coordinator) {
		this.coordinator = coordinator;
	}
	public void setCreditCost(int cost) {
		creditCost = cost;
	}
	
	// toString method
	public String toString() {
		// create Strings for both required courses and elective courses containing all the toString methods of each course in their arrays
		int n = getRequiredCourses().length;
		String requiredCoursesStr = "";
		for (int i = 0; i < n; i++) {
			requiredCoursesStr += getRequiredCourses()[i].toString();
			if (i < n - 1) {
				requiredCoursesStr += ", ";
			}
		}
		int j = getElectiveCourses().length;
		String electiveCoursesStr = "";
		for (int i = 0; i < j; i++) {
			electiveCoursesStr += getElectiveCourses()[i].toString();
			if (i < j - 1) {
				electiveCoursesStr += ", ";
			}
		}
		
		return "coordinator: " + coordinator + ", credit cost: " + creditCost + ", name: " + getName() + ", specialization: " + getSpecialization() + ", total credits: " + getTotalCredits()
		+ ", institution: " + getInstitution() + ", required courses: " + requiredCoursesStr + ", elective courses: " + electiveCoursesStr;
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
		GraduateProgram other = (GraduateProgram) obj;
		
		// check all variables to see if they are equal and return the result
		return (coordinator.equals(other.coordinator) && super.equals(other));
	}
}

// child class UndergraduateProgram
class UndergraduateProgram extends Program {
	// instance variables
	private boolean accredited;
	private static int creditCost;
	
	// default constructor
	public UndergraduateProgram() {
		super();
		this.accredited = false;
		creditCost = 60;
	}
	// custom constructor
	public UndergraduateProgram(boolean accredited, int cost, String name, String specialization, int totalCredits, String institution, Course[] requiredCourses, Course[] electiveCourses) {
		super(name, specialization, totalCredits, institution, requiredCourses, electiveCourses);
		this.accredited = accredited;
		creditCost = cost;
	}
	// copy constructor
	public UndergraduateProgram(UndergraduateProgram other) {
		super(other);
		this.accredited = other.accredited;
	}
	// accessor methods
	public boolean getAccredited() {
		return accredited;
	}
	public int getCreditCost() {
		return creditCost;
	}
	// mutator methods
	public void setAccredited(boolean accredited) {
		this.accredited = accredited;
	}
	public void setCreditCost(int cost) {
		creditCost = cost;
	}
	// toString method
	public String toString() {
		// create Strings for both required courses and elective courses containing all the toString methods of each course in their arrays
		int n = getRequiredCourses().length;
		String requiredCoursesStr = "";
		for (int i = 0; i < n; i++) {
			requiredCoursesStr += getRequiredCourses()[i].toString();
			if (i < n - 1) {
				requiredCoursesStr += ", ";
			}
		}
		int j = getElectiveCourses().length;
		String electiveCoursesStr = "";
		for (int i = 0; i < j; i++) {
			electiveCoursesStr += getElectiveCourses()[i].toString();
			if (i < j - 1) {
				electiveCoursesStr += ", ";
			}
		}
		
		return "accredited: " + accredited + ", credit cost: " + creditCost + ", name: " + getName() + ", specialization: " + getSpecialization() + ", total credits: " + getTotalCredits()
		+ ", institution: " + getInstitution() + ", required courses: " + requiredCoursesStr + ", elective courses: " + electiveCoursesStr;
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
		UndergraduateProgram other = (UndergraduateProgram) obj;
		
		// check all variables to see if they are equal and return the result
		return (accredited == other.accredited && getName().equals(other.getName()) &&
				getSpecialization().equals(other.getSpecialization()) &&
				getTotalCredits() == other.getTotalCredits() &&
				getInstitution().equals(other.getInstitution()) &&
				getRequiredCourses().equals(other.getRequiredCourses()) &&
				getElectiveCourses().equals(other.getElectiveCourses()));
	}
}

// child class CertificateProgram
class CertificateProgram extends Program {
	// instance variables
	private int capacity;
	private static int creditCost;
	
	// default constructor
	public CertificateProgram() {
		super();
		this.capacity = 30;
		creditCost = 60;
	}
	// custom constructor
	public CertificateProgram(int capacity, int cost, String name, String specialization, int totalCredits, String institution, Course[] requiredCourses, Course[] electiveCourses) {
		super(name, specialization, totalCredits, institution, requiredCourses, electiveCourses);
		this.capacity = capacity;
		creditCost = cost;
	}
	// copy constructor
	public CertificateProgram(CertificateProgram other) {
		super(other);
		this.capacity = other.capacity;
	}
	// accessor methods
	public int getCapacity() {
		return capacity;
	}
	public int getCreditCost() {
		return creditCost;
	}
	// mutator methods
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public void setCreditCost(int cost) {
		creditCost = cost;
	}
	// toString method
	public String toString() {
		// create Strings for both required courses and elective courses containing all the toString methods of each course in their arrays
		int n = getRequiredCourses().length;
		String requiredCoursesStr = "";
		for (int i = 0; i < n; i++) {
			requiredCoursesStr += getRequiredCourses()[i].toString();
			if (i < n - 1) {
				requiredCoursesStr += ", ";
			}
		}
		int j = getElectiveCourses().length;
		String electiveCoursesStr = "";
		for (int i = 0; i < j; i++) {
			electiveCoursesStr += getElectiveCourses()[i].toString();
			if (i < j - 1) {
				electiveCoursesStr += ", ";
			}
		}
		
		return "capacity: " + capacity + ", credit cost: " + creditCost + ", name: " + getName() + ", specialization: " + getSpecialization() + ", total credits: " + getTotalCredits()
		+ ", institution: " + getInstitution() + ", required courses: " + requiredCoursesStr + ", elective courses: " + electiveCoursesStr;
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
		CertificateProgram other = (CertificateProgram) obj;
		
		// check all variables to see if they are equal and return the result
		return (capacity == other.capacity && getName().equals(other.getName()) &&
				getSpecialization().equals(other.getSpecialization()) &&
				getTotalCredits() == other.getTotalCredits() &&
				getInstitution().equals(other.getInstitution()) &&
				getRequiredCourses().equals(other.getRequiredCourses()) &&
				getElectiveCourses().equals(other.getElectiveCourses()));
	}
}

// child class SpecialProgram
class SpecialProgram extends Program {
	// instance variables
	private int duration;
	private static int creditCost;
	
	// default constructor
	public SpecialProgram() {
		super();
		this.duration = 30;
		creditCost = 60;
	}
	// custom constructor
	public SpecialProgram(int duration, int cost, String name, String specialization, int totalCredits, String institution, Course[] requiredCourses, Course[] electiveCourses) {
		super(name, specialization, totalCredits, institution, requiredCourses, electiveCourses);
		this.duration = duration;
		creditCost = cost;
	}
	// copy constructor
	public SpecialProgram(SpecialProgram other) {
		super(other);
		this.duration = other.duration;
	}
	// accessor methods
	public int getDuration() {
		return duration;
	}
	public int getCreditCost() {
		return creditCost;
	}
	// mutator methods
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public void setCreditCost(int cost) {
		creditCost = cost;
	}
	// toString method
	public String toString() {
		// create Strings for both required courses and elective courses containing all the toString methods of each course in their arrays
		int n = getRequiredCourses().length;
		String requiredCoursesStr = "";
		for (int i = 0; i < n; i++) {
			requiredCoursesStr += getRequiredCourses()[i].toString();
			if (i < n - 1) {
				requiredCoursesStr += ", ";
			}
		}
		int j = getElectiveCourses().length;
		String electiveCoursesStr = "";
		for (int i = 0; i < j; i++) {
			electiveCoursesStr += getElectiveCourses()[i].toString();
			if (i < j - 1) {
				electiveCoursesStr += ", ";
			}
		}
		
		return "duration: " + duration + ", credit cost: " + creditCost + ", name: " + getName() + ", specialization: " + getSpecialization() + ", total credits: " + getTotalCredits()
		+ ", institution: " + getInstitution() + ", required courses: " + requiredCoursesStr + ", elective courses: " + electiveCoursesStr;
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
		SpecialProgram other = (SpecialProgram) obj;
		
		// check all variables to see if they are equal and return the result
		return duration == other.duration && getName().equals(other.getName()) &&
				getSpecialization().equals(other.getSpecialization()) &&
				getTotalCredits() == other.getTotalCredits() &&
				getInstitution().equals(other.getInstitution()) &&
				getRequiredCourses().equals(other.getRequiredCourses()) &&
				getElectiveCourses().equals(other.getElectiveCourses());
	}
}

// Driver class
class Driver {
	// finds most and least expensive program in totalCredits 
	public static void findLeastAndMostExpensiveProgram(Program[] programs) {
        // Bubble Sort algorithm to order elements
        int n = programs.length;
        // if length is greater than 1, order elements and then print the last and first element in the array
        if (n > 1) {
	        for (int i = 0; i < n - 1; i++) {
	            for (int j = 0; j < n - i - 1; j++) {
	                if (programs[j].getTotalCredits() > programs[j + 1].getTotalCredits()) {
	                    // Swap the elements
	                    Program temp = programs[j];
	                    programs[j] = programs[j + 1];
	                    programs[j + 1] = temp;
	                }
	            }
	        }
	        System.out.println(programs[0]);
	        System.out.println(programs[n-1]);
	    // if there is only one element in the array, it is both the most and least expensive, so print the only element
        } else if (n == 1) {
        	System.out.println(programs[0]);
        // if there are no programs in the array, display an error message
        } else {
        	System.out.println("There are no programs in this array.");
        }
	}
	public static void main(String[] args) {
		// Create new courses
		Course defCourse = new Course();
		Course programming = new Course("Programming", 3);
		Course programming2 = new Course(programming);
		Course teaching = new Course("Teaching", 4);
		Course hardware = new Course("System Hardware", 3);
		Course photoshop = new Course("Intro to Photoshop", 3);
		Course drawing = new Course("Intro to drawing", 3);
		
		// create course bundles to serve as arrays for elective and required courses
		Course[] courseBundle1 = {defCourse, programming, programming2};
		Course[] courseBundle2 = {defCourse, photoshop, drawing};
		Course[] courseBundle3 = {defCourse, teaching};
		Course[] courseBundle4 = {defCourse, programming, hardware};
		Course[] courseBundle5 = {programming, teaching, drawing};
		
		// Create new objects from the 4 subclasses and display their information
		System.out.println("Here is the information on all current programs: ");
		UndergraduateProgram undergrad1 = new UndergraduateProgram();
		UndergraduateProgram undergrad2 = new UndergraduateProgram(true, 80, "Education", "Teaching", 90, "Concordia", courseBundle3, courseBundle5);
		UndergraduateProgram undergrad3 = new UndergraduateProgram(undergrad2);
		System.out.println(undergrad1);
		System.out.println(undergrad2);
		System.out.println(undergrad3);
		GraduateProgram grad1			= new GraduateProgram();
		GraduateProgram grad2			= new GraduateProgram("Jeff", 50, "Software Engineering", "Programming", 70, "McGill", courseBundle4, courseBundle2);
		GraduateProgram grad3			= new GraduateProgram(grad2);
		System.out.println(grad1);
		System.out.println(grad2);
		System.out.println(grad3);
		CertificateProgram certificate1 = new CertificateProgram();
		CertificateProgram certificate2 = new CertificateProgram(30, 60, "Electrical Engineering", "Circuits", 60, "UQAM", courseBundle1, courseBundle5);
		System.out.println(certificate1);
		System.out.println(certificate2);
		SpecialProgram special1			= new SpecialProgram();
		SpecialProgram special2			= new SpecialProgram(120, 90, "Fine arts", "Digital Arts", 90, "Sherbrooke", courseBundle5, courseBundle1);
		System.out.println(special1);
		System.out.println(special2);
		
		// testing the equals method
		System.out.println("");
		System.out.println("Testing equals method with undergrad2 and undergrad3...");
		if (undergrad2.equals(undergrad3)) {
			System.out.println("They are equal!");
		} else {
			System.out.println("These are not equal.");
		}
		System.out.println("Testing equals method with undergrad3 and grad2...");
		if (undergrad3.equals(grad2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println("These are not equal.");
		}
		System.out.println("Testing equals method with special1 and special2...");
		if (special1.equals(special2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println("These are not equal.");
		}
		
		// create an ordinary program object to include in the first array but not the second
		Program defProgram = new Program();
		
		// initialize arrays of programs
		// no Program objects in the second array, only the first
		Program[] programs1 = {undergrad1, undergrad1, grad2, grad3, undergrad2, special1, special2, defProgram, grad3, grad3,
				undergrad2, special1, special2, grad3, defProgram, certificate2};
		Program[] programs2 = {undergrad2, undergrad2, grad2, undergrad2, grad1, grad1, grad1, grad3, special1, grad1,
				special2, special2, certificate1, certificate2, certificate1};
		
		// find the most and least expensive programs in both arrays
		System.out.println("");
		System.out.println("Finding most and least expensive programs in programs1...");
		System.out.println("The most and least expensive programs are: ");
		findLeastAndMostExpensiveProgram(programs1);
		System.out.println("");
		System.out.println("Finding most and least expensive programs in programs2...");
		System.out.println("The most and least expensive programs are: ");
		findLeastAndMostExpensiveProgram(programs2);
		
		// closing message
		System.out.println("");
		System.out.println("The program has been terminated. Goodbye!");
	}
}

