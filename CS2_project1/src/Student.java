/** This class is a Student class which will compromise of a student's data in order to be in the gradebook application.
 * 
 * @author Echglene Woy
 * Project_01
 * Eclipse
 * Quibble - a slight objection or criticism about a trivial matter.
 * “You learn more from failure than from success. don’t let it stop you. failure builds character.” - Unknown
 * 
 * created on Aug 21, 2019
 */

public class Student {
	
	private String studentID;  // Student ID
	private String firstName;  // First name
	private String lastName;   // Last name
	private String email;	   // Email	Address
	
	/** This is the constructor for the student class
	 * 
	 * @param studentID
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @throws IllegalArgumentException
	 */
	public Student(String studentID, String firstName, String lastName, String email) throws IllegalArgumentException { 
		
		if(isInvalid(studentID)) {
			throw new IllegalArgumentException("Student ID cannot be blank.");
		}
		if(isInvalid(firstName)) {
			throw new IllegalArgumentException("Please enter a valid first name.");
		}
		if(isInvalid(lastName))  {
			throw new IllegalArgumentException("Please enter a valid last name.");
		}
		if(isInvalid(email)) {
			throw new IllegalArgumentException("Please enter a valid email address with an '@.'");
		}
		if(!email.contains("@")) { 
			throw new IllegalArgumentException(email + "Email address does not contain an '@'");
		}
		
		this.studentID = studentID; 
		this.firstName = firstName;
		this.lastName =  lastName;
		this.email = email;
		
	} // End constructor
	
	//*********************************************************************************************************
	
	/** Getter methods for instance variables
	 * @returns studentID, firstName, lastName, email
	 */
	
	public String getStudentID() {
		return studentID;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	} // End getters
	
	//*********************************************************************************************************
	
	/** Equals method will check if two students have the same information 
	 * @param other - the "other" student object to compare to this one
	 * @returns true if the two student objects are equal; false otherwise
	 */
	public boolean equals(Student other) {
		if(this.studentID.equals(other.getStudentID()) && (this.firstName.equals(other.getFirstName()))
				&& (this.lastName.equals(other.getLastName())) && 
				(this.email.equals(other.getEmail()))) {
			
			return true;
		}	
		return false;
	} // End equals method
	
	//*********************************************************************************************************
	
	/** toString method to returns an instance of an object 
	 */
	public String toString() {
		String result = ""; 
		result = "Student ID: " + studentID + "\nName:" + firstName + " " + lastName + "\nemail Address: " + email;
		
		return result;
	} // End toString method
	
	//*********************************************************************************************************
	
	/** isInvalid method will check to see if the user inputs a null or empty value
	 * @param fieldName
	 * @return true if is invalid; false otherwise
	 */
	
	public boolean isInvalid(String fieldName) {
		return (fieldName == null || fieldName.equals(""));
	} // End isInvalid method

} // End Class
