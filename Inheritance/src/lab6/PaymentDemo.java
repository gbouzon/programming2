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
* Driver class for Payment project (lab 6, Q1)
* @author Giuliana Bouzon
*/
public class PaymentDemo {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	//creating cash payments
	CashPayment cashP = new CashPayment(354.1);
	CashPayment cashP2 = new CashPayment(1234.75);
	
	//creating credit card payments
	CreditCardPayment creditP = new CreditCardPayment(32.49, "Albert Magnus", LocalDate.now().plusYears(2), 12345);
	CreditCardPayment creditP2 = new CreditCardPayment(10.99, "Henry Win", LocalDate.now().plusYears(5), 45678);
	
	//printing out payment details for each 
	System.out.println("Payment Details:\n");
	System.out.println(cashP);
	System.out.println(cashP2);
	System.out.println(creditP);
	System.out.println(creditP2);
    }
}