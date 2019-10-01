/*
 * EchgleneWoy_03 this class will read from input file and 
 * will also output to a file 

 * Echglene Woy & Serena Zarate
 * Project 3
 * Eclipse
 * Zealot: a fervent and even militant proponent of something
 * "One day you'll leave this world behind so live a life you will remember" - Avicii
 * 	
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EchgleneWoy_03 implements MyCollectionInterface {
	
	// Declare variables
	
	private static Student[] arrayOfStudents;
	private static List<Student> listOfStudents;
	private static List<GradeItem> listOfGradeItem;
	private final static String INPUT_FILE = "/CS2_project1/src/Project_03_Input01.txt";
	private final static String OUTPUT_FILE = "Project_03_Output01.txt";
			


	public static void main(String[] args) throws IOException {
		
		listOfStudents = new ArrayList<Student>();
	    listOfGradeItem = new ArrayList<GradeItem>();
		
		processInput();
		System.out.println("we got this far.");
		//generateReport();
		
		
	} // End main
	
	//********************************************************
	
	/**
	 * processInput - Open and read the input file 
	 * and depending on the data; will either call
	 * processStudentData() or processGradeItemData()
	 * @throws FileNotFoundException
	 * @return none
	 */
	
	public static void processInput() throws IOException {
		
		//Out statement let user know the input file is being read	
		Scanner scnr;
		String[] splitString;
		
		File file = new File("C:\\Users\\Echglene\\git\\repository2\\test2wtf\\CS2_project1\\src\\Project_03_Input01.txt");
		scnr = new Scanner(file);
		
		System.out.println("Reading data from " + file + "...");
		
		while(scnr.hasNextLine()) {
			String line = scnr.nextLine();
			splitString = line.split(",");

			if(splitString[0].contains("STUDENT")) {
				
				// Call processStudentData
				processStudentData(splitString);
				System.out.println("'STUDENT' has been found in the file.");

			} // End if
			
			else if(splitString[0].contains("GRADEITEM") ) {
				
				//Call processGradeItemData
				processGradeItemData(splitString);
				System.out.println("'GRADEITEM' has been found in the file.");
				
			} // End if
		} // End while

		scnr.close();
			
			
	} // End processInput

	//********************************************************
	
	/**
	 * processStudentData - create a Student object, and 
	 * output to a file
	 * @param splitString - Array of type String with Student data
	 * @throws IllegalArgumentException
	 * @return none
	 */
	
	public static void processStudentData(String[] splitString) throws 
										IllegalArgumentException {
		//List<Student> listOfStudents = new ArrayList<Student>();
		
		Student student;
		
		if(splitString[1].equals("ADD")) {
			
			try {
			 student = new Student(splitString[2], splitString[3], splitString[4], splitString[5]);
			} // End try
			catch(IllegalArgumentException e) {
				
			} // End catch
			
			if(listOfStudents.contains(student)) {
				System.out.println("List already contains the Student data with student ID " + splitString[2]);
			} // End if
			else { 
				// Add method to add student to list
				listOfStudents.add(student);
				
			} // End else
				
		} // End if
		
		else if(splitString[1].equals("DEL")) {
			
			 student =  new Student(splitString[2], splitString[3], splitString[4], splitString[5]);
			// Remove method to remove Student from list
			listOfStudents.remove(student);
			System.err.println("Student was removed in the list with Student ID " + splitString[2]);
		} // End if
		else if(!(splitString[1].equals("ADD")) && 
				!(splitString[1].equals("DEL"))) {
			throw new IllegalArgumentException("Line does not contain 'ADD' or 'DEL' " + splitString[1]);
			
		} // End else if
		
	} // End processStudentData
	
	//********************************************************
	
	/**
	 * processGradeItemData - Create a GradeItem object, and
	 * output to a file
	 * @param splitString - Array of type String with Student data
	 * @throws IllegalArgumentException
	 * @return none
	 */
	
	public static void processGradeItemData(String[] splitString) throws
	IllegalArgumentException {
		
		GradeItem gradeItem = new GradeItem(splitString[3], Integer.parseInt(splitString[2]), splitString[4], 
						splitString[5],
						splitString[6], 
						Integer.parseInt(splitString[7]),
						Integer.parseInt(splitString[8]));
		
		if(splitString[1].contains("ADD")) {
			
			if(listOfGradeItem.contains(gradeItem)) {
				System.err.println("Grade Item list already contains grade Item data with Student ID: " 
									+ splitString[3] + "and Grade Item ID: " + splitString[2]);
				
			} else {
				listOfGradeItem.add(gradeItem); // Add new grade Item object to list
				System.out.println("Grade Item with Grade Item Id " + splitString[2] +
							       " was added to the list.");
			} // End else	
			
		} // End if
		else if(splitString[1].contains("DEL")) {
			// Create grade item object?
			
			listOfGradeItem.remove(gradeItem);	
			System.err.println("Grade Item with Grade Item ID " + splitString[2] + 
					" has been deleted.");
		} // End if
		else if(!splitString[1].contains("DEL") && !splitString[1].contains("ADD")) {
			throw new IllegalArgumentException("Line does not contain 'ADD' or 'DEL' " + splitString[1]);
		} // End else if
		
		
	} // End processGradeItemData
	
	public static void generateReport() throws FileNotFoundException {
		

		// Write to output file 
		PrintWriter outFile = new PrintWriter(new File(OUTPUT_FILE));
		
		
		// Calls toArray method in Student and Gradeitem lists
		//listOfStudents.toArray(arrayOfStudents); // Why do I need a new array object to store this? 
		arrayOfStudents = (Student[]) listOfStudents.toArray();
		for(Student x : arrayOfStudents) {
			System.out.printf("%s", x);
		}
		
		// Prints to console stating that report is generating
		System.out.println("Generating report ... ");
		
			
		} // End generateReport
		
		
	} // End class
	

 
