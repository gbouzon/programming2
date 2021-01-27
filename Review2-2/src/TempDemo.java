
public class TempDemo {
	
	public static void main(String[] args) {
		
		Temperature temp1 = new Temperature(30, 'F');
		Temperature temp2 = new Temperature(15, 'C');
		
		System.out.println(temp1.isHotter(temp2));

		System.out.println(temp1.getTempInCelsius());
	}

}
