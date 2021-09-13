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

import java.io.Serializable;

/**
 * Company A needs a software that helps the accountant to keep track of the company’s purchases
 * and create an expense report. The company needs any new purchase will be added to a list of 
 * expenses of company and compare with monthly limit (which was allocated $10,000.00). 
 */

/**
 * Assignment 3
 * Class Expense
 * @author Giuliana Bouzon - 1940108
 * For Programming II Section 00002 - Winter 2021
 * Submitted on April 23rd, 2021
 */
public class Expense implements Serializable {
    
    //properties
    private int month;
    private String purchaseName;
    private double price;
    
    //default constructor
    public Expense() {
	this(1, "", 0); //the default values I chose
    }
    
    //parameterized constructor
    public Expense(int month, String purchaseName, double price) {
	setMonth(month);
	setPurchaseName(purchaseName);
	setPrice(price);
    }
    
    //copy constructor
    public Expense(Expense expense) {
	this(expense.month, expense.purchaseName, expense.price);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Expense other = (Expense) obj;
	if (month != other.month)
	    return false;
	if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
	    return false;
	if (purchaseName == null) {
	    if (other.purchaseName != null)
		return false;
	} else if (!purchaseName.equals(other.purchaseName))
	    return false;
	return true;
    }
    
    @Override
    public String toString() {
	return String.format("%s: %s, %s: $%.2f, %s: %d", "Item", this.purchaseName, "Cost", 
		this.price, "Month", this.month);
    }
    
    //getters and setters

    public int getMonth() {
	return this.month;
    }
    
    public void setMonth(int month) {
	this.month = (month > 0 && month <= 12) ? month : 1;
    }
    
    public String getPurchaseName() {
	return this.purchaseName;
    }
    
    public void setPurchaseName(String purchaseName) {
	this.purchaseName = (purchaseName != null) ? purchaseName : "";
    }
    
    public double getPrice() {
	return this.price;
    }
    
    public void setPrice(double price) {
	this.price = (price > 0 && price <= 10000) ? price : 0;
    }
}