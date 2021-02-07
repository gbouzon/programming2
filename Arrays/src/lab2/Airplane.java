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
public class Airplane {
    private int nbOfPassengers;
    private double weight;
    private int maxSpeed;
	
    //default constructor
    public Airplane() {
	this.nbOfPassengers = 0;
	this.weight = 0.0;
	this.maxSpeed = 0;		
    }
	
    //parameterized constructor
    public Airplane(int nbOfPassengers, double weight, int maxSpeed) {
	this.nbOfPassengers = nbOfPassengers;
	this.weight = weight;
	this.maxSpeed = maxSpeed;
    }
	
    //copy constructor
    public Airplane (Airplane airplane) {
	this.nbOfPassengers = airplane.nbOfPassengers;
	this.weight = airplane.weight;
	this.maxSpeed = airplane.maxSpeed;
    }
	
    //accessor method for weight
    public double getWeight() {
	return this.weight;
    }
	
    //mutator method for weight
    public void setWeight(double weight) {
	this.weight = weight;
    }
	
    //accessor method for maxSpeed
    public int getMaxSpeed() {
	return this.maxSpeed;
    }
	
    //mutator method for maxSpeed
    public void setMaxSpeed(int speed) {
	this.maxSpeed = speed;
    }
	
    /**
    * Computes the average weight of the airplanes in Airplane array.
    * @param airplanes, the input array.
    * @return average weight
    */
    public static double getAverageWeight(Airplane[] airplanes) {
	double sum = 0;
	
	for (Airplane airplane : airplanes) 
	    sum += airplane.getWeight();
	
	return sum/airplanes.length;
    }
	
    /**
     * Finds the fastest airplane in the Airplane array.
     * @param airplanes, the input array.
     * @return fastest airplane in the array. However, if there are multiple 
     * airplanes with the same speed, returns null.
     */
    public static Airplane findFasterAirplane(Airplane[] airplanes) {
	Airplane fastest = airplanes[0]; 
	for(int i = 1; i < airplanes.length; i++) {
	    //checks if airplanes at bigger indexes are faster than the one at position 0. If it finds one, 
	    //the value of the 'fastest' variable is changed to contain that airplane object.
	    if(fastest.getMaxSpeed() < airplanes[i].getMaxSpeed()) { 
		fastest = airplanes[i];
	    }
	    else if(fastest.getMaxSpeed() == airplanes[i].getMaxSpeed()) {
		return null;
	    }
	}
	return fastest;
    }

    @Override
    public String toString() {
	String str = "";
		
	str += String.format("%-15s: %d\n", "# of passengers", nbOfPassengers);
	str += String.format("%-15s: %.2f\n", "Weight", weight);
	str += String.format("%-15s: %d\n", "Max speed", maxSpeed);
		
	return str;
    }
}
