package hotel;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * A lobby class that only contains an array of Clocks
 * @author Giuliana Bouzon
 *
 */
public class Lobby {

    private static Clock[] clocks = new Clock[5];
	
    public static void main(String[] args) {
	// TODO Auto-generated method stub
		
	int hr = LocalDateTime.now().getHour();
	int mi = LocalDateTime.now().getMinute();
	int se = LocalDateTime.now().getSecond();
		
	clocks[0] = new Clock(hr + 5, mi, se, "London");
	clocks[1] = new Clock(hr + 6, mi, se, "Paris");
	clocks[2] = new Clock(hr, mi, se, "London");
	clocks[3] = new Clock(hr - 9, mi, se, "Beijing");
	clocks[4] = new Clock(hr - 8, mi, se, "Tokyo");
		
	System.out.println(Arrays.toString(clocks));
    }
}

