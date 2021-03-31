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
 * Registration implements course registration and course withdrawal of students.
 * Has user options in order to add/remove courses as well as view existing courses, etc.
 * Simulates a simple registration process.
 */

/**
 * Assignment 2
 * Class Registration
 * @author Giuliana Bouzon
 * For Programming II Section 00002 - Winter 2021
 * Submitted on March 25th, 2021
 */
public class Registration {

    //properties
    private String studentId;
    private int nbOfCourses;
    
    //default constructor
    public Registration() {
	this("A0000", 3); //default values I chose
    }
    
    //parameterized constructor
    public Registration(String studentId, int nbOfCourses) {
	this.studentId = studentId;
	this.nbOfCourses = nbOfCourses;
    }
    
    //copy constructor
    public Registration(Registration registration) {
	this(registration.studentId, registration.nbOfCourses);
    }
    
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Registration other = (Registration) obj;
	if (this.nbOfCourses != other.nbOfCourses)
	    return false;
	if (this.studentId == null) {
	    if (other.studentId != null)
		return false;
	} else if (!this.studentId.equals(other.studentId))
	    return false;
	return true;
    }
    
    /**
     * Withdraws a student from a course.
     * @return the updated number of courses.
     * @throws InvalidCourseException if course number falls below 2 
     */
    public void withdraw() throws InvalidCourseException {
	if (this.nbOfCourses <= 2) //because this method is only called if we want to subtract -1 from nb of courses
	    throw new InvalidCourseException("You have reached the minimum number of courses allowed.");
	else {
	    System.out.println("You have successfully withdrawn from a course.");
	    this.nbOfCourses--;
	}
    }
    
    /**
     * Registers a student to a course.
     * @return the updated number of courses.
     * @throws InvalidCourseException if course number falls above 6
     */
    public void register() throws InvalidCourseException {
	if (this.nbOfCourses >= 6) //because this method is only called if we want to add +1 to nb of courses
	    throw new InvalidCourseException("You have reached the maximum number of courses allowed.");
	else {
	    System.out.println("You have successfully registered for a course.");
	    this.nbOfCourses++;
	}
    }

    @Override
    public String toString() {
	return String.format("%s '%s' %s %d %s.", "Student", this.studentId, "is registered in", 
		this.nbOfCourses, "courses");
    }
    
    //getters
    //no setters because the user should not be able to change these properties
    //only through designated methods defined above.
    
    public String getStudentId() {
	return this.studentId;
    }
    
    public int getNbOfCourses() {
	return this.nbOfCourses;
    }
}