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
* Class based on Niloufar's lab 7 - Q2, defines Vehicle objects.
* @author Giuliana Bouzon
*/
public class Vehicle {
    
    protected String manufacturer;
    protected int engineCylinders;
    protected Person owner;
    
    //default constructor
    public Vehicle() {
	this("", 0, new Person());
    }

    //parameterized constructor
    public Vehicle(String manufacturer, int engineCylinders, Person owner) {
	this.manufacturer = (manufacturer != null) ? manufacturer : "";
	this.engineCylinders = (engineCylinders >= 0) ? engineCylinders : 0;
	this.owner = (owner != null) ? owner : new Person(owner);
    }
    
    //copy constructor
    public Vehicle(Vehicle vehicle) {
	this(vehicle.manufacturer, vehicle.engineCylinders, new Person(vehicle.owner));
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Vehicle other = (Vehicle) obj;
	if (engineCylinders != other.engineCylinders)
	    return false;
	if (manufacturer == null) {
	    if (other.manufacturer != null)
		return false;
	} else if (!manufacturer.equals(other.manufacturer))
	    return false;
	if (owner == null) {
	    if (other.owner != null)
		return false;
	} else if (!owner.equals(other.owner))
	    return false;
	return true;
    }
    
    @Override
    public String toString() {
	String str = "";
	
	str += String.format("%-25s: %s\n", "Manufacturer", this.manufacturer);
	str += String.format("%-25s: %d\n", "# of Engine Cylinders", this.engineCylinders);
	str += String.format("%-25s: %s\n", "Owner", owner.toString());
		
	return str;
    }
    
    //getters and setter
    
    public String getManufacturer() {
	return this.manufacturer;
    }
    
    public void setManufacturer(String manufacturer) {
	if (manufacturer != null)
	    this.manufacturer = manufacturer;
    }
    
    public int getEngineCylinders() {
	return this.engineCylinders;
    }
    
    public void setEngineCylinders(int engineCylinders) {
	if (engineCylinders >= 0)
	    this.engineCylinders = engineCylinders;
    }
    
    public Person getOwner() {
	return this.owner;
    }
    
    public void setOwner(Person owner) {
	this.owner = new Person(owner);
    }
}
