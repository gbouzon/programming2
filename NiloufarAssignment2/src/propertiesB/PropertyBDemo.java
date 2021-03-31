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

package propertiesB;

/**
 * A java application class that tests properties defined in PropertyB, SFHome and Condo classes.
 */

/**
* Assignment 2
* Class PropertyDemoB - driver class for PropertyB
* @author Giuliana Bouzon 
* For Programming II Section 00002 - Winter 2021
* Submitted on March 25th, 2021
*/
public class PropertyBDemo {
    
    /**
     * Creates a string of an array's objects' toString()
     * @param objs, the Object array
     * @return the string containing the information of the objects in the array.
     */
    public static String toString(Object[] objs) {
	String str = "";
	for (Object obj : objs) 
	    str += obj.toString() + "\n";
	
	return str;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	System.out.println("    Welcome to ABC Property!\n");
	
	//creating PropertyB objects
	PropertyB propertyB = new Condo("7 Main St.", 1, 2, 2012, (float) 0.1);
	PropertyB propertyB2 = new Condo("20 Square St.", 2, 1, 2020, (float) 0.02);
	PropertyB propertyB3 = new SFHome("65 Rue College", 3, 3, 1988, (float) 0.2);
	PropertyB propertyB4 = new SFHome("110 Flowers Road", 1, 4, 1992, (float) 0.15);

	//creating an array of propertiesB
	PropertyB[] bProperties = {propertyB, propertyB2, propertyB3, propertyB4};
		
	//printing out the array
	System.out.print(toString(bProperties)); 
	System.out.println("Thank you for using our investment analysis software!");
    }
}