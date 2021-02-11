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

import java.time.LocalDate;

/**
* Class defining a CreditCardPayment object, child class of Payment.
* @author Giuliana Bouzon
*/
public class CreditCardPayment extends Payment {
    
    private String name;
    private LocalDate expirationDate;
    private int cardNumber;

    //default constructor
    public CreditCardPayment() {
	this(0, "", LocalDate.now().plusYears(3), 0);
    }
    
    //parameterized constructor
    public CreditCardPayment(double payment, String name, LocalDate expirationDate, int cardNumber) {
	super(payment);
	this.name = (isNotNull(name)) ? name : "";
	this.expirationDate = (expirationDate.isAfter(LocalDate.now())) ? expirationDate : LocalDate.now();
	this.cardNumber = cardNumber;
    }
    
    //copy constructor
    public CreditCardPayment(CreditCardPayment creditPayment) {
	this(creditPayment.payment, creditPayment.name, creditPayment.expirationDate, creditPayment.cardNumber);
    }
    
    /**
     * Outputs a sentence describing the payment details.
     * @return string containing the payment details.
     */
    public String paymentDetails() {
	String str = "";
	
	str += String.format("%-15s: %s\n", "Type", "Credit Card");
	str += String.format("%-15s: %s\n", "Name", name);
	str += String.format("%-15s: %d\n", "Card Number", cardNumber);
	str += String.format("%-15s: %s\n", "Expiration Date", expirationDate.toString());
	
	return str;
    }
    
    @Override
    public String toString() {
	return super.paymentDetails() + this.paymentDetails();
    }

    //getters and setters
    
    public String getName() {
	return this.name;
    }
    
    public void setName(String name) {
	if (isNotNull(name)) //checking that the string isn't null
	    this.name = name;
    }
    
    public LocalDate getExpirationDate() {
	return this.expirationDate;
    }
    
    public void setExpirationDate(LocalDate expirationDate) {
	if (expirationDate.isAfter(LocalDate.now())) //checking that the expiration date is after today
	    this.expirationDate = expirationDate;
    }
    
    public int getCardNumber() {
	return this.cardNumber;
    }
    
    public void setCardNumber(int cardNumber) {
	this.cardNumber = cardNumber;
    }
}