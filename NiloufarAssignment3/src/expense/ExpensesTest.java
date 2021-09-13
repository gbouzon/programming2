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

package expense;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A java application class that tests a expense report as defined in the assignment pdf.
 */

/**
 * Assignment 3
 * Class ExpensesTest
 * @author Giuliana Bouzon - 1940108
 * For Programming II Section 00002 - Winter 2021
 * Submitted on April 23rd, 2021
 */
public class ExpensesTest {
    
    //class variables
    static File file = new File("Expenses.ser");
    static Expense[] expenses = new Expense[50];
    static Scanner scan = new Scanner(System.in);
    
    //valid options in the retrieveUserOption() method
    private static final int[] VALID_TYPES = {1, 2, 0}; 
    
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
     * Prompts the user to enter a menu option.
     * @return the menu option.
     */
    private static int retrieveUserOption() {
	int userOption = 0;
	boolean isValid; 
	System.out.println("------------------------------------------------------");
	System.out.println("[1] Add a new Purchase      [2] View monthly spending");
	System.out.println("[0] Exit");   
	System.out.println("------------------------------------------------------");

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
	    
	} while (!isValid || !isOptionValid(userOption)); //doing this because I don't want option "3" to go to default in my switch
	
	return userOption;
    }
    
    /**
     * Prompts the user to enter a month.
     * @return the entered int value.
     * @throws InvalidMonthException if the month isn't [1, 12].
     * @throws InputMismatchException if the entered data type does not match the expected one.
     */
    private static int retrieveMonth() throws InvalidMonthException, InputMismatchException { 
	System.out.print("Please enter month of purchase: ");
	int month = scan.nextInt();
	
	if (month < 1 ||  month > 12)
	    throw new InvalidMonthException();
	
	return month;
    }
    
    /**
     * Prompts the user to enter a name for the item.
     * @return the entered String value (if it isn't null nor empty).
     */
    private static String retrieveItemName() { 
	String name = "";
	do {
	    System.out.print("Please enter name of item purchased: ");
	    name = scan.nextLine();
	} while (name == null || name.isEmpty());
	
	return name;
    }
    
    /**
     * Prompts the user to enter a cost for the item.
     * @return the entered double value.
     * @throws InvalidCostException if the cost is below zero or above $10 000.
     * @throws InputMismatchException if the entered data type does not match the expected one.
     */
    private static double retrieveItemCost() throws InvalidCostException, InputMismatchException { 
	System.out.print("Please enter cost of purchase: ");
	double cost = scan.nextDouble();
	
	if (cost < 0 || cost > 10000)
	    throw new InvalidCostException();
	
	return cost;
    }
    
    /**
     * Prompts the user to enter a month, a name and a cost for the item.
     * If the aforementioned values are not valid, the user is again prompted to enter VALID values.
     * Catches Input Mismatch Exceptions, Invalid Month Exception and Invalid Cost Exception thrown in previous methods.
     * @return the Expense object created using user input.
     */
    public static Expense catchUserInput() {
	boolean isValidMonth, isValidCost;
	String name = "";
	int month = 0;
	double cost = 0;
	
	//getting the month
	do {
	    isValidMonth = true;  
	    
	    try {
		month = retrieveMonth();
	    }
	    catch (InvalidMonthException mException) {
		isValidMonth = false;
		System.out.println(mException.getMessage());
	    }
	    catch (InputMismatchException exception) {
		isValidMonth = false;
		System.out.println("Not a valid input.");
		scan.nextLine();
	    }
	    
	} while (!isValidMonth);
	
	//getting the name of the purchased item
	scan.nextLine();
	name = retrieveItemName();
	
	//getting the cost of the purchased item
	do {
	    isValidCost = true;  
	    try {
		cost = retrieveItemCost();
	    }
	    catch (InvalidCostException cException) {
		isValidMonth = false;
		System.out.println(cException.getMessage());
	    }
	    catch (InputMismatchException exception) {
		isValidMonth = false;
		System.out.println("Not a valid input.");
		scan.nextLine();
	    }
	    
	} while (!isValidCost);
	
	return new Expense(month, name, cost);
    }
    
    /**
     * Deserializes a file to Expense array.
     * @param expenses, the input Expense array.
     * @return the objects in the array (number of purchases).
     */
    public static int readFromFile(Expense[] expenses) {
	try { 
	    FileInputStream fileStream = new FileInputStream(file); 
	    ObjectInputStream objectStream = new ObjectInputStream(fileStream);
	    
	    expenses = (Expense[]) objectStream.readObject();
	    objectStream.close();
	} 
	catch (Exception exception) {
	    System.out.println(exception.getClass() + ": " + exception.getMessage());
	}
	
	return expenses.length;
    }
    
    /**
     * Serializes Expense array into a file. 
     * @param expenses, the input Expense array.
     */
    public static void writeToFile(Expense[] expenses) {
	try {
	    FileOutputStream fileStream = new FileOutputStream(file);
	    ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
	    objectStream.writeObject(expenses);
	    objectStream.close();
	}
	catch (Exception exception) {
	    exception.printStackTrace();
	}
    }
    
    /**
     * Calculates the monthly purchases for a given month.
     * @param month, the input int value.
     * @param expenses, the input Expense array.
     * @return the sum of all the purchases for a given month.
     */
    public static double getMonthlyPurchases(int month, Expense[] expenses) {
	double sum = 0;
	
	for (Expense expense : expenses) 
	    if (expense != null && expense.getMonth() == month)
		sum += expense.getPrice();
	
	return sum;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	//printing system header
	System.out.println("----------Welcome to Expense Tracking System----------");
	
	//variables to be used later on
	int userOption, month;
	int counter = 0;
	boolean userActive = true;
	boolean isValid; 
	
	//getting data from file
	readFromFile(expenses);
	
	do {
	    isValid = true;
	    try {
	        while (userActive) {	
	            userOption = retrieveUserOption();
		    switch(userOption) {
	    	        case 1: 
	    	            expenses[counter++] = new Expense(catchUserInput()); //adding new Expense objects to array
	    	            System.out.println("New expense successfully added!");
	    	            break;
	    	        case 2:
	    	            month = retrieveMonth();
	    		    System.out.println("The amount of money spent in month " + month + 
	    			    " is $" + getMonthlyPurchases(month, expenses));
	    		    break;
	    	        default:
	    	            System.out.println("Exiting...");
	    		    userActive = false;
		    }    
	        } 
	    }
	    catch (InvalidMonthException courseException) {
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
	
	//updating the file with the newly added expenses.
	writeToFile(expenses);
		
	//closing the scanner to avoid resource leaks.
	scan.close();
    }
}