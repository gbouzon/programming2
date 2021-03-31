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
* Class based on Niloufar's lab 15 - Q10
* Counts occurrences of the number 10 in a text file.
* @author Giuliana Bouzon
*/
public class Lab15 {
    
    /**
     * Counts occurrences of a specific number in a file.
     * Q10 of lab 15.
     * @param data, the number to be counted.
     * @param input, the scanner object containing the file.
     * @return the number of occurrences of the specified number in the file.
     * @throws IOException
     */
    public static int countOccurences(int data, Scanner input) throws IOException {
	int count = 0;
	int number;
	
	while (input.hasNextInt()) {
	    number = input.nextInt();
	    if (number == data)
		count++;
	}
	
	return count;
    }
    
    public static int countElements() throws IOException {
	Scanner input = new Scanner(new FileInputStream("Lab15Q11.txt"));
	
	int count = 0;
	
	while (input.hasNextDouble()) {
	    input.next();
	    count++;
	}
	input.close();
	return count; 
    }
    
    /**
     * Calculates the average of double values in a file.
     * Q11 of lab 15.
     * @param input, the scanner object containing the file.
     * @return the calculated average.
     * @throws IOException
     */
    public static double calculateAverage() throws IOException {
	Scanner input = new Scanner(new FileInputStream("Lab15Q11.txt"));
	
	double sum = 0;
	int count = 0;
	double number;
	
	while (input.hasNextDouble()) {
	    number = input.nextDouble();
	    count++;
	    sum += number;
	}
	
	input.close();
	
	if (count != 0)
	    return sum / count;
	
	return 0;
    }
    
    /**
     * Calculates the standard deviation of a list of numbers in a file.
     * @param average
     * @param count
     * @return
     * @throws IOException
     */
    public static double calculateStandardDeviation(double average, int count) throws IOException {
	double number;
	double sum = 0;
	
	Scanner input = new Scanner(new FileInputStream("Lab15Q11.txt"));
	
	if (count == 0) {
	    input.close();
	    return 0;
	}
	
	for (int i = 0; i <= count; i++) 
	    while (input.hasNextDouble()) {
		number = input.nextDouble();
		sum += (number - average) * (number - average);
		
	    }
	
	input.close();
	
	return Math.sqrt(sum / count);
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	//testing Q10
	try {
	    Scanner inputStream = new Scanner(new FileInputStream("Lab15Q10.txt"));
	    System.out.println("Total occurrences: " + countOccurences(10, inputStream));
	}
	catch (IOException exception) {
	    System.out.println("Error reading from the file.");
	}
	
	//testing Q11
	try {
	    System.out.printf("%s: %.2f\n", "Average is", calculateAverage());
	}
	catch (IOException exception) {
	    System.out.println("Error reading from the file");
	}
	
	//testing Q12
	try {
	    System.out.printf("%s: %.2f", "Standard deviation is", calculateStandardDeviation(calculateAverage(), countElements()));
	}
	catch (IOException exception) {
	    System.out.println("Error reading from the file");
	}
    }
}
