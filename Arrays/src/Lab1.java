import java.util.Arrays;
import java.util.Scanner;

public class Lab1 {
	
	/**
	 * Adds a specific value to each element of an array, directly modified
	 * @param nums, the input array
	 * @param value the specific value
	 */
	public static void addValue(double[] nums, double value) {
		for(int i = 0; i < nums.length; i++) {
			nums[i] += value;
		}
	}
	
	/**
	 * Counts the number of odd numbers in an array
	 * @param nums, the input array
	 * @return the number of odd numbers in an array
	 */
	public static int countOddNum(int[] nums) {
		int count = 0;
		for(int oddNum : nums) {
			if(oddNum % 2 != 0) {
				count++;
			}
		}		
		return count;
	}
	
	/**
	 * Adds elements in an array with odd index
	 * @param nums, the input array
	 * @return the sum of elements in an array with odd index
	 */
	public static double sumOddIndex(double[] nums) {
		double oddSum = 0;
		for(int i = 1; i < nums.length; i+=2) {
				oddSum += nums[i];
		}
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
		
		for(int i = 0; i < len; i++) {
			if(flags[i]) { 		//pls DO NOT write flags[i] == true
				sum += nums[i];
			}
		}
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
		
		for(int i = 0; i < length; i++) {
			array[i] = copyArray[(length-1)-i];
		}
		return array;
	}

	public static void main(String[] args) {
		
		//testing yi's lab exercises
		double[] nums = {1,2,3,4,5,6,7};
		System.out.println(sumOddIndex(nums));
		
		//testing niloufar's lab exercises
		int[] nums2 = {1,3,5,7,9,11,13,15,17};
		System.out.println(Arrays.toString(reverseOrder(nums2)));
	}
}
