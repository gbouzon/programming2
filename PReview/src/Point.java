
public class Point {
	
	private int x, y; //x and y coordinates
	
	//constructor, A.
	public Point(int x1, int y1) {
		x = x1;
		y = y1;	
	}
	
	//accessor method for x-coordinate, B.
	public int getX() {
		return x;
	}
	
	//mutator method for x-coordinate, C.
	public void setX(int value) {
		x = value;
	}
	
	//accessor method for y-coordinate, B.
	public int getY() {
		return y;
	}
	
	//mutator method for y-coordinate, C.
	public void setY(int value) {
		y = value;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x || y != other.y) 	
			return false;
		return true;
	}
	
	//method that switched coordinates, E.
	public Point reverse() {
		return new Point(y, x);
		
	}
	
	//method to increment coordinates, F.
	public void moveBy(int increment) {
		x+=increment;
		y+=increment;
	}

	@Override
	public String toString() {
		return "Point [x = " + x + ", y = " + y + "]";
	}

}
