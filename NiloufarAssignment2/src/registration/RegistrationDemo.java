/** MIT License Copyright (c) 2021 Giuliana Bouzon

* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:

* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.

* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
* THE SOFTWARE.
*/

package registration;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A java application class that tests a simple registration process defined in Registration class.
 */

/**
 * Assignment 2
 * Class RegistrationDemo
 * @author Giuliana Bouzon
 * For Programming II Section 00002 - Winter 2021
 * Submitted on March 25th, 2021
 */
public class RegistrationDemo {
    
    static Scanner scan = new Scanner(System.in);
    //valid options in the retrieveUserOption() method
    private static final int[] VALID_TYPES = {1, 2, 3, 0}; 
    
    /**
     * Checks if the option entered by the user is valid.
     * @param option, the input integer value.
     * @return true if the option is valid, and false if otherwise.
     */
    private static boolean isOptionValid(int option) {
	for (int validType : VALID_TYPES) 
	    if (option == validType)
		return true;
	
	return false; 
    }
    
    /**
     * Checks if the student id entered by the user is valid.
     * ^ Criteria is in InvalidIdException class.
     * @param id, the input id to be evaluated.
     * @return true if the id is valid, and false if otherwise.
     */
    private static boolean isValidId(String id) { 
	if (id.length() != 5) //one letter + 4 numbers, length = 5
	    return false;
	
	if (!Character.isLetter(id.charAt(0))) //first character has to be a letter
	    return false;
	
	String digitString = id.substring(1); //remaining characters are supposed to be digits
	
	for (int i = 0; i < digitString.length(); i++) 
	    if (!Character.isDigit(digitString.charAt(i))) //checking that ^
		return false;	
	
	return true;
    }
    
    /**
     * Prompts the user to enter a student id.
     * @return, the student id.
     * @throws InvalidIdException if the id does not conform to the specified rules
     */
    private static String retrieveStudentId() throws InvalidIdException { 
	System.out.print("Please enter your student ID: ");
	String id = scan.nextLine();
	
	if (!isValidId(id)) 
	    throw new InvalidIdException();
	
	return id;
    }
    
    /**
     * Prompts the user to enter the number of courses they are taking.
     * @return the number of courses.
     * @throws InvalidCourseException if the course number does not conform to the specified rules
     * @throws InputMismatchException if the entered data does not belong the expected data type
     */
    private static int retrieveCourses() throws InvalidCourseException, InputMismatchException { 
	System.out.print("Please enter the number of courses you are currently taking: ");
	int numberOfCourses = scan.nextInt();
	
	if (numberOfCourses < 2 || numberOfCourses > 6)
	    throw new InvalidCourseException();
	
	return numberOfCourses;
    }
    
    /**
     * Prompts the user to enter a student id and number of courses.
     * If the aforementioned values are not valid, the user is again prompted to enter VALID values.
     * Catches Input Mismatch Exceptions, Invalid Id Exception and Invalid Course Exception in previous methods.
     * @return the registration object created using user input.
     */
    public static Registration catchUserInput() {
	boolean isValidId, isValidCourse;
	String id = "";
	int numberOfCourses = 0;
	
	//getting the id
	do {
	    isValidId = true;  
	    try {
		id = retrieveStudentId();
	    }
	    catch (InvalidIdException idException) {
		isValidId = false;
		System.out.println(idException.getMessage());
	    }
	    
	} while (!isValidId);
	
	//getting the course number
	do {
	    isValidCourse = true;  
	    try {
		numberOfCourses = retrieveCourses();
	    }
	    catch (InputMismatchException exception) {
		isValidCourse = false;
		System.out.println("Not a valid input.");
		scan.nextLine();
	    }
	    catch (InvalidCourseException courseException) {
		isValidCourse = false;
		System.out.println(courseException.getMessage());
		scan.nextLine(); 
	    }
	    
	} while (!isValidCourse);
	
	//did two separate loops because I don't want to repeat both when only one of them is right.
	
	return new Registration(id, numberOfCourses);
    }
    
    /**
     * Prompts the user to enter a menu option.
     * @return the menu option.
     */
    public static int retrieveUserOption() {
	int userOption = 0;
	boolean isValid; 
	System.out.println("------------------------------------------------------------");
	System.out.println("[1] Confirm your Registration     [3] Register for a course");
	System.out.println("[2] Withdraw from a course        [0] Exit");   
	System.out.println("------------------------------------------------------------");

	do {
	    isValid = true;
	    System.out.print("Please enter desired operation: ");
	    try {
		isValid = true;
                userOption = scan.nextInt();
	    }
	    catch (InputMismatchException exception) {
		isValid = false;
		System.out.println("Not a valid option.");
		scan.nextLine();
	    }
	    
	} while (!isValid || !isOptionValid(userOption)); //doing this because I don't want option "4" to go to default in my switch
	
	return userOption;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	int userOption;
	boolean userActive = true;
	boolean isValid; 
	
	Registration registration = new Registration(catchUserInput()); //using copy constructor
	
	do {
	    isValid = true;
	    try {
	        while (userActive) {	
	            userOption = retrieveUserOption();
		    switch(userOption) {
	    	        case 1: 
	    		    System.out.println(registration);	
	    		    System.out.println("Your registration has been successfully confirmed.");	    		
	    		    System.exit(0); //exits the program once the registration has been confirmed.
	    	        case 2:
	    		    registration.withdraw();
	    		    System.out.println(registration);
	    		    break;
	    	        case 3:
	    		    registration.register();
	    		    System.out.println(registration);
	    		    break;
	    	        default:
	    		    System.out.println("Exiting...");
	    		    userActive = false;
		    }    
	        } 
	    }
	    catch (InvalidCourseException courseException) {
	        isValid = false;
	        System.out.println(courseException.getMessage());
	        scan.nextLine();
	    }    
	    //prints stack trace to pinpoint where the problem is (just a contingency).
	    catch (Exception exception) {
	        System.out.println("Error please check me ;(");
	        exception.printStackTrace();
	    }
	    
	} while (!isValid);
	
	//closing the scanner to avoid resource leaks.
	scan.close();
    }
}