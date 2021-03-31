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

package properties;

import java.time.LocalDate;

/**
 * A Property has an address (actual address of the property), a zoneCode (indicates zone of the property
 * and may contain values 1, 2 and 3), a number of bedrooms, a year of construction, a risk factor dealing
 * with risks related to investments in the real estate market (must be in the range (0.0, 1.0)) and a type
 * that indicates whether the property is a condo or a single-family home.
 * This corresponds to question 1-a of the Assignment2 pdf.
 */

/**
 * Assignment 2
 * Class Property
 * @author Giuliana Bouzon
 * For Programming II Section 00002 - Winter 2021
 * Submitted on March 25th, 2021
 */
public class Property {
    
    //properties
    private String address;
    private int zoneCode;
    private int nbBedrooms;
    private int constructionYear;
    private float riskFactor; 
    private String type;
    private int basePrice;
    
    //this array defines the valid zone codes
    private static final int[] VALID_ZONES = {1, 2, 3}; 
    
    //this variable is used to count the number of properties AT PRINT TIME
    //FOR PRINTING ONLY
    static int nbProperties = 0;
    
    //default constructor
    public Property() {
	this("Canada", 3, 1, 1864, 0, "Condo"); //these are the default values I chose
    }
    
    //parameterized constructor
    //used setters to have less code repetition
    public Property(String address, int zoneCode, int nbBedrooms, int constructionYear, 
	    float riskFactor, String type) {
	setAddress(address);
	setZoneCode(zoneCode);
	setNbBedrooms(nbBedrooms);
	setConstructionYear(constructionYear);
	setRiskFactor(riskFactor);
	setType(type);
	setBasePrice(type, zoneCode);
    }
    
    //copy constructor
    public Property(Property property) {
	this(property.address, property.zoneCode, property.nbBedrooms, property.constructionYear, 
		property.riskFactor, property.type);
    }
    
    /**
     * Checks if the zone is valid (can only be 1, 2 or 3).
     * @param zone, the input integer value for the zone.
     * @return true if it's valid and false if otherwise.
     */
    private boolean isValidZone(int zone) { 
	for (int validZone : VALID_ZONES)
	    if (validZone == zone)
		return true;
	
	return false;
    }
    
    /**
     * Sets the basePrice for properties according to the specified rules.
     */
    private void setBasePrice(String type, int zoneCode) { 
	if (type.equalsIgnoreCase("Condo")) {
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
	
	else if (type.equalsIgnoreCase("SFHome")) {
	    switch (zoneCode) {
	    	case 1:
	    	    this.basePrice = 500000;
	    	    break;
	    	case 2:
	    	    this.basePrice = 400000;
	    	    break;
	    	case 3:
	    	    this.basePrice = 300000;
	    	    break;
	    	default:
	    	    System.out.println("Error with the zone code, please check me ;(");
	    	    System.exit(0); 
	    }
	}
    }
    
    /**
     * Calculates the price of the property according to a specified formula.
     * @return the price of the property.
     */
    private double evaluatePrice() { 
	return this.basePrice + (this.basePrice * this.nbBedrooms * 0.05) + 
		((this.constructionYear * 100) / 2);
    }
    
    /**
     * Calculates the investment analysis according to a specified rule.
     * @return the investment analysis.
     */
    private double analyzeInvestment() {
	return this.riskFactor * 50;
    }
    
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Property other = (Property) obj;
	if (this.address == null) {
	    if (other.address != null)
		return false;
	} else if (!this.address.equals(other.address))
	    return false;
	if (this.constructionYear != other.constructionYear)
	    return false;
	if (this.nbBedrooms != other.nbBedrooms)
	    return false;
	if (Double.doubleToLongBits(this.riskFactor) != Double.doubleToLongBits(other.riskFactor))
	    return false;
	if (this.type == null) {
	    if (other.type != null)
		return false;
	} else if (!this.type.equals(other.type))
	    return false;
	if (this.zoneCode != other.zoneCode)
	    return false;
	return true;
    }
    
    @Override 
    public String toString() {
	String str = "";
	
	str += String.format("%s %d\n", "Property", ++nbProperties); 
	str += String.format("%-20s: %s\n", "Type", this.type);
	str += String.format("%-20s: %s\n", "Address", this.address);
	str += String.format("%-20s: %d\n", "Zone", this.zoneCode);
	str += String.format("%-20s: %d\n", "No. of Bedrooms", this.nbBedrooms);
	str += String.format("%-20s: %d\n", "Year of Construction", this.constructionYear);
	str += String.format("%-20s: %.2f\n", "Risk Factor", this.riskFactor);
	str += String.format("\n%-20s: %.2f\n", "Investment Analysis", analyzeInvestment());
	str += String.format("%-20s: $%.2f\n--------------------------------\n", "Evaluated Price", 
		evaluatePrice());
		
	return str;
    }
    
    //getters and setters

    public String getAddress() {
	return this.address;
    }
    
    public void setAddress(String address) {
	if (address != null && !address.isEmpty())
	    this.address = address;
	else {
	    System.out.println("Address cannot be null.");
	    System.exit(0);
	}
    }
    
    public int getZoneCode() {
	return this.zoneCode;
    }
    
    public void setZoneCode(int zoneCode) {
	if (isValidZone(zoneCode))
	    this.zoneCode = zoneCode;
	else {
	    System.out.println("Invalid zone code.");
	    System.exit(0);
	}
    }
    
    public int getNbBedrooms() {
	return this.nbBedrooms;
    }
    
    public void setNbBedrooms(int nbBedrooms) {
	if (nbBedrooms >= 1)
	    this.nbBedrooms = nbBedrooms;
	else {
	    System.out.println("Must have at least one bedroom.");
	    System.exit(0);
	}
    }
    
    public int getConstructionYear() {
	return this.constructionYear;
    }
    
    public void setConstructionYear(int constructionYear) {
	//1700 is just a base year, and because it can't be after the current year
	if (constructionYear >= 1700 && constructionYear <= LocalDate.now().getYear()) 
	    this.constructionYear = constructionYear;
	else {
	    System.out.println("Invalid year.");
	    System.exit(0);
	}
    }
    
    public double getRiskFactor() {
	return this.riskFactor;
    }
    
    public void setRiskFactor(float riskFactor) {
	if (riskFactor >= 0 && riskFactor <= 1)
	    this.riskFactor = riskFactor;
	else {
	    System.out.println("Invalid risk factor.");
	    System.exit(0);
	}
    }
    
    public String getType() {
	return this.type;
    }
    
    public void setType(String type) {
	if (type.equalsIgnoreCase("Condo") || type.equalsIgnoreCase("SFHome"))
	    this.type = type;
	else {
	    System.out.println("Invalid property type.");
	    System.exit(0);
	}
    }
    
    public double getBasePrice() {
	return this.basePrice;
    }
}