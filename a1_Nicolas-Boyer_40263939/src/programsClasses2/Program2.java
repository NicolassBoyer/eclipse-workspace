package programsClasses2;

import programsClasses2.CertificateProgram;
import programsClasses2.GraduateProgram;
import programsClasses2.Program2;
import programsClasses2.SpecialProgram;
import programsClasses2.UndergraduateProgram;

// ------------------------------------------------
// Assignment 1
// Part: 2
// Written by: Nicolas Boyer 40263939
// ------------------------------------------------


import rest.Course;

// Parent class program
public class Program2 {
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
	public Program2() {
		this.name = "default";
		this.specialization = "general";
		this.totalCredits = 90;
		this.institution = "Concordia";
		this.requiredCourses = defCourseBundle;
		this.electiveCourses = defCourseBundle;
	}
	// Custom constructor
	public Program2(String name, String specialization, int totalCredits, String institution, Course[] requiredCourses, Course[] electiveCourses) {
		this.name = name;
		this.specialization = specialization;
		this.totalCredits = totalCredits;
		this.institution = institution;
		this.requiredCourses = requiredCourses;
		this.electiveCourses = electiveCourses;
	}
	// Copy constructor
	public Program2(Program2 other) {
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
class GraduateProgram extends Program2 {
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
		return (coordinator.equals(other.coordinator) && getName().equals(other.getName()) &&
		getSpecialization().equals(other.getSpecialization()) &&
		getTotalCredits() == other.getTotalCredits() &&
		getInstitution().equals(other.getInstitution()) &&
		getRequiredCourses().equals(other.getRequiredCourses()) &&
		getElectiveCourses().equals(other.getElectiveCourses()));
	}
}

// child class UndergraduateProgram
class UndergraduateProgram extends Program2 {
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
class CertificateProgram extends Program2 {
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
class SpecialProgram extends Program2 {
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
	public static void findLeastAndMostExpensiveProgram(Program2[] programs) {
        // Bubble Sort algorithm to order elements
        int n = programs.length;
        // if length is greater than 1, order elements and then print the last and first element in the array
        if (n > 1) {
	        for (int i = 0; i < n - 1; i++) {
	            for (int j = 0; j < n - i - 1; j++) {
	                if (programs[j].getTotalCredits() > programs[j + 1].getTotalCredits()) {
	                    // Swap the elements
	                    Program2 temp = programs[j];
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
	public static Object[] copyTheObjects(Object[] arrayOfObjects) {
		int n = arrayOfObjects.length;
		
		Object[] copyArray = new Object[n];
		
		// copy all elements from the inserted array to the new array
		// use instanceof in order to find what instance the object is
		for(int i = 0; i < n; i++) {
			if (arrayOfObjects[i] instanceof GraduateProgram) {
				GraduateProgram newGrad = (GraduateProgram) arrayOfObjects[i];
				copyArray[i] = new GraduateProgram(newGrad);
			} else if (arrayOfObjects[i] instanceof UndergraduateProgram) {
				UndergraduateProgram newUndergrad = (UndergraduateProgram) arrayOfObjects[i];
				copyArray[i] = new UndergraduateProgram(newUndergrad);
			} else if (arrayOfObjects[i] instanceof CertificateProgram) {
				CertificateProgram newCertificate = (CertificateProgram) arrayOfObjects[i];
				copyArray[i] = new CertificateProgram(newCertificate);
			} else if (arrayOfObjects[i] instanceof SpecialProgram) {
				SpecialProgram newSpecial = (SpecialProgram) arrayOfObjects[i];
				copyArray[i] = new SpecialProgram(newSpecial);
			} else if (arrayOfObjects[i] instanceof Program2) {
				Program2 newSpecial = (Program2) arrayOfObjects[i];
				copyArray[i] = new Program2(newSpecial);
			} else {
				copyArray[i] = new Object();
			}
		}
		return copyArray;
	}
	public static Program2[] copyTheObjects(Program2[] obj) {
		   Program2[] copy = new Program2[obj.length];
		  for(int i = 0; i<obj.length; i++) {
		   copy[i] = new Program2(obj[i]);
		}
		return copy;
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
		
		UndergraduateProgram undergrad1 = new UndergraduateProgram();
		UndergraduateProgram undergrad2 = new UndergraduateProgram(true, 80, "Education", "Teaching", 90, "Concordia", courseBundle3, courseBundle5);
		UndergraduateProgram undergrad3 = new UndergraduateProgram(undergrad2);
		GraduateProgram grad1			= new GraduateProgram();
		GraduateProgram grad2			= new GraduateProgram("Jeff", 50, "Software Engineering", "Programming", 70, "McGill", courseBundle4, courseBundle2);
		GraduateProgram grad3			= new GraduateProgram(grad2);
		CertificateProgram certificate1 = new CertificateProgram();
		CertificateProgram certificate2 = new CertificateProgram(30, 60, "Electrical Engineering", "Circuits", 60, "UQAM", courseBundle1, courseBundle5);
		SpecialProgram special1			= new SpecialProgram();
		SpecialProgram special2			= new SpecialProgram(120, 90, "Fine arts", "Digital Arts", 90, "Sherbrooke", courseBundle5, courseBundle1);
		
		Program2[] programs1 = {undergrad1, undergrad1, grad2, grad3, undergrad2, special1, special2, undergrad1, grad3, grad3,
				undergrad2, special1, special2, grad3, undergrad3, certificate2};
		
		Object[] arrayCopy = copyTheObjects(programs1);
		for (int i = 0; i < arrayCopy.length; i++) {
			System.out.println(arrayCopy[i].toString());
		}
		System.out.println();
		for (int i = 0; i < programs1.length; i++) {
			System.out.println(programs1[i].toString());
		}
	}
}

