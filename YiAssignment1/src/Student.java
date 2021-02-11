import java.util.Random;

/**
 * @author Giuliana Bouzon
 */
public class Student {
	
    //properties
    private String fName;
    private String lName;
    private int age;
    private Address address;
    private String email;
	
    //default constructor
    public Student() {
	this.fName = "";
	this.lName = "";
	this.age = 0;
	this.address = new Address();
	this.email = "";
    }
	
    //parameterized constructor, fName + lName
    public Student(String fName, String lName) {
	this.fName = fName;
	this.lName = lName;
	generateEmail();
    }
	
    //parameterized constructor, fName + lName + age + address
    public Student(String fName, String lName, int age, Address address) {
	this.fName = fName;
	this.lName = lName;
	this.age = age;
	this.address = address;
	generateEmail();
    }
	
    //copy constructor
    public Student(Student student) {
	this.fName = student.fName;
	this.lName = student.lName;
	this.age = student.age;
	//this.address = student.address; --this is a shallow copy, not good.
	this.address = new Address(student.address); //deep copy, right way of doing it.
    }
	
    /**
    * Generates an email based on: last name + first letter of first name + random 4-digit number + school signature
    */
    public void generateEmail() { //check this, format to have 4 digits: %04d
	int randomNumber = new Random().nextInt(10000); //put a bound of 10 000 exclusive since we only want 4 digit numbers.
	setEmail(this.lName.toLowerCase() + Character.toLowerCase(this.fName.charAt(0))+ randomNumber + "@vaniercollege.qc.ca");
    }
	
    /**
     * Converts a string to title-case format.
     * @param str, the input string.
     * @return the string in title-case format.
     */
    public String toTitleCase(String str) {
	String str2 = "";
		
	// if there's only one word
	if (!str.contains(" ")) 
	    return Character.toUpperCase(str.charAt(0)) + str.substring(1); //first character of a string is uppercase
		
	str2 += Character.toUpperCase(str.charAt(0));
		
	for (int i = 1; i < str.length(); i++) {
	    if (str.charAt(i - 1) == ' ' || str.charAt(i - 1) == '-') 
		str2 += Character.toUpperCase(str.charAt(i));
	    else
		str2 += Character.toLowerCase(str.charAt(i));				
	}
	return str2;
    }
	
    /**
     * Checks if two student objects are equal to one another.
     * @param input student object
     * @return true if the two student objects are an exact match, false if otherwise.
     */
    public boolean equals(Student student) {
	return this.fName.equals(student.fName)
		&& this.lName.equals(student.lName)
		&& this.age == student.age
		&& this.address.equals(student.address)
		&& this.email.equals(student.email);
    }

    @Override
    public String toString() { //add toTitleCase() method call somewhere??
	String str = "";
		
	str += String.format("%-10s: %s %s\n", "Name", fName, lName);
	str += String.format("%-10s: %d\n", "Age", age);
	str += String.format("%-10s: \n%s", "Address", address);
	str += String.format("%-10s: %s", "Email", email);
		
	return str;
    }
	
    //getters and setters
    public String getFName() {
	return this.fName;
    }
	
    public void setFName(String fName) {
	this.fName = fName;
    }
	
    public String getLName() {
	return this.lName;
    }
	
    public void setLName(String lName) {
	this.lName = lName;
    }
	
    public int getAge() {
	return this.age;
    }
	
    public void setAge(int age) {
	if (age > 0)
	    this.age = age;
    }
	
    public Address getAddress() {
	return this.address;
    }
	
    public void setAddress(Address address) {
	this.address = new Address(address);
    }
	
    public String getEmail() {
	return this.email;
    }
	
    public void setEmail(String email) {
	this.email = email;
    }
}
