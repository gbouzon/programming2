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

package lab6;

/**
* Class based on Niloufar's lab 6 - Q1, defines Payment objects.
* @author Giuliana Bouzon
*/
public class Payment {

    protected double payment;
    
    //default constructor
    public Payment() {
	this(0);
    }
    
    //parameterized constructor
    public Payment(double payment) {
	this.payment = (payment > 0) ? payment : 0;
    }
    
    //copy constructor
    public Payment(Payment payment) {
	this(payment.payment);
    }
    
    /**
     * Checks if the object is null.
     * @param obj, the input object.
     * @return true if it is not null and false if otherwise.
     */
    protected boolean isNotNull(Object obj) {
	if (obj != null)
	    return true;
	
	return false;
    }
    
    /**
     * Outputs a sentence describing the payment details.
     * @return string containing payment details.
     */
    public String paymentDetails() {
	return String.format("%-15s: $%.2f\n", "Payment", payment);
    }
    
    @Override
    public String toString() {
	return paymentDetails();
    }
    
    //getter and setter
    
    public double getPayment() {
	return this.payment;
    }
    
    public void setPayment(double payment) {
	if (payment > 0)
	    this.payment = payment; //checks that the payment value is not negative
    }
}
