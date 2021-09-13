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

/**
 * Defines an Exception class for invalid months.
 * Criteria:
 * Months vary between 1 and 12 but cannot be under 1 nor over 12.
 */

/**
 * Assignment 3
 * Class InvalidMonthException
 * @author Giuliana Bouzon - 1940108
 * For Programming II Section 00002 - Winter 2021
 * Submitted on April 23rd, 2021
 */
public class InvalidMonthException extends Exception {
    
    //default constructor
    public InvalidMonthException() {
	super("Invalid month.");
    }
    
    //parameterized constructor
    public InvalidMonthException(String message) {
	super(message);
    }
}
