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

package lab5;

/**
* Class based on Niloufar's lab 5.
* @author Giuliana Bouzon
*/
public class Waypoint {
    private double x, y;
    private int timeStamp;
	
    //default constructor
    public Waypoint() {
	this.x = 0;
	this.y = 0;
	this.timeStamp = 0;
    }
	
    //parameterized constructor
    public Waypoint(double x, double y, int timeStamp) {
	this.x = x;
	this.y = y;
	this.timeStamp = timeStamp;
    }
	
    //copy constructor
    public Waypoint(Waypoint waypoint) {
	this.x = waypoint.x;
	this.y = waypoint.y;
	this.timeStamp = waypoint.timeStamp;
    }
    
    @Override
    public String toString() {
	return String.format("%-10s: %0.1f, %0.1f\n, %d\n", "Coordinate", x, y, timeStamp);
    }

    //getters and setters
    public double getX() {
	return this.x;
    }
	
    public void setX(double x) {
	this.x = x;
    }
	
    public double getY() {
	return this.y;
    }
	
    public void setY(double y) {
	this.y = y;
    }
	
    public int getTimeStamp() {
	return this.timeStamp;
    }
	
    public void setTimeStamp(int timeStamp) {
	this.timeStamp = timeStamp;
    }
}
