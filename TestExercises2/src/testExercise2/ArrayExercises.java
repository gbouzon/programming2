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

package testExercise2;

import java.util.Arrays;

/**
* Class based on Niloufar's Self-Test Exercise II - Q1, Q2.
* @author Giuliana Bouzon
*/
public class ArrayExercises {
    
    /**
     * Moves all 0s to the end of the array while keeping its original order.
     * @param nums, the input array.
     * @return the modified array.
     */
    public static int[] moveZeroes(int[] nums) {
	int[] nums2 = new int[nums.length];
	int zeroCount = 0;
	
	for (int i = 0; i < nums.length; i++) {
	    if (nums[i] != 0) 
		nums2[i - zeroCount] = nums[i];
	    else
		zeroCount++;
	}
	return nums2;
    }
    
    /**
     * Merges elements of A with B by maintaining the sorted order.
     * @param nums1, the first input array.
     * @param nums2, the second input array.
     */
    public static void mergeArrays(int[] nums1, int[] nums2) {
	int min = Math.min(nums1.length, nums2.length);
	int max = Math.max(nums1.length, nums2.length);
	
	int[] nums3 = new int[nums1.length + nums2.length];
	
	for (int i = 0; i < nums1.length; i++) 
	    nums3[i] = nums1[i];
	
	for (int j = 0; j < nums2.length; j++)
	    nums3[j + nums1.length] = nums2[j];
	
	Arrays.sort(nums3);
	
	for (int n = 0; n < max; n++) 
	    nums1[n] = nums3[n];
	
	for (int t = 0; t < min; t++)
	    nums2[t] = nums3[t + nums1.length];
	
	System.out.println(Arrays.toString(nums1));
	System.out.println(Arrays.toString(nums2));
    }
    
    public static void main(String[] args) {
	
	int[] nums = {0,0,2,0,3,0,4,6,7};
	System.out.println(moveZeroes(nums));
	
	int[] nums2 = {1,5,6,7,8,10};
	int[] nums3 = {2,4,9};
	mergeArrays(nums2, nums3);
    }
}
