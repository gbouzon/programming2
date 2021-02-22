package arraysExercise;

import java.util.Arrays;
/**
 * 
 * @author Giuliana Bouzon
 *
 */
public class Lab1 {
    
    /**
     * Checks if two arrays contain the same elements, even if the order is different.
     * @param array1, the first input char array.
     * @param array2, the second input char array.
     * @return true if the two arrays contain the same elements. False if otherwise.
     */
    public static boolean equals(char[] array1, char[] array2) {
	boolean sameFrequency = true;
	int elemFrequency = 0;
	int elemFrequency2 = 0;
	
	for (int i = 0; i < array1.length && sameFrequency; i++) {
	    for (int j = 0; j < array1.length; j++)
		if (array1[i] == array1[j])
		    elemFrequency++;
	    
	    for (int j = 0; j < array1.length; j++)
		if (array1[i] == array2[j])
		    elemFrequency2++;
	    
	    if (elemFrequency != elemFrequency2)
		sameFrequency = false;
	}
	return sameFrequency;
    }
	
    /**
     * Adds a specific value to each element of an array, directly modified
     * @param nums, the input array
     * @param value the specific value
     */
    public static void addValue(double[] nums, double value) {
	for (int i = 0; i < nums.length; i++) 
	    nums[i] += value;
    }
	
    /**
     * Counts the number of odd numbers in an array
     * @param nums, the input array
     * @return the number of odd numbers in an array
     */
    public static int countOddNum(int[] nums) {
	int count = 0;
	for (int oddNum : nums) 
	    if (oddNum % 2 != 0) 
		count++;
			
	return count;
    }
	
    /**
     * Adds elements in an array with odd index
     * @param nums, the input array
     * @return the sum of elements in an array with odd index
     */
    public static double sumOddIndex(double[] nums) {
	double oddSum = 0;
	for (int i = 1; i < nums.length; i+=2) 
	    oddSum += nums[i];
		
	return oddSum;
    }
	
    /**
     * Add elements of a double array if at the same position, the boolean array
     * has a value of true. If the two arrays have different sizes, calculate the sum
     * based on the shorter one.
     * @param nums, the number array
     * @param flags, the boolean array
     * @return the sum
     */
    public static double sum(double[] nums, boolean[] flags) {
	double sum = 0;
	int len = Math.min(nums.length, flags.length);
	
	for (int i = 0; i < len; i++) 
	    if (flags[i]) 		//pls DO NOT write flags[i] == true
		sum += nums[i];
	
	return sum;
    }
	
    /**
     * Reverses the order of an integer array.
     * @param array, the input array.
     * @return the reversed array.
     */
    public static int[] reverseOrder(int[] array) {
	int length = array.length;
	int[] copyArray = Arrays.copyOf(array, length);
		
	for (int i = 0; i < length; i++) 
	    array[i] = copyArray[(length-1)-i];
		
	return array;
    }
	
    /**
     * Appends a new value to a double array
     * @param array, the input array
     * @param value, the value to be inserted in the array
     * @return the new array with the appended number
     */
    public static double[] appendValue(double[] nums, double value) {
	double[] numsCopy = Arrays.copyOf(nums, nums.length + 1);
	
	numsCopy[numsCopy.length - 1] = value;
	
	return numsCopy; 			//shallow copy
    }
	
    /**
     * Counts the number of vowels in a string, you should convert the string
     * to a char array first and then do the count
     * @param str, the input string
     * @return the number of vowels in the string
     */
    public static int countVowels(String str) {
	int count = 0;
	str = str.toLowerCase();
		
	for (char c : str.toCharArray())
	    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') 
		count++;
		
	return count;
    }
	
    /**
     * Counts the total number of vowels in a string array
     * @param strs, the input string array
     * @return the total number of vowels in the string array
     */
    public static int countVowels(String[] strs) {
	int vowelCount = 0;
	for (String str : strs)
	    vowelCount += countVowels(str);
		
	return vowelCount;
    }
	
    /**
     * Removes the first and last characters of each String in a String array.
     * @param strs, the input string array.
     */
    public static void removeCharacters(String[] strs) {
	for (int i = 0; i < strs.length; i++) 
	    if(strs[i].length() > 2)
		strs[i] = strs[i].substring(1, strs[i].length() - 1);
    }
	
    /**
     * Finds the maximum values between two double arrays.
     * {1,2,3}, {4,1,0} -> {4,2,3}
     * @param nums1, the first input double array
     * @param nums2, the second input double array
     * @return the max array
     */
    public static double[] max(double[] nums1, double[] nums2) {
	int minLen = Math.min(nums1.length, nums2.length);
	int maxLen = Math.max(nums1.length, nums2.length);
		
	double[] maxNums = new double[maxLen];
		
	//where the two arrays overlap
	for (int i = 0; i < minLen; i++)
	    maxNums[i] = Math.max(nums1[i], nums2[i]);
		
	//the longer array's part (what's left after if they're of different lengths)
	double[] longArray = (nums1.length > nums2.length) ? nums1 : nums2;
	for (int i = minLen; i < maxLen; i++)
	    maxNums[i] = longArray[i];
		
	return maxNums;
    }

    public static void main(String[] args) {
		
	//testing yi's lab exercises
	double[] nums = {1,2,3,4,5,6,7};
	System.out.println(sumOddIndex(nums));
		
	String[] strs = {"aaa", "bbb"};
	removeCharacters(strs);
	System.out.println(Arrays.toString(strs));
		
	//testing niloufar's lab exercises
	int[] nums2 = {1,3,5,7,9,11,13,15,17};
	System.out.println(Arrays.toString(reverseOrder(nums2)));
	
	char[] array1 = {'a', 'b', 'c'};
        char[] array2 = {'b', 'c', 'a'};
        System.out.println(equals(array1, array2));
    }
}
