package hotel;

/**
 * A simple Clock class.
 * @author Giuliana Bouzon
 *
 */
public class Clock {
    private int hr;
    private int mi;
    private int se;
    private String city;
	
    //parameterized constructor
    public Clock(int hr, int mi, int se, String city) {
	this.hr = hr % 24;
	this.mi = mi % 60;
	this.se = se % 60;
	this.city = city;
    }

    @Override
    public String toString() {
	return String.format("%-5s: %02d:%02d:%02d", city, hr, mi, se);
    }
}
