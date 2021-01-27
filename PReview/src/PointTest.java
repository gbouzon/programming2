
public class PointTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//creating two points, H.
		Point p1 = new Point(0,0);
		Point p2 = new Point(2,3);
		
		//display coordinates of two points, I.
		System.out.println("P1: " + p1);
		System.out.println("P2: " + p2);
		
		//reversing the coordinates of p2, J.
		p2 = p2.reverse();
		//System.out.println("P2 reversed: " + p2); //testing output -OK
		
		//setting coordinates of p1 to reverse of p2, K.
		p1 = p2.reverse();
		//System.out.println("P1: " + p1); //testing output -OK
		
		//incrementing p1's coordinates by 10, L.
		p1.moveBy(10);
		//System.out.println("P1: " + p1); //testing output -OK
		
		//comparing coordinates of p1 and p1, M.
		if(p1.equals(p2))
			System.out.println("Same");
		else
			System.out.println("Different");
	}

}
