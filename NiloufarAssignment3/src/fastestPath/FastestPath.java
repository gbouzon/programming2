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

package fastestPath;

import java.util.Arrays;
import java.util.Random;

/**
 * The game of “FastestPath” consists of a path (a 1-D array) with n positive integers to represent n 
 * cities in a path (except the first index which has always value 0). The aim of the game is to move 
 * from the source city (located at index 0) to destination (located at last index) in the shortest time. 
 * The value at each index shows the travel time to enter the city located in the corresponding index.
 */

/**
 * Assignment 3
 * Class FastestPath
 * @author Giuliana Bouzon - 1940108
 * For Programming II Section 00002 - Winter 2021
 * Submitted on April 23rd, 2021
 */
public class FastestPath {
    
    /**
     * Generates a random array of length no bigger than 30.
     * The elements of the array are generated randomly and cannot exceed 200.
     * @return the filled array.
     */
    public static int[] generateArray() {
	int random = new Random().nextInt(30);
	int length = (random > 3) ? random : 3;
	int[] cities = new int[length];
	
	for (int i = 1; i < cities.length; i++) //starting from since first element is always 0
	    cities[i] = new Random().nextInt(200);
	
	return cities;
    }
    
    /**
     * Computes the shortest travel time from position 0 of the array until position length - 1
     * by following predefined rules.
     * @param array, the input int array.
     * @param sum, the input int sum (to compute the sum with each iteration of the method).
     * @return the shortest travel time as defined.
     */
    public static int computeTravelTime(int[] array, int sum) {
        int[] copy;

        if (array.length == 0)
            return sum;
        
        if (array.length > 0 && array.length <= 3) //doing this to make sure we don't get a null pointer in terms of the array length
            return sum += array[array.length - 1];

        //intializing the copy array after checking which position would make for the shortest path
        copy = (array[1] < array[2]) ? new int[array.length - 1] : new int[array.length - 2]; 

        //creating the copy array and adding elements to it according to previously defined rules, check line above ^
        copy = (array.length - copy.length == 1) ? Arrays.copyOfRange(array, 1, array.length)
                : Arrays.copyOfRange(array, 2, array.length);

        return computeTravelTime(copy, sum) + copy[0];
    }
    
    public static void main(String[] args) {
	
	//testing output from assignment pdf
	//int[] cities = {0, 15, 27, 9, 12, 26, 32}; //answer 68
	//int[] cities = {0, 5, 90, 7, 61, 12}; //answer 24
	
	//generating random path array
	int[] cities = generateArray();
	
	System.out.println(">>>>>>>>>> Welcome to Fastest Path <<<<<<<<<<");
	System.out.println("For the following path:\n" + Arrays.toString(cities));
	System.out.println("The shortest time to the end is " + computeTravelTime(cities, 0));
    }
}