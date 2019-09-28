import java.io.*;
import java.util.Scanner;

public class EchgleneWoy_03 {
	
	// Declare variables
	final static String INPUT_FILE = "Project_03_Input01.txt";
	final static String OUTPUT_FILE = "Project_03_Output01.txt";
			


	public static void main(String[] args) {
		
		
	} // End main
	
	
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
				
				
				
			} // End while
			
			
		} // End try
		catch(FileNotFoundException e) {
			System.err.println("The input file " + INPUT_FILE 
								+ "cannot be found.");
		} // End catch
		
	} // End processInput

} // End class
