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
* Driver class for Document project (lab 6, Q2)
* @author Giuliana Bouzon
*/
public class DocumentDemo {
    
    /**
     * Checks if the Document object contains the specified keyword in its 'text' property.
     * @param docObject, the input document.
     * @param keyword, the word to be searched.
     * @return true if the Document object contains the specified keyboard. 
     */
    public static boolean containsKeyword(Document docObject, String keyword) {
	if (docObject.toString().indexOf(keyword, 0) >= 0)
	    return true;
	
	return false;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

	//creating Email objects - text, sender, recipient, subject
	Email email1 = new Email("Hello, you suck", "Giuliana Bouzon", "Niloufar", "Message");
	Email email2 = new Email("Hello, YIKES", "Niloufar", "Giuliana Bouzon", "Reply");
	
	//creating File objects - text, pathName
	File file1 = new File("Message", "Email");
	File file2 = new File("Reply", "Email");
	
	/**testing toString()
	System.out.println(email1);
	System.out.println(email2);
	System.out.println(file1);
	System.out.println(file2);
	*/
	
	//testing containsKeyword()
	System.out.println(containsKeyword(email1, "teehee"));
	System.out.println(containsKeyword(file2, "Reply"));
    }
}