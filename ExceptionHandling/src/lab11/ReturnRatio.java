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

package lab11;

import java.util.InputMismatchException;
import java.util.Scanner;
import lab10.DivisionByZeroException;

/**
 * Class based on Niloufar's lab 11 - Q5.
 * @author Giuliana Bouzon
 */
public class ReturnRatio {
    
    //static scanner, to be used throughout the class.
    static Scanner scan = new Scanner(System.in);
    
    //static variables for the calculations
    static int numerator = 0;
    static int denominator = 0;
    static double quotient = 0;

    /**
     * Prompts the user to enter a numerator for the division to be performed.
     * @return the numerator.
     * @throws InputMismatchException.
     */
    public static int retrieveNumerator() throws InputMismatchException {
	System.out.print("Please enter the numerator: ");
	return scan.nextInt();
    }
    
    /**
     * Prompts the user to enter a denominator for the division to be performed.
     * @return the denominator.
     * @throws InputMismatchException.
     */
    public static int retrieveDenominator() throws InputMismatchException {
	System.out.print("Please enter the denominator: ");
	return scan.nextInt();
    }
    
    /**
     * Prompts the user to enter a numerator and denominator.
     * If the aforementioned values are not valid, the user is again prompted to enter VALID values.
     * Catches Input Mismatch Exceptions in previous methods.
     */
    public static void catchUserInput() {
	boolean isValid;
	
	do {
	    isValid = true;
	    try {
		numerator = retrieveNumerator();
		denominator = retrieveDenominator();
	    }
	    
	    catch(InputMismatchException exception) {
		isValid = false;
		System.out.println("Not a valid input.");
		scan.nextLine();
	    }
	    
	} while (!isValid);
    }
    
    /**
     * Performs the division with the given values.
     * Checks for divisions by zero.
     * @return the quotient.
     * @throws DivisionByZeroException
     */
    public static double returnRatio() throws DivisionByZeroException {
	if (denominator == 0)
	    throw new DivisionByZeroException();
	else
	    return (double) numerator / denominator;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	boolean isValid = false;
	
	catchUserInput();
	
	do {
	    isValid = true;
	    try {
		quotient = returnRatio();
	    }
	    
	    catch(DivisionByZeroException exception) {
		isValid = false;
		System.out.println(exception.getMessage());
		catchUserInput();
	    }

	} while(!isValid);

	System.out.printf("%s %d / %d = %.2f", "Your division of", numerator, denominator, quotient);
	
	//closing scanner
	scan.close();
    }
}