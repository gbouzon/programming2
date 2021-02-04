/**
 * 2d Arrays exercises
 *
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
		String[][] animals = { { "dog", "cat", "fish", "bird", "worm" }, { "lion", "baboon", "bison", "beaver" },
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

		// Q3, displaying sum for square arrays
		int[][] nums = { { 1, 2, 3 }, { 5, 6, 7 }, { 9, 10, 11 } };
		System.out.println(Arrays2d.sum(nums));
		// end of lab 3, niloufar

	}

}
