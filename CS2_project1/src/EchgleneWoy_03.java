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

import java.io.*;
import java.util.Scanner;

public class EchgleneWoy_03 {
	
	// Declare variables
	
	private static List listOfStudents;
	private static List	listOfGradeItem;
	private final static String INPUT_FILE = "Project_03_Input01.txt";
	private final static String OUTPUT_FILE = "Project_03_Output01.txt";
			


	public static void main(String[] args) throws FileNotFoundException {
		
		listOfStudents = new List();
		listOfGradeItem = new List();
		
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
	
	public static void processInput() throws FileNotFoundException {
		
		//Out statement letter user know the input file is being read
		Scanner scnr = new Scanner(INPUT_FILE);
		System.out.println("Reading data from " + INPUT_FILE + "...");
		
		//Stores split line into a String array
		String[] splitString;
		
		while(scnr.hasNextLine()) {
			String line = scnr.nextLine();
			splitString = line.split(",");
			
			if(splitString[0].equals("STUDENT")) {
				
				// Call processStudentData
				processStudentData(splitString);
				System.out.println("'STUDENT' has been found in the file.");

			} // End if
			
			else if(splitString[0].equals("GRADEITEM") ) {
				
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
		
		Student student = new Student(splitString[2], splitString[3], splitString[4], splitString[5]);
		
		if(splitString[1].equals("ADD")) {
			
			if(listOfStudents.contains(student)) {
				System.out.println("List already contains the Student data.");
			} // End if
			else { 
				// Add method to add student to list
				listOfStudents.add(student);
				
			} // End else
				
		} // End if
		
		if(splitString[1].equals("DEL")) {
			
			student =  new Student(splitString[2], splitString[3], splitString[4], splitString[5]);
			// Remove method to remove Student from list
			listOfStudents.remove(student);
		} // End if
		else if(!splitString[1].equals("ADD") || !splitString[1].equals("DEL")) {
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
		
		if(splitString[1].equals("ADD")) {
			
			if(listOfGradeItem.contains(gradeItem)) {
				System.out.println("Grade Item list already contains grade Item data.");
				
			} else {
				listOfGradeItem.add(gradeItem); // Add new grade Item object to list
				System.out.println("Grade Item with Grade Item Id " + splitString[2] +
							       " was added to the list.");
			} // End else	
			
		} // End if
		if(splitString[1].equals("DEL")) {
			// Create grade item object?
			
			listOfGradeItem.remove(gradeItem);	
		} // End if
		else if(!splitString[1].equals("DEL") || !splitString[1].equals("ADD")) {
			throw new IllegalArgumentException("Line does not contain 'ADD' or 'DEL' " + splitString[1]);
		} // End else if
		
		
	} // End processGradeItemData
	

} // End class
