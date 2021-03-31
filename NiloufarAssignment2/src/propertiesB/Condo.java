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
 * A Condo has an address (actual address of the property), a zoneCode (indicates zone of the property
 * and may contain values 1, 2 and 3), a number of bedrooms, a year of construction, a risk factor dealing
 * with risks related to investments in the real estate market (must be in the range (0.0, 1.0)).
 * Subclass of PropertyB - defines Condo properties.
 * This corresponds to question 1-b of the Assignment2 pdf.
 */

/**
* Assignment 2
* Class Condo - question 1-b 
* @author Giuliana Bouzon 
* For Programming II Section 00002 - Winter 2021
* Submitted on March 25th, 2021
*/
public class Condo extends PropertyB {
    
    //default constructor
    public Condo() {
	super();
    }
    
    //parameterized constructor
    public Condo(String address, int zoneCode, int nbBedrooms, int constructionYear, 
	    float riskFactor) {
	super(address, zoneCode, nbBedrooms, constructionYear, riskFactor);
    }
    
    //copy constructor
    public Condo(Condo condo) {
	this(condo.address, condo.zoneCode, condo.nbBedrooms, condo.constructionYear, 
		condo.riskFactor);
    }
    
    @Override
    public void setBasePrice(int zoneCode) {
	switch (zoneCode) {
    	    case 1:
    	        this.basePrice = 300000;
    	        break;
    	    case 2:
    		this.basePrice = 200000;
    		break;
    	    case 3:
    		this.basePrice = 100000;
    		break;
    	    default:
    		System.out.println("Error with the zone code, please check me ;(");
    		System.exit(0); 
	}
    }
    
    @Override
    public double evaluatePrice() {
	return basePrice + (basePrice * nbBedrooms * 0.05) + 
		((constructionYear * 100) / 2);
    }
    
    @Override
    public double analyzeInvestment() {
	return this.riskFactor * 50;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (!super.equals(obj))
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	return true;
    }
    
    @Override
    public String toString() {
	String str = "";
	
	str += String.format("%s %d\n", "Property", ++nbProperties);
	str += String.format("%-20s: %s\n", "Type", "Condo");
	str += super.toString();
	
	return str;
    }
}