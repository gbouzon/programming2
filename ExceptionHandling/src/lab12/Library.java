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

package lab12;

import java.util.Random;

/**
 * Class based on Niloufar's lab 12 - Q19.
 * @author Giuliana Bouzon
 */
public class Library {

    //properties
    private int accountId;
    private String holderName;
    private int numberOfBooksBorrowed;
    private int maxNumberOfBooksAllowed;
    
    //default constructor
    public Library() {
	this("", 0);
    }
    
    //parameterized constructor
    public Library(String holderName, int maxNumberOfBooksBorrowed) {
	generateId();
	setHolderName(holderName);
	this.maxNumberOfBooksAllowed = (maxNumberOfBooksBorrowed > 0) ? maxNumberOfBooksBorrowed : 0;
	this.numberOfBooksBorrowed = 0;
    }
    
    //copy constructor
    public Library(Library library) {
	this(library.holderName, library.numberOfBooksBorrowed);
    }
    
    /**
     * Generates a random number (smaller than 10 000) as the account id.
     */
    public void generateId() {
	this.accountId = new Random().nextInt(10000); //generating a random number for account id
    }
    
    /**
     * Allows the user to borrow a book as long as it doesn't exceed the maximum allowed.
     * @param numberOfBooks, the input number of books.
     * @throws BorrowException if the number of books borrowed exceed the maximum allowed.
     */
    public void borrowBooks(int numberOfBooks) throws BorrowException {
	if (numberOfBooks < 0 || this.numberOfBooksBorrowed + numberOfBooks > this.maxNumberOfBooksAllowed)
	    throw new BorrowException();
	
	else
	    this.numberOfBooksBorrowed += numberOfBooks;
    }
    
    @Override
    public String toString() {
	return String.format("%s '%d', %s, %s %d %s.", "Client", this.accountId, this.holderName, 
		"has borrowed", this.numberOfBooksBorrowed, "books");
    }
    

    //getters and setters

    public int getAccountId() {
	return this.accountId;
    }
    
    public String getHolderName() {
	return this.holderName;
    }
    
    public void setHolderName(String holderName) {
	this.holderName = (holderName != null && !holderName.isEmpty()) ? holderName : "noName";
    }
    
    //no setter for books borrowed because the user has to go through the borrow books method to be able to
    //set the number of books borrowed.
    public int getNumberOfBooksBorrowed() {
	return this.numberOfBooksBorrowed;
    }
}