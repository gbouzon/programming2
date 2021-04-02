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

package lab16;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/**
* Class based on Niloufar's lab 16 - Q6, Q7, Q8, Q9.
* @author Giuliana Bouzon
*/
public class Lab16 {
    
    //to be used throughout the class.
    static Scanner scan = new Scanner(System.in);
   
    /**
     * Prompts the user to enter a file name.
     * @return the entered String.
     */
    public static String retrieveFileName() {
	System.out.print("Please enter the name of the file: ");
	return scan.nextLine();
    }
    
    /**
     * Asks the user if it wants to delete a file.
     * @return the entered character.
     */
    public static char retrieveUserDecision() {
	System.out.print("Please enter 'y' if you'd like to delete the file: ");
	return scan.nextLine().charAt(0);
    }
    
    /**
     * Prompts the user to enter an advice.
     * @return the String entered.
     */
    public static String retrieveAdvice() {
	System.out.print("Please enter an advice: ");
	return scan.nextLine();
    }
    
    /**
     * Tests if a file exists.
     * For Q6.
     * @param fileName, the input file name.
     */
    public static void doesExist(String fileName) throws IOException {
	File file = new File(fileName);
	
	if (file.exists())
	    System.out.printf("%s '%s' %s.", "File", fileName, "does exist");
	else
	    System.out.printf("%s '%s' %s.", "File", fileName, "does not exist");
    }
    
    /**
     * Deletes an existing file depending on the user's choice.
     * For Q7.
     * @param fileName, the input file name (String).
     */
    public static void deleteFile(String fileName) throws IOException {	
	File file = new File(fileName);
	
	if (file.exists()) {
	    if (retrieveUserDecision() == 'y') {
		file.delete();
		System.out.printf("%s '%s' %s.", "File", fileName, "successfully deleted");
		return;
	    }
	    System.out.printf("%s '%s' %s.", "File", fileName, "has not been deleted");
	}
	else
	    System.out.printf("%s '%s' %s.", "File", fileName, "does not exist");
	    
    }
    
    /**
     * Removes extra blanks in a file.
     * For Q8.
     * @param fileName, the input file.
     * @throws FileNotFoundException
     */
    public static void removeExtraBlanks(String fileName) throws FileNotFoundException {
	//generating a temporary file name 
	String tempName = "temporary" + new Random().nextInt(10000);
	
	while (new File(tempName + ".txt").exists()) 
	    tempName += new Random().nextInt(10);
	
	tempName += ".txt";
	
	PrintWriter temp = new PrintWriter(new FileOutputStream(tempName));
	File ogFile = new File(fileName);
	
	String str = "";
	
	Scanner scan = new Scanner(ogFile);
	
	//writing to temporary file (only tokens)
	while (scan.hasNext()) {
	    str = scan.next();
	    temp.write(str + " ");
	}
	
	//closing files
	scan.close();
	temp.close();
	
	File tempFile = new File(tempName);
	
	scan = new Scanner(tempFile);
	PrintWriter original = new PrintWriter(new FileOutputStream(fileName));
	
	//writing back to the original file w extra blanks removed
  	while (scan.hasNextLine()) {
  	    str = scan.nextLine(); 
  	    original.println(str);
  	}
  	
  	//closing files
  	scan.close();
  	original.close();
  	tempFile.delete();
      	
  	System.out.println("Extra blanks successfully deleted.");
    }
    
    /**
     * Gives advice to the user and then takes an advice from the user.
     * For Q9.
     * @param fileName, the input file.
     * @throws IOException
     */
    public static void giveAdvice(String fileName) throws IOException {
	String advice = "";
	Scanner input = null;
	File advices = new File(fileName);
	
	if (advices.exists()) {
	    input = new Scanner(advices);
	    while (input.hasNext())
		advice = input.nextLine();
	    
	    System.out.println("Your advice is: " + advice);
	    input.close();
	}
	
	PrintWriter writer = new PrintWriter(new FileOutputStream(advices, true));
	writer.println(retrieveAdvice());
	writer.close();
	
	System.out.println("Your advice has been successfully transcribed.");
    }
    
    
    public static void main(String[] args) {
	try {
	    //testing Q6
	    doesExist(retrieveFileName());
	
	    //testing Q7
	    deleteFile(retrieveFileName());
	    
	    //testing q8
	    removeExtraBlanks(retrieveFileName());
	    
	    //testing q9
	    giveAdvice(retrieveFileName());
	}
	catch (IOException exception) {
	    System.out.println("Error with the file..");
	    exception.printStackTrace();
	}
    }
}