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

package arraysExercise;

/**
* Class based on Niloufar's lab 3.
* @author Giuliana Bouzon
*/
public class Arrays2d {
    
    // constructor
    public Arrays2d() {
	String[] ary = new String[6];
	load(ary);
	dump(ary);
    }

    // teacher method
    public void load(String[] ary) {
	for (int n = 1; n < ary.length; n += 2) {
	    ary[n - 1] = "Pos: " + n;
	    ary[n] = "Neg: " + (-n - 1);
	}
    }

    // teacher method
    public void dump(String[] ary) {
	for (int n = 0; n < ary.length; n++)
	    System.out.println(ary[n]);
	System.out.println();
    }

    /**
     * Takes the sum of the diagonals of a 2d array.
     *
     * @param nums, the input array
     * @return the sum of the diagonals
     */
    public static int sum(int[][] nums) {
	int sum = 0;

	for (int i = 0; i < nums.length; i++)
	    sum += nums[i][i] + nums[i][nums.length - 1 - i];
	if (nums.length % 2 != 0)
	    return sum - nums[nums.length / 2][nums.length / 2];
	
	return sum;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

	// code output questions, A.
	//teacher code
	String[][] animals = { 
		{ "dog", "cat", "fish", "bird", "worm" }, 
		{ "lion", "baboon", "bison", "beaver" },
		{ "bear", "bat", "ant", "bobcat", "buffalo", "elephant" },
		{ "crab", "coyote", "cow", "frog", "goat", "grissly" } };
		
	for (int i = 0; i < animals.length; i++) {
	    System.out.print("[" + i + "][" + 0 + "]" + animals[i][0] + " --");
	    for (int j = 1; j < animals[i].length; j++)
		System.out.print("[" + i + "][" + j + "]" + animals[i][j] + " ");
	    System.out.println();
	}

	// B
	char ch = 'A';
	char[][] ary = new char[5][];
	for (int k = 0; k < ary.length; k++) {
	    ary[k] = new char[k + 1];
	    for (int j = 0; j < ary[k].length; j++)
		ary[k][j] = ch++;
	}

	// C
	new Arrays2d();

	// Q3, my tests for displaying sum for square arrays. 
	int[][] nums = { { 1, 2, 3 }, { 5, 6, 7 }, { 9, 10, 11 } };
	System.out.println(Arrays2d.sum(nums));
	// end of lab 3, niloufar
    }
}
