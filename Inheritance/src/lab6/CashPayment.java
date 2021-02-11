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
* Class defining a CashPayment object, child class of Payment.
* @author Giuliana Bouzon
*/
public class CashPayment extends Payment {

    //default constructor
    public CashPayment() {
	this(0);
    }
    
    //parameterized constructor
    public CashPayment(double payment) {
	super(payment);
    }
    
    //copy constructor
    public CashPayment(CashPayment cashPayment) {
	this(cashPayment.payment);
    }
    
    /**
     * Outputs a sentence describing the payment details.
     * @return string containing payment details.
     */
    public String paymentDetails() {
	return String.format("%-15s: %s\n", "Type", "Cash");
    }
    
    @Override
    public String toString() {
	return super.paymentDetails() + this.paymentDetails();
    }
}
