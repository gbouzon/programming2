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

package lab4;

import java.util.Scanner;

/**
* Class based on Niloufar's lab 4.
* Teacher's code.
* @author Giuliana Bouzon
*/
public class MagicSquares {
    
    public static void main(String[] args) {
		
	System.out.print("Enter an odd integer: ");
	Scanner keyboard = new Scanner(System.in);
	int n = keyboard.nextInt();
	
	if (n % 2 == 0) {
	    System.out.print("n must be odd"); 
	    System.exit(0);
	}
			
	int[][] magic = new int[n][n];
		
	//set up first value at the bottom row in the middle
	int row = n - 1;
	int col = n / 2;
	magic[row][col] = 1;
		
	//set all the integers from 2 to n*n
	for (int i = 2; i <= (n * n); i++) {
			 
	    //try to go down one row (wrap around if needed)
	    //try to go right  (wrap around if needed)
			 
	    //if cell has not been assigned yet
	    if (magic[(row + 1) % n][(col + 1) % n] == 0) {
		row = (row + 1) % n;  //go down one row (wrap around if needed)
		col = (col + 1) % n;  //go right  (wrap around if needed)
	    }
	    
	    //if cell has not been assigned yet
	    else 
		row = (row - 1 + n) % n; // do not change the column
			 
	    magic[row][col] = i;  // set the next element
	}
	 
	//print the magic square
		 
	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < n; j++) {
		if (magic[i][j] < 10)	 
		    System.out.print(" "); //for alignment
			 
		if (magic[i][j] < 100)	 
		    System.out.print(" "); //for alignment
			 
		System.out.print(magic[i][j] + " ");
	    }
	    System.out.println(); 
	}
    }
}
