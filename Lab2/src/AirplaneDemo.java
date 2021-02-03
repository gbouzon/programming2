/**
 * Demo class for the Airplane project.
 * @author Giuliana Bouzon
 */
public class AirplaneDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Airplane airplane1 = new Airplane(100, 7.5, 1029);
		Airplane airplane2 = new Airplane(400, 27, 768);
		Airplane airplane3 = new Airplane(20, 1.5, 1674);
		Airplane airplane4 = new Airplane(175, 14, 954);

		Airplane[] airplanes = {airplane1, airplane2, airplane3, airplane4};
		
		//demo for methods in Airplane class
		System.out.println(Airplane.getAverageWeight(airplanes));
		System.out.println(Airplane.findFasterAirplane(airplanes));
	}

}
