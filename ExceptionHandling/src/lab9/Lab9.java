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

package lab9;

import java.util.Scanner;

/**
* Class based on Niloufar's lab 9, Q9
* @author Giuliana Bouzon
*/
public class Lab9 {
    
    public static int calculateAverage() {
	int sum = 0;
	int n = 0;
	boolean isValid;
	Scanner scanner = new Scanner(System.in);
	
	do {
	    try {
		isValid = false;
		System.out.print("Please enter N: ");
		n = scanner.nextInt();
		if (n <= 0)
		    throw new IllegalArgumentException("N must be positive");

	    }	
	    catch(Exception exception) {
		isValid = true;
		System.out.println(exception.getMessage()); 
	    }
    
	} while (isValid);
	
	for (int i = 0; i < n; i++) {
	    do {
		try {
		    isValid = false;
		    System.out.printf("%s %d: ", "Please enter value", (i + 1));
		    int number = scanner.nextInt();
		    sum += number;
		}
		catch(Exception exception) {
		    isValid = true;
		    System.out.println(exception.getMessage()); 
		    scanner.nextLine();
		}
	    } while (isValid);
	}
	scanner.close();
	return sum / n;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	System.out.println("Sum is: " + calculateAverage());
    }
}
