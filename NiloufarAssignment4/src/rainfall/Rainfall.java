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

package rainfall;

/**
 * Rainfall class defines Rainfall objects as per assignment 4 pdf.
 * Class to be used to store data about the monthly rainfall collected in one year.
 * It includes a implementation of the Comparable interface so as to compare Rainfall objects based on their precipitations (ascending).
 */

/**
 * Assignment 4
 * Class Rainfall
 * @author Giuliana Bouzon - 1940108
 * For Programming II Section 00002 - Winter 2021
 * Submitted on May 17th, 2021
 */
public class Rainfall implements Comparable <Rainfall> {
    
    //properties
    private String month;
    private int precipitation;
    private static final String[] VALID_MONTHS = {"January", "February", "March", "April", "May", "June", "July",
	    "August", "September", "October", "November", "December"};
    
    //default constructor
    public Rainfall() {
	this("", 0);
    }
    
    //parameterized constructor
    public Rainfall(String month, int precipitation) {
	setMonth(month);
	setPrecipitation(precipitation);
    }
    
    //copy constructor
    public Rainfall(Rainfall rainfall) {
	this(rainfall.month, rainfall.precipitation);
    }
    
    /**
     * Returns true if a String value, month, is a valid month based on predefined rules.
     * @param month, the input String value.
     * @return true if "month" is valid and false if otherwise.
     */
    private boolean isValidMonth(String month) {
	for (String validMonth : VALID_MONTHS)
	    if (month.equalsIgnoreCase(validMonth))
		return true;
	
	return false;
    }
    
    @Override
    public int compareTo(Rainfall rainfall) {
	return (this.precipitation - rainfall.precipitation); //ascending order
    }
    
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((month == null) ? 0 : month.hashCode());
	result = prime * result + precipitation;
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Rainfall other = (Rainfall) obj;
	if (month == null) {
	    if (other.month != null)
		return false;
	} else if (!month.equals(other.month))
	    return false;
	if (precipitation != other.precipitation)
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return String.format("%-10s \t %d", this.month, this.precipitation);
    }
    
    //getters and setters
    
    public String getMonth() {
	return this.month;
    }
    
    public void setMonth(String month) {
	if (isValidMonth(month))
	    this.month = month;
    }
    
    public int getPrecipitation() {
	return this.precipitation;
    }
    
    public void setPrecipitation(int precipitation) {
	if (precipitation >= 0)
	    this.precipitation = precipitation;
    }
}