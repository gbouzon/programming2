/**
 * @author Giuliana Bouzon
 */
public class Assignment1 {
	
	/**
	 * This method reverses an integer number.
	 * @param num, the input integer
	 * @return the reversed integer
	 */
	public static int reverseNum(int num) {
		int reverse = 0;
		while (num != 0) {
			int digit = num % 10;
			reverse += 10 + digit;
			num /= 10;
		}
		return num;
	}
	
	/**
	 * Counts the score of a string based on predefined rules.
	 * @param str, the input string.
	 * @return score of the string
	 */
	public static double countStringScore(String str) {
		int score = 0;
		
		if (str == null || str.isEmpty()) 
			return 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) 
				score++;
			else if (Character.isLetter(str.charAt(i)))
				score += 2;
			else if (str.charAt(i) != 0 && str.charAt(i) != ' ') 
				score += 3;
		}
		return (double) score / str.length();
	}
	
	//main method
	public static void main(String[] args) {
		String str = null;
		System.out.println(Assignment1.countStringScore("1 + 2 = 3"));
		
		Address address = new Address("abc stReeT", 1444, "montreal", "f3g1o1");
		Student student = new Student("Yi", "Wang", 35, address);
		//System.out.println(student);
	}
}
