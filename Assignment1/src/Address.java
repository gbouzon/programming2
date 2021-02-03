/**
 * @author Giuliana Bouzon
 */
public class Address {
	
	//properties
	private String street;
	private int streetNum;
	private String city;
	private String zipCode;
	
	//default constructor
	public Address() {
		this.street = "";
		this.streetNum = 0;
		this.city = "";
		this.zipCode = "";
	}
	
	//parameterized constructor
	public Address(String street, int streetNum, String city, String zipCode) {
		this.street = street;
		this.streetNum = streetNum;
		this.city = city;
		this.zipCode = zipCode;
	}
	
	//copy constructor
	public Address(Address address) {
		this.street = address.street;
		this.streetNum = address.streetNum;
		this.city = address.city;
		this.zipCode = address.zipCode;
	}
	
	/**
	 * Converts a string to title-case format.
	 * @param str, the input string.
	 * @return the string in title-case format.
	 */
	public String toTitleCase(String str) {
		String str2 = "";
		
		// if there's only one word
		if (!str.contains(" ")) //spacing: ALWAYS add space before and after () for loops and conditional statements
			return Character.toUpperCase(str.charAt(0)) + str.substring(1); //first character of a string is uppercase
		
		str2 += Character.toUpperCase(str.charAt(0));
		
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i-1) == '-' || str.charAt(i-1) == ' ') 
				str2 += Character.toUpperCase(str.charAt(i));
			else
				str2 += Character.toLowerCase(str.charAt(i));				
		}
		return str2;
	}

	/**
	 * Checks if two addresses are equal to one another.
	 * @param input address
	 * @return true if the two addresses are an exact match
	 */
	public boolean equals(Address address) {
		return this.street.equals(address.street)
				&& this.streetNum == address.streetNum
				&& this.city.equals(address.city)
				&& this.zipCode.equals(address.zipCode);
	} 

	@Override
	public String toString() {
		String str = "";
		
		str += String.format("%-10s: %d, %s\n", "Street", streetNum, toTitleCase(this.street));
		str += String.format("%-10s: %s\n", "City", toTitleCase(this.city));
		str += String.format("%-10s: %s\n", "ZipCode", this.zipCode.toUpperCase());
		
		return str;
	}
	
	//getters and setters for properties
	//always put getters and setters at the end of class
	public String getStreet() {
		return this.street;
	}
	
	public void setStreet(String street) {
		this.street = toTitleCase(street);
	}
	
	public int getStreetNum() {
		return this.streetNum;
	}
	
	public void setStreetNum(int streetNum) {
		this.streetNum = streetNum;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public void setCity(String city) {
		this.city = toTitleCase(city);
	}
	
	public String getZipCode() {
		return this.zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode.toUpperCase();
	}
}
