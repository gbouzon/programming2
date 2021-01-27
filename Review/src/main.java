import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//REVIEW 1 Q4 A
		String str = "";
		for(int i = 0; i<5; i++) {
			str += "*";
			//System.out.println(str);
		}
		
		//Q4 B
		
		String string = "";
		for(int z = 0; z<6; z++) {
			if(z%2!=0)
				string+="*";
				System.out.println(string);
				//System.out.println();
			
		}
		
		//REVIEW 2. 
		//Q2
		
		double sum = 0;
		boolean positive = true;
		
		for(int i = 0; i < 10000; i++) { //10000 iterations
			if(i%2!=0) { //check if it's odd
				if(positive) //check if it's positive to know whether we'll add or subtract
					sum+=1.0/i;
				else
					sum-=1.0/i;
				positive=!positive; //reset positive to false
			}
		}
		double PI = 4*sum;
		//System.out.println(PI);
		
		//Q3
		
		Scanner scan = new Scanner(System.in);
		//System.out.println("write something");
		String text = scan.nextLine();
		String str2 = "";
		
		for(int i = 0; i<text.length(); i++) {
			char c = text.charAt(i);
			if(c=='a' || c == 'e' || c == 'i')
				str2 +='*';
			else
				str2+=c;
		}
		//System.out.println(str2);
		
		//Q3 teacher
		
		String s;
		Scanner keyboard = new Scanner(System.in);
		
		//System.out.println("enter something");
		s = keyboard.nextLine(); //get user input
		for(int i = 0; i<s.length(); i++) { //go through each character of the string
			if ((s.charAt(i) == 'a') || (s.charAt(i) == 'e') || (s.charAt(i) == 'i'))
				s = s.substring(0, i) + "*" + s.substring(i+1); //replacing it with the star
		}
		//System.out.println(s);
		
		//Q4
		
		
	}

}
