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

package robotAssignment1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Java application to simulate a robot race using the Robot class previously defined.
 */

/**
* Assignment 1
* Class RobotRace
* @author Giuliana Bouzon
* For Programming II Section 00002 - Winter 2021
* Submitted on February 18th, 2021
*/
public class RobotRace {
    
    static int turns = 0; //counts the number of moves until a robot wins
    static Scanner scan = new Scanner(System.in); //a scanner to be used in later methods
   
    //properties
    private Robot[] robots;
    
    //constructor
    public RobotRace(int numRobots) {
	this.robots = new Robot[numRobots];
    }
    
    //copy constructor
    public RobotRace(RobotRace robotRace) {
	this.robots = Arrays.copyOf(robotRace.robots, robotRace.robots.length);
    }

    /**
     * Adds a Robot object to the specified index of the robot array.
     * @param newRobot, the input robot object.
     * @param index, the input index.
     */
    public void add(Robot newRobot, int index) {
	robots[index] = newRobot;
    }

    /**
     * Checks if the robot has won by checking if its
     * coordinates are the same as the size of the grid
     * (meaning it's at the top right corner of the grid).
     * @param gridSize, the input grid size.
     * @return true if the robot has reached position (gridSize, gridSize).
     */
    public boolean won(int gridSize) {
	for (Robot robot : this.robots)
	    if (robot.won(gridSize)) {
		RobotDemo.closingMessage(robot, turns); //turns is incremented in main
		return true;
	    }
	return false;
    }
    
    @Override
    public String toString() {
	String str = "";
	for (Robot robot : robots) 
	    str += robot.toString() + "\n"; //skipping one line to separate robot objects.
	
	return str;
    }
    
    /**
     * Prompts the user to enter the number of robots participating in the race.
     * It will keep asking for a valid number until one is entered (>= 1)
     * @return, the number of robots. 
     */
    public static int getRobotNumber() {
	System.out.print("How many robots will race? ");
	int robotNumber = scan.nextInt();
	while (robotNumber < 1) { //since there must be at least one robot in the race
	    System.out.print("There must be at least one robot in the race. Please enter a valid value: ");
	    robotNumber = scan.nextInt();
	}
	return robotNumber;
    }
    
    //getter
    public Robot[] getRobots() {
	return this.robots;
    }
    
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	//variables to be used later on
	String name;
	int steps, gridSize, robotNumber;
	
	//another scanner to avoid mixing values
	Scanner scanner = new Scanner(System.in); 
	
	//displaying opening message
	RobotDemo.gameHeader(); 
	
	//getting grid size and number of robots racing
	gridSize = RobotDemo.getGridSize(); 
	robotNumber = getRobotNumber(); 
	
	//creating RobotRace object
	RobotRace r = new RobotRace(robotNumber);
	
	//adding robot objects to the array after creating them
	for (int i = 0; i < robotNumber; i++) {
	    System.out.print("What is the name of robot " + (i + 1) + "? "); // i+1 because i starts with 0 and humans start counting from 1
	    name = scanner.nextLine();
	    r.add(new Robot(name), i);
	}
	
	//closing the scanners to avoid memory leaks
	scanner.close(); 
	scan.close();
	
	//skipping a line
	System.out.println();
	
	//starting the race
	while (!r.won(gridSize)) {
	    System.out.println("----------------> Move number " + (turns + 1)); //turns+1 because humans start counting from 1 not from 0
	    turns++; //incrementing turns when "steps" is generated
	    for (Robot robot : r.getRobots()) {
		steps = RobotDemo.generateSteps(gridSize);
		System.out.print(robot + ", and needs to take " + steps + " steps.\n");
		robot.move(steps, gridSize);
		System.out.println("Result: " + robot + "\n"); //to show position after direction change and steps taken);
	    }
	} 
    }
}