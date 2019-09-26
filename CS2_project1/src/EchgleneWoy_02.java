/*
 * EchgleneWoy_02 this class is to test both the Student and GradeItem classes

 * Echglene Woy & Serena Zarate
 * Project 2
 * Eclipse
 * Zealot: a fervent and even militant proponent of something
 * "One day you'll leave this world behind so live a life you will remember" - Avicii
 * 	
 */

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class EchgleneWoy_02 {
	
	private static Student student1;	 // New Student object from test 1
	private static Student student2;	 // New Student object from test 2
	private static GradeItem gradeItem1; // New GradeItem object from test 1 
	private static GradeItem gradeItem2; // New GradeItem object from test 2

	//private final static String INPUT_FILENAME;
	

	public static void main(String[] args) throws FileNotFoundException {
		
		
		// Running Test 1A
		test1A();
		System.out.println("");
		// Running Test 1B
		test1B();
		System.out.println("");		
		
		
		try {
	    // Will open a new input file named 'Project_02_Input01' 
		File file = new File("C:\\Users\\Echglene\\eclipse-workspace\\CS2_project1\\src\\Project_02_Input01.txt");
	
		Scanner scan = new Scanner(file);
		// Reading through the input file
		String[] splitString;
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			splitString = line.split(",");
			
			
			if(splitString[0].contains("STUDENT")) {
				// Will call this method if input file contains "STUDENT"
				processStudentData(splitString);
				System.out.println(student2);
				System.out.println("");
			}
			
			else if(splitString[0].contains("GRADE ITEM")) {
				// Will call this method if input file contains "GRADE ITEM"
				processGradeItemData(splitString);
				System.out.println(gradeItem2);
			}
		
			} // End while statement
		scan.close();
		
		}
		catch(FileNotFoundException e) {
			System.err.println("\n" + "Text file cannot be found.");
		} // End catch
		
		System.out.println("");
		System.out.println("**************************************************************");

		
		System.out.println("");
		// Running Test 3A
		equalsStudent(student1, student2);
		System.out.println("");
		// Running Test 3B
		equalsGrade(gradeItem1, gradeItem2);
		System.out.println("");
		System.out.println("************************************************");
		
		
	} // End Main method
	
/******************************************************************/
		
	/** Test 1A checks student constructor with the parameters
	 * for each field and the toString() method.
	 * 
	 */
	public static void test1A() throws FileNotFoundException {
		System.out.println("Running Test 1A:");
		student1 = new Student("900949920", "Echglene", "Woy", "ewoy@msudenver.edu"); // Hard coding student1 object
		System.out.println(student1.toString());

		} // End test 1A
		
	/** Test 1B
	 *  Checks gradeItem constructor with the parameters
	 *  for each field and the toString() method.
	 */
	public static void test1B() throws FileNotFoundException {
		System.out.print("Running Test 1B:");
		gradeItem1 = new GradeItem("123456789", 1, "Math", "HW", "9/12/19", 100, 98); // Hard coding gradeItem1 object 
		System.out.println(gradeItem1.toString());
		System.out.println("");
		System.out.println("**************************************************************");
	} // End test 1B
	
/******************************************************************/
	
	/** Test 2A
	 * processStudentData will initialize a new student object 
	 * with the data read from the input file.
	 * @param splitString[] array that holds the strings parsed from the input file.
	 * @throws IllegalArgumentException
	 */
	public static void processStudentData(String[] splitString) throws IllegalArgumentException {
		System.out.println("Running Test 2A:");
		
		if(splitString[1].equals("ADD")) {
			
				 student2 = new Student(splitString[2], splitString[3], splitString[4], splitString[5]);
				 
			}
			else {
				
				throw new IllegalArgumentException("The student data does not contain 'ADD' in the textfile"  
												   + String.join(" ", splitString));
			}
		
		try {
			
			student2 = new Student(splitString[2], splitString[3], splitString[4], splitString[5]);
			
			}
			catch(IllegalArgumentException e) {
					System.err.println("One of the arguments in the student constructor has an illegal argument.");
				} // End catch
				
			
			
			
	} // End processStudentData

	
/******************************************************************/
	
	/** Test 2B
	 * processGradeItemData will initialize a new GradeItem object 
	 * with the data read from the input file.
	 * @param splitString[] array that holds the strings parsed from the input file.
	 * @throws IllegalArgumentException
	 */
	public static void processGradeItemData(String[] splitString) throws IllegalArgumentException {
		
		if(splitString[1].equals("ADD")) {
			System.out.print("Running Test 2B:");
			
			 gradeItem2 = new GradeItem (splitString[3], Integer.parseInt(splitString[2]), splitString[4], splitString[5], splitString[6], Integer.parseInt(splitString[7]),
						Integer.parseInt(splitString[8])); 
		} // end try
		else {
			throw new IllegalArgumentException("The gradeitem data does not contain 'ADD' in the text file" 
		                                      + String.join(" ", splitString));
		}
		try {
			gradeItem2 = new GradeItem (splitString[3], Integer.parseInt(splitString[2]), splitString[4], splitString[5], splitString[6], Integer.parseInt(splitString[7]),
					Integer.parseInt(splitString[8])); 
		}
		catch(IllegalArgumentException e) {
			System.err.println("One of the arguments in the GradeItem constructor is invalid.");
		}
		
		
		
		
		
		
	} // End 2b
	
/******************************************************************/
	
	
	/** Test 3A
	 * equalsStudent will check if two student objects are the same
	 * @param student1 and student2
	 * @returns true if two student objects are the same
	 */
	
	public static boolean equalsStudent(Student student1, Student student2) {
		System.out.println("Running Test 3A:");
		if(student1.equals(student2)) {
			System.out.println("Student objects are equal: Student IDs are " + student1.getStudentID());
			return true;
		}
		System.out.println("These student objects are not equal: Student IDs are " + student1.getStudentID() + " and " + student2.getStudentID());
		return false;
	}// End equalsStudent method
	
/******************************************************************/

	
	/** Test 3B
	 * equalsGrade will check if two GradeItem objects are the same
	 * @param gradeItem1 and gradeItem 2
	 * @returns true if two GradeItem objects are the same
	 */
	
	public static boolean equalsGrade(GradeItem gradeItem1, GradeItem gradeItem2) {
		System.out.println("Running Test 3B:");
		if(gradeItem1.equals(gradeItem2)) {
			System.out.println("These grade item objects are equal: Student IDs are " + gradeItem1.getStudentID());
			return true;
		}
		System.out.println("These grade item objects are not equal: Student IDs are " + gradeItem1.getStudentID() + "and" 
				+ gradeItem2.getStudentID());
		return false;
		
	} // End equalsGrade method
		
	
	

} // End Class
