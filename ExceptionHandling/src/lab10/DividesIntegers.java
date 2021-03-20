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

package lab10;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class based on Niloufar's lab 10 - Q18.
 * @author Giuliana Bouzon
 */
public class DividesIntegers {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	Scanner scan = new Scanner(System.in);
	int numerator = 0;
	int denominator = 0;
	double quotient = 0.0;
	boolean isValid;
	
	do {
	    isValid = true;
	    try {
		System.out.print("Please enter the numerator: ");
		numerator = scan.nextInt();
		System.out.print("Please enter the denominator: ");
		denominator = scan.nextInt();
	    }
	    
	    catch(InputMismatchException iException) {
		isValid = false;
		System.out.println("Not a valid input.");
		scan.nextLine();
	    }

	} while(!isValid);
	
	//closing scanner
	scan.close();
	
	try {
	    if (denominator == 0)
		throw new DivisionByZeroException();
	    else
		quotient = (double) numerator / denominator;
	}
	
	catch(DivisionByZeroException exception) {
	    System.out.println(exception.getMessage());
	    System.exit(0);
	}
	
	System.out.printf("%s %d / %d = %.2f", "Your division of", numerator, denominator, quotient);
    }
}