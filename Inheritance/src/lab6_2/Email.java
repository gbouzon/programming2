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

package lab6_2;

/**
* Class defining an Email object, child class of Document.
* @author Giuliana Bouzon
*/
public class Email extends Document {
    
    private String sender;
    private String recipient;
    private String subjectLine;
    
    //default constructor
    public Email() {
	this("", "", "", "");
    }
    
    //parameterized constructor
    public Email(String text, String sender, String recipient, String subjectLine) {
	super(text);
	this.sender = (isNotNull(sender)) ? sender : "";
	this.recipient = (isNotNull(recipient)) ? recipient : "";;
	this.subjectLine = (isNotNull(subjectLine)) ? subjectLine : "";
    }
    
    //copy constructor
    public Email(Email email) {
	this(email.text, email.sender, email.recipient, email.subjectLine);
    }
    
    @Override
    public String toString() {
	String str = "";
	
	str += String.format("%-10s: %s\n", "Sender", sender);
	str += String.format("%-10s: %s\n", "Recipient", recipient);
	str += String.format("%-10s: %s\n", "Subject", subjectLine);
	
	return str + super.toString();
    }
    
    //getters and setters
    
    public String getSender() {
	return this.sender;
    }
    
    public void setSender(String sender) {
	if (isNotNull(sender))
	    this.sender = sender;
    }
    
    public String getRecipient() {
	return this.recipient;
    }
    
    public void setRecipient(String recipient) {
	if (isNotNull(recipient))
	    this.recipient = recipient;
    }
    
    public String getSubjectLine() {
	return this.subjectLine;
    }
    
    public void setSubjectLine(String subjectLine) {
	if (isNotNull(subjectLine))
	    this.subjectLine = subjectLine;
    }  
}