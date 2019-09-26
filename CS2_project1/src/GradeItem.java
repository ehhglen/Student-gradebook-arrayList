
/** this is the GradeItem Class, it will have in it a student's grades from from all the work they've done.
 * 
 * @author Echglene Woy
 * Project_01
 * Eclipse
 * Picaresque - relating to an episodic style of fiction dealing with the adventures of a rough and dishonest but appealing hero.
 * “If You Are Working On Something That You Really Care About, You Don’t Have To Be Pushed. The Vision Pulls You.” – Steve Jobs (1955 - 2011)
 *
 */

public class GradeItem {
	
	private String studentID;
	private int gradeItemID;
	private String courseID;
	private static String itemType;
	private static String itemTypes[] = {"HW", "Quiz", "Class Work", "Test", "Final"}; 
	private String date;
	private int maximumScore;
	private int actualScore;
	
	/** This is the constructor for the GradeItem Class
	 * 
	 * @param studentID is the student's ID number
	 * @param gradeItemID 
	 * @param courseID
	 * @param itemType
	 * @param date 
	 * @param maximumScore the max score a student can get
	 * @param actualScore
	 * @throws IllegalArgumentException
	 */
	public GradeItem(String studentID, int gradeItemID, String courseID, String itemType, String date, int maximumScore, int actualScore) throws IllegalArgumentException {
		
		if(studentID == null || studentID.equals("")) {
			throw new IllegalArgumentException("Please enter valid Student ID");
		}
		if(courseID == null || courseID.equals("")) {
			throw new IllegalArgumentException("Please enter a valid course ID");
		}
		if(itemType == null || itemType.equals("")) {
			throw new IllegalArgumentException("Please enter a valid item type: ");
		}
		if(isValidType(itemType) == false) {
			throw new IllegalArgumentException("Enter valid item type: ('HW', 'Quiz', 'Class Work', 'Test', 'Final')");
		}
		if(date == null || date.equals("")) {
			throw new IllegalArgumentException("Enter a valid date");
		}
		if(gradeItemID < 0) {
			throw new IllegalArgumentException("Grade Item ID can not be less than 0.");
		}
		if(maximumScore <= 0) {
			throw new IllegalArgumentException("Maximum score can not be less than or equal to 0");
		}
		if(actualScore < 0 || actualScore > maximumScore) {
			throw new IllegalArgumentException("Actual score must be in range of 0 and" + maximumScore);
		}
		
		this.studentID = studentID;
		this.gradeItemID = gradeItemID;
		this.courseID = courseID;
		this.itemType = itemType;
		this.date = date;
		this.maximumScore = maximumScore;
		this.actualScore = actualScore;
	} // End Constructor 
	
	//***************************************************************************************************
	
	/* Getter methods for instance variables
	 * @returns studentID, gradeItemID, courseID, itemType, date, maximumScore, actualScore
	 */
	
	public String getStudentID() {
		return studentID;
	}
	public int getGradeItemID() { 
		return gradeItemID;
	}
	public String getCourseID() {
		return courseID;
	}
	public String getItemType() {
		return itemType;
	}
	public String getDate() {
		return date;
	}
	public int getMaximumScore() {
		return maximumScore;
	}
	public int getActualScore() {
		return actualScore;
	} // End getters
	
	//***************************************************************************************************
	
	/** Equals method will check if two GradeItem have the same information 
	 * @param other - the "other" GradeItem object to compare to this one
	 * @returns true if the two GradeItem objects are equal; false otherwise
	 */
	
	public boolean equals(GradeItem other) {
		if(this.studentID.equals(other.studentID) && (this.gradeItemID == (other.gradeItemID) && (this.courseID.equals(other.courseID) 
				&& (itemType.equals(itemType)
				&& (this.date.equals(other.date) && (this.maximumScore == (other.maximumScore) && (this.actualScore == (other.actualScore)))))))) {
			return true; 
		}
		return false;
	} // End Equals method
	
	//***************************************************************************************************
	
	/** toString method to display an instance of an object 
	 */
	public String toString() {
		String result = " ";
		result = "\nStudent ID: " + studentID + "\ngrade Item ID: " + gradeItemID + "\nCourse ID: " + courseID 
				+ "\nItem Type: " + itemType 
				+ "\nDate: " + date 
				+"\nMaximum Score: " + maximumScore
				+"\nActual score: " + actualScore;
		return result;
	} // end toString method
	
	//***************************************************************************************************
	
	/* isValidType method for itemType array
	 * @returns true if itemType equals "HW", "Class Work", "Quiz, "Test", "Final"
	 */
	
	public static boolean isValidType(String itemType) {
		for(int i = 0; i < GradeItem.itemTypes.length; i++) {
			if(itemType.equals(GradeItem.itemTypes[i])) {
				return true;
			
			}
		}
		return false;
	} // End isValidType method

}
