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

/**
 * Defines an invalid registration exception. 
 * Criteria:
 * Users cannot withdraw from more courses if they are at the minimum nb of courses allowed (min 2 courses)
 * Users cannot register for more courses if they are at the maximum nb of courses allowed (max 6 courses)
 */

/**
 * Assignment 2
 * Class InvalidRegistrationException - user-defined exception class
 * @author Giuliana Bouzon
 * For Programming II Section 00002 - Winter 2021
 * Submitted on March 25th, 2021
 */
public class InvalidCourseException extends Exception {

    //default constructor
    public InvalidCourseException() {
	super("Invalid number of courses."); 
    }
    
    //parameterized constructor
    public InvalidCourseException(String message) {
	super(message);
    }
}
