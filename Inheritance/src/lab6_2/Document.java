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
* Class based on Niloufar's lab 6 - Q2, defines Document objects.
* @author Giuliana Bouzon
*/
public class Document {
    
    protected String text;
    
    //default constructor
    public Document() {
	this("");
    }
    
    //parameterized constructor
    public Document(String text) {
	this.text = (isNotNull(text)) ? text : "";
    }
    
    //copy constructor
    public Document(Document document) {
	this(document.text);
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

    @Override
    public String toString() {
	return String.format("%-10s: %s\n", "Text", text);
    }
    
    //getter and setter
    public String getText() {
	return this.text;
    }
    
    public void setText(String text) {
	if (isNotNull(text))
	    this.text = text;
    }
}