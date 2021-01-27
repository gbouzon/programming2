
public class ControlStructureExercise {
	
	public static void checkDigits(String str) { //naming system: verb+noun
		int digits = 0;
		for(int i = 0; i < str.length(); i++) {
			if(Character.isDigit(str.charAt(i))) 
				digits++;
		}
		System.out.println("" + digits); 
	}
	
	public static String reverseCase(String str) {
		String str2 = "";
		
		for(int i = 0; i < str.length(); i++) {
			char current = str.charAt(i);
			str2 += (Character.isUpperCase(current)) ? 
					Character.toLowerCase(current) : Character.toUpperCase(current);
		}
		return str2;
	}
	
	public static boolean isPrime(int num) {
		if(num <= 0)
			return false;
		
        for(int i = 2; i < Math.sqrt(num); i++)
            if (num % i == 0)
                return false;
        
        return true;
	}
	
	
	public static void main(String[] args) {
	
		ControlStructureExercise.checkDigits("h1y3c");
		System.out.println(ControlStructureExercise.reverseCase("Hello"));
		System.out.println(ControlStructureExercise.isPrime(3));
	}

}
