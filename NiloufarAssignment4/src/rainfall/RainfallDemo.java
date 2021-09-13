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

package rainfall;

import java.util.Arrays;
import javax.swing.JFrame;

/**
 * A java application class that tests the Rainfall class and its corresponding bar graph (Graph).
 */

/**
 * Assignment 4
 * Class RainfallDemo
 * @author Giuliana Bouzon - 1940108
 * For Programming II Section 00002 - Winter 2021
 * Submitted on May 17th, 2021
 */
public class RainfallDemo {
    
    /**
     * Generates an array corresponding to the 12 months of the year and the collected precipitation data.
     * @return the generated array.
     */
    public static Rainfall[] generateArray() {
	//chose random values to test graph
	Rainfall[] rainfalls = {new Rainfall("January", 175), new Rainfall("February", 288), 
		new Rainfall("March", 163), new Rainfall("April", 145), new Rainfall("May", 40),
		new Rainfall("June", 138), new Rainfall("July", 35), new Rainfall("August", 30), 
		new Rainfall("September", 136), new Rainfall("October", 243), 
		new Rainfall("November", 48), new Rainfall("December", 158)};
	
	return rainfalls;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	//creating array of 12 Rainfall objects
	Rainfall[] rainfalls = generateArray();
	
	//sorting the array
	Arrays.sort(rainfalls);
	
	//printing out table header + skipping a line
	System.out.printf("%s \t %s \n\n", "Month", "Precipitation(mm)");
	
	//printing the resulting array
	for (Rainfall r : rainfalls) {
	    System.out.print(r + "\n");
	}
	
	//creating a JFrame
	JFrame frame = new JFrame("Rainfall Graph");
	//setting close operation as instructed in class
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	//creating a Graph object 
	Graph graph = new Graph();
	//adding the Graph object to the frame
	frame.add(graph); 
	
	//setting the size of the window
	frame.setSize(1000, 600); 
	//making the window visible to the user/whoever is running the program
	frame.setVisible(true); 
    }
}