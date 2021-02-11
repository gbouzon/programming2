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

package lab7_2;

/**
* @author Giuliana Bouzon
*/
public class VehicleDemo {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	//creating different Vehicle objects
	Vehicle v1 = new Vehicle("Stellantis", 32, new Person("Albert Magnus"));
	Vehicle v2 = new Truck("Isuzu Motors", 3, new Person("Albert Magnus"), 2.3, 2309);
	
	
	//printing out objects, testing toString()
	System.out.println(v1);
	System.out.println(v2);
	
	//testing equals method
	System.out.println(v1.equals(v1));
	System.out.println(v1.equals(v2));
	System.out.println(v1.owner.equals(v2.owner));
    }
}
