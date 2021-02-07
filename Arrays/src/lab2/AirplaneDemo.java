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

package lab2;

/**
*
* @author Giuliana Bouzon
*/
public class AirplaneDemo {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
		
	Airplane airplane1 = new Airplane(100, 7.5, 1029);
	Airplane airplane2 = new Airplane(400, 27, 768);
	Airplane airplane3 = new Airplane(20, 1.5, 1674);
	Airplane airplane4 = new Airplane(175, 14, 954);

	Airplane[] airplanes = {airplane1, airplane2, airplane3, airplane4};
		
	//demo for methods in Airplane class
	System.out.println(Airplane.getAverageWeight(airplanes));
	System.out.println(Airplane.findFasterAirplane(airplanes));
    }
}
