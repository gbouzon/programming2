/** MIT License Copyright (c) 2021 Giuliana Bouzon

* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:

* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.

* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
* THE SOFTWARE.
*/

package lab5;

import java.util.ArrayList;
import java.util.Scanner;

/**
* Class based on Niloufar's lab 5.
* Teacher's code.
* @author Giuliana Bouzon
*/
public class GPS {
    private static Scanner scan = new Scanner(System.in); //class scanner, to be reused
    private final static double SCALING_FACTOR = 0.1; // 1 unit = 0.1 mile
    private ArrayList<Waypoint> waypoints;
    
    public GPS() {
	waypoints = new ArrayList<>();
    }
    
    /**
     * Calculates the distance between two given waypoints.
     * Based on mathematical formula: sqrt((x1-x2)^2 + (y1-y2)^2)
     * @param waypoint1, the first input waypoint.
     * @param waypoint2, the second input waypoint.
     * @return the distance between the two.
     */
    public static double calculateDistance(Waypoint waypoint1, Waypoint waypoint2) {
	double xFactor = ((waypoint1.getX() - waypoint2.getX()) * ((waypoint1.getX() - waypoint2.getX())));
	double Yfactor = ((waypoint1.getY() - waypoint2.getY()) * ((waypoint1.getY() - waypoint2.getY())));
	return Math.sqrt(xFactor + Yfactor);
    }
    
    /**
     * Asks user to enter waypoint information, then makes a Waypoint object
     * and adds it to the waypoints arraylist.
     */
    public void getUserInput() {
	String waypointInfo;
	double x,y;
	int time;
	System.out.println("Please enter a waypoint, in the following format: x y timestamp");
	
	do {
	    waypointInfo = scan.nextLine();
	    
	    if (waypointInfo.length() > 1) {
		//scanning the info entered by the user
		Scanner waypointScan = new Scanner(waypointInfo);
		x = waypointScan.nextDouble();
		y = waypointScan.nextDouble();
		time = waypointScan.nextInt();
		
		//creating the Waypoint object
		Waypoint waypoint = new Waypoint(x, y, time);
		
		//adding it to the arraylist
		waypoints.add(waypoint);
	    }
	}
	while (waypointInfo.length() > 1);
    }
    
    /**
     * Calculates the total distance by summing the distance between each waypoint together.
     * @return the total distance.
     */
    public double calculateTotalDistance() {
	double distance = 0;
	Waypoint lastPoint = null;
	Waypoint currentPoint = null;
	
	if (waypoints.size() < 2)
	    return 0;
	else {
	    lastPoint = waypoints.get(0);
	    for (int i = 1; i < waypoints.size(); i++) {
		currentPoint = waypoints.get(i);
		distance += calculateDistance(lastPoint, currentPoint);
		lastPoint = currentPoint;
	    }
	    return distance;
	}
    }
    
    /**
     * Calculates the total time that the whole trip took by
     * summing the time spent to get to each waypoint.
     * @return the total time spent.
     */
    public int calculateTotalTime() {
	int time = 0;
	Waypoint lastPoint = null;
	Waypoint currentPoint = null;
	
	if (waypoints.size() < 2)
	    return 0;
	else {
	    lastPoint = waypoints.get(0);
	    for (int i = 1; i < waypoints.size(); i++) {
		currentPoint = waypoints.get(i);
		time += (currentPoint.getTimeStamp() - lastPoint.getTimeStamp());
		lastPoint = currentPoint;
	    }
	    return time;
	}
    }
    
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	GPS gps = new GPS();
	double totalDistance;
	int totalTime;
	
	gps.getUserInput();
	totalDistance = gps.calculateTotalDistance();
	totalTime = gps.calculateTotalTime();
	System.out.printf("The total distance is: %.4f miles.\n", totalDistance * GPS.SCALING_FACTOR);
	System.out.printf("The total time is: %d seconds or %.2f hours.\n", totalTime, totalTime/3600.0);
	System.out.printf("The average speed is: %.4f miles per hour.\n", totalDistance * 3600 * GPS.SCALING_FACTOR / totalTime);
	System.out.println();

    }
}
