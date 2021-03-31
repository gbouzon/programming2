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

package lab15;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
* Class based on Niloufar's lab 15 - Q9
* @author Giuliana Bouzon
*/
public class Names {
    
    //static Scanner to be used throughout the class
    static Scanner scan = new Scanner(System.in);
    
    /**
     * Prompts the user to enter the desired option.
     * The user is allowed to search by either rank or name.
     * @return the option (a character).
     */
    public static char retrieveOption() {
	System.out.print("Please enter 'r' to search per rank or 'n' to search per name: ");
	return scan.nextLine().charAt(0);
    }
    
    /**
     * Prompts the user to enter the gender (girl or boy).
     * @return the gender (a character).
     */
    public static char retrieveGender() {
	System.out.print("Please enter 'g' for girl or 'b' for boy: ");
	return scan.nextLine().charAt(0);
    }
    
    /**
     * Prompts the user to enter the name it is looking for.
     * @return the entered name.
     */
    public static String retrieveName() {
	System.out.print("Please enter the name you are looking for: ");
	return scan.nextLine();
    }
    
    /**
     * Prompts the user to enter the rank it is looking for.
     * @return the entered rank.
     */
    public static int retrieveRank() {
	System.out.print("Please enter the rank: ");
	return scan.nextInt();
    }
    
    /**
     * Looks for the specified name in the array of 1000 names (boy or girl) and its respective score.
     * @param names, the input names array.
     * @param scores, the input score array.
     * @param gender, the specified gender.
     */
    public static void findInformationByName(String[] names, int[] scores, String gender) {
	String savedName = retrieveName();
	int savedScore = 0;
	int position = 0;
	
	for (int i = 0; i < names.length; i++) { 
	    if (savedName.equalsIgnoreCase(names[i])) {
		savedName = names[i];
		savedScore = scores[i];
		position = i + 1;
		System.out.printf("%s %s %d %s %s %s %d %s.", savedName, "is ranked", position,
			"in popularity among", gender, "with", savedScore, "namings");
		return;
	    }	
	}
	System.out.printf("%s %s %s %s", savedName, "is not ranked among the top 1000", 
		gender, "names");
    }
    
    /**
     * Looks for the specified rank in the names array and its respective score.
     * @param names, the input names array.
     * @param scores, the input score array.
     * @param gender, the specified gender.
     */
    public static void findInformationByRank(String[] names, int[] scores, String gender) {
	int rank = retrieveRank();
	
	if (rank > 0 && rank < 1001) {
	    System.out.printf("%s %s %d %s %s %s %d %s.", names[rank - 1], "is ranked", rank,
			"in popularity among", gender, "with", scores[rank - 1], "namings");
	}
	else {
	    System.out.println("Rank is not valid");
	}
    }
    
    public static void main(String[] args) {
	
	//array for the names
	String[] girlNames = new String[1000];
	String[] boyNames = new String[1000];
	
	
	
	//array for the scores
	int[] girlNamings = new int[1000];
	int[] boyNamings = new int[1000];
	
	//temporary variables
	String name;
	int score;
	int i = 0;
	
	//scanner objects to read the files
	Scanner girlFile = null;
	Scanner boyFile = null;
	
	//do a try-with-resources later oki?
	try {
	    girlFile = new Scanner(new FileInputStream("girlnames.txt"));
	    
	    while (girlFile.hasNext()) {
		name = girlFile.next();
		girlNames[i] = name;
		score = girlFile.nextInt();
		girlNamings[i] = score;
		i++;
	    }
	    
	    i = 0;
	    
	    boyFile = new Scanner(new FileInputStream("boynames.txt"));
	    
	    while (boyFile.hasNext()) {
		name = boyFile.next();
		boyNames[i] = name;
		score = boyFile.nextInt();
		boyNamings[i] = score;
		i++;
	    }
	}
	catch (IOException exception) {
	    System.out.println("File error..");
	}
	
	//closing stream
	girlFile.close();
	boyFile.close();
	
	//getting user option
	char gender = retrieveGender();
	char option = retrieveOption();
	
	//returning appropriate message
	if (gender == 'g') {
	    if (option == 'r')
		findInformationByRank(girlNames, girlNamings, "girls");
	    else if (option == 'n')
		findInformationByName(girlNames, girlNamings, "girls");
	    else 
		System.out.println("Option not recognized");
	}
	else if (gender == 'b') {
	    if (option == 'r')
		findInformationByRank(boyNames, boyNamings, "boys");
	    else if (option == 'n')
		findInformationByName(boyNames, boyNamings, "boys");
	    else
		System.out.println("Option not recognized");
	}
	else
	    System.out.println("Gender not recognized");
    }
}
