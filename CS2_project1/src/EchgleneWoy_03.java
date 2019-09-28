import java.io.*;
import java.util.Scanner;

public class EchgleneWoy_03 {
	
	// Declare variables
	final static String INPUT_FILE = "Project_03_Input01.txt";
	final static String OUTPUT_FILE = "Project_03_Output01.txt";
			


	public static void main(String[] args) {
		
		
	} // End main
	
	//********************************************************
	
	/**
	 * processInput - Open and read the input file 
	 * and depending on the data; will either call
	 * processStudentData() or processGradeItemData()
	 * @throws FileNotFoundException
	 * @return none
	 */
	
	public void processInput() throws FileNotFoundException {
		
		// Opens the input file and reads it
		try {
			File inputDataFile = new File(INPUT_FILE);
			Scanner scnr = new Scanner(inputDataFile);
			
			//Stores split line into a String array
			String[] splitString;
			
			while(scnr.hasNextLine()) {
				String line = scnr.nextLine();
				splitString = line.split(",");
				
				if(splitString[0].contains("STUDENT")) {
					processStudentData(splitString);

				} // End if
				else if(splitString[0].contains("GRADEITEM") ) {
					processGradeItemData(splitString);
					
				}// End if
			
			} // End while
			
		} // End try
		catch(FileNotFoundException e) {
			System.err.println("The input file " + INPUT_FILE 
								+ "cannot be found.");
		} // End catch
		
	} // End processInput
	
	//********************************************************
	
	/**
	 * processStudentData - create a Student object, and 
	 * output to a file
	 * @param splitString - Array of type String with Student data
	 * @return none
	 */
	
	public static void processStudentData(String[] splitString) throws 
	IllegalArgumentException {
		
	} // End processStudentData
	

} // End class
