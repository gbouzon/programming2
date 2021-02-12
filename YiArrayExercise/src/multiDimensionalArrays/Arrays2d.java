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

package multiDimensionalArrays;

import java.util.Arrays;

/**
* Simple 2d class based on Yi's lab (lesson 13).
* @author Giuliana Bouzon
*/
public class Arrays2d {
    
    /**
     * Increases each element in the array by a specific value.
     * @param numss, the input 2d array.
     * @param value, the amount to increase by.
     */
    public static void increaseValue(double[][] numss, double value) {
	for (double[] nums : numss)
	    for (int j = 0; j < nums.length; j++)
		nums[j] += value;
    }
    
    /**
     * Calculates the sum of the elements of a 2d array.
     * @param numss, the input 2d array.
     * @return the sum.
     */
    public static double sum(double[][] numss) {
	int sum = 0;
	
	for (double[] nums : numss)
	    for (double num : nums)
		sum += num;
	
	return sum;
    }

    /**
     * Finds the max value in a 2d array
     * @param numss, the input 2d array
     * @return the max value in the 2d array
     */
    public static double max(double[][] numss) {
	double max = Double.NEGATIVE_INFINITY; //SMALLEST POSSIBLE NUMBER
	// or we can do double max = Double.MIN_VALUE;
	
	for (double[] nums : numss)
	    for (double num : nums)
		max = Math.max(max, num);
	
	return max;
    }
    
    /**
     * Finds the max value in each row of a 2d array.
     * @param numss, the input 2d array.
     * @return the max in each row of that 2d array
     */
    public static double[] maxInRow(double[][] numss) {
	double[] maxs = new double[numss.length];  //{0, 0, 0}
	Arrays.fill(maxs, Double.NEGATIVE_INFINITY); //{-INF, -INF, -INF}
	
	for (int i = 0; i < numss.length; i++)
	    for (double num : numss[i])
		maxs[i] = Math.max(num, maxs[i]);
	    
	return maxs;    
    }
    
    /**
     * Calculates the average of each row of a 2d array
     * @param numss, the input 2d array
     * @return the average of each row of the 2d array
     */
    public static double[] avgInRow(double[][] numss) {
	double[] avgs = new double[numss.length];
	
	for (int i = 0; i < numss.length; i++) {
	    for (double num : numss[i])
		avgs[i] += num;
	    
	    avgs[i] /= numss[i].length;
	}
	return avgs;
    }
    
    /**
     * Finds the max in each column of a 2d array
     * @param numss, the input 2d array
     * @return the max in each column of that 2d array
     */
    public static double[] maxInColumn(double[][] numss) {
	//find longest row in the 2d array
	int maxCol = 0;
	for (double[] nums : numss)
	    maxCol = Math.max(maxCol, nums.length);
	
	double[] maxs = new double[maxCol];
	Arrays.fill(maxs, Double.NEGATIVE_INFINITY);
	
	for (double[] nums : numss) 
	    for (int j = 0; j < nums.length; j++) 
		maxs[j] = Math.max(nums[j], maxs[j]);

	return maxs;
    }
    
    /**
     * Calculates the average of each column of the 2d array.
     * @param numss, the input 2d array.
     * @return the average.
     */
    public static double[] avgInCol(double[][] numss) {
	int maxCol = 0;
	for (double[] nums : numss)
	    maxCol = Math.max(maxCol, nums.length);
	
	double[] avgs = new double[maxCol];
	double[] counts = new double[maxCol];
	
	for (double[] nums : numss) {
	    for (int j = 0; j < nums.length; j++) {
		avgs[j] += nums[j];  //calc the sum
	    	counts[j]++; // count the nb of elements
	    } 	  
	}
	for (int i = 0; i < avgs.length; i++)
	    avgs[i] /= counts[i];
	
	return avgs;
    }
    
    /**
     * Appends a new number in the end of a specific row in a 2d array.
     *
     * Example: {{1,2,0,0,0},{3,4}}, 5, 1 -> {{1,2,0,0,0},{3,4,5}}
     *
     * @param numss, the input 2d array.
     * @param num, the new number to append.
     * @param rowIdx, the index of the row you want to append the number to.
     */
    public static void appendNum(double[][] numss, double num, int rowIdx) {
        double[] row = Arrays.copyOf(numss[rowIdx], numss[rowIdx].length + 1);
        row[row.length - 1] = num;
        numss[rowIdx] = row;
    }
    
    /**
     * Appends a new row in a 2d array.
     *
     * Example: {{1,2,0,0,0},{3,4}}, {9,9,9}, 1 -> {{1,2,0,0,0},{9,9,9},{3,4}}
     *
     * @param numss, the input 2d array.
     * @param nums, the new row to append to the 2d array.
     * @param idx, position of the row to append.
     */
    public static double[][] appendRow(double[][] numss, double[] nums, int idx) {
        double[][] numss2 = new double[numss.length + 1][];

        for (int i = 0; i < idx; i++)
            numss2[i] = numss[i];

        numss2[idx] = nums;

        for (int i = idx; i < numss.length; i++)
            numss2[i + 1] = numss[i];

        return numss2;
    }
    
    public static void main(String[] args) {
	double[][] numss = {{1, 2, 3, 4, 0}, {3, 4}};
	double[] nums = {2, 2, 2};
	
	//testing methods
	System.out.println(Arrays.deepToString(appendRow(numss, nums, 1)));
    }
}