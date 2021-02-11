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
* Class defining a Truck object, child class of Vehicle.
* @author Giuliana Bouzon
*/
public class Truck extends Vehicle{
    
    private double loadCapacity;
    private int towingCapacity;
    
    //default constructor
    public Truck() {
	super();
	this.loadCapacity = 0;
	this.towingCapacity = 0;
    }
    
    //parameterized constructor
    public Truck(String manufacturer, int engineCylinders, Person owner, double loadCapacity, int towingCapacity) {
	super(manufacturer, engineCylinders, owner);
	this.loadCapacity = (loadCapacity >= 0) ? loadCapacity : 0;
	this.towingCapacity = (towingCapacity >= 0) ? towingCapacity : 0;
    }
    
    //copy constructor
    public Truck(Truck truck) {
	this(truck.manufacturer, truck.engineCylinders, truck.owner, truck.loadCapacity, truck.towingCapacity);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (!super.equals(obj))
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Truck other = (Truck) obj;
	if (Double.doubleToLongBits(loadCapacity) != Double.doubleToLongBits(other.loadCapacity))
	    return false;
	if (towingCapacity != other.towingCapacity)
	    return false;
	return true;
    }
    
    @Override
    public String toString() {
	String str = "";
	
	str += String.format("%-25s: %s\n", "Type of Vehicle", "Truck");
	str += String.format("%-25s: %.2f\n", "Load Capacity (tons)", this.loadCapacity);
	str += String.format("%-25s: %d\n", "Towing Capacity (pounds)", this.towingCapacity);
		
	return super.toString() + str;
    }
    
    //getters and setters
    
    public double getLoadCapacity() {
	return this.loadCapacity;
    }
    
    public void setLoadCapacity(double loadCapacity) {
	if (loadCapacity >= 0)
	    this.loadCapacity = loadCapacity;
    }
    
    public int getTowingCapacity() {
	return this.towingCapacity;
    }
    
    public void setTowingCapacity(int towingCapacity) {
	if (towingCapacity >= 0)
	    this.towingCapacity = towingCapacity;
    }
}
