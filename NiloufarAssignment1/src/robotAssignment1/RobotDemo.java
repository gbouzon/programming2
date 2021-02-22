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

import java.util.Scanner;

/**
 * A java application class that tests Robot defined in Robot class.
 */

/**
* Assignment 1
* Class RobotDemo
* @author Giuliana Bouzon
* For Programming II Section 00002 - Winter 2021
* Submitted on February 18th, 2021
*/
public class RobotDemo {
    
     //created two scanners to avoid mixing values 
     static Scanner scan = new Scanner(System.in); 
     static Scanner scanner = new Scanner(System.in);
     
     //counts the number of moves until a robot wins
     static int turns = 0; 
    
   /**
    * Prompts the user to enter the size of the grid.
    * It will keep asking for a valid size until one is entered (>= 2)
    * @return the size of the grid.
    */
    public static int getGridSize() {
	System.out.print("What is the size of your grid? ");
	int size = scan.nextInt();
	while (size < 2) { 
	    System.out.print("Grid size must be at least 2. Please enter a valid value: ");
	    size = scan.nextInt();
	}	
	return size;
    }
    
    /**
     * Asks the user to input the name of the robot.
     * @return the name of the robot.
     */
    public static String getRobotName() {
	System.out.print("What is the name of your robot? ");
	return scanner.nextLine();
    }
    
    /**
     * Displays game header. Please don't touch the robot drawing.
     */
    public static void gameHeader() {
	System.out.println("   WELCOME TO ROBOT WALK!!");
	System.out.println("          ,    ,");
	System.out.println("         (\\____/)");
	System.out.println("          (_oo_) ");
	System.out.println("            (O) ");
	System.out.println("          __||__     /) ");
	System.out.println("       []/______\\[] / ");
	System.out.println("        \\\\______/ \\/   ");
	System.out.println("        (\\ /__\\ ");
	System.out.println("          /____\\ ");
	System.out.println("-------------------------------\n");
    }
    
    /**
     * Randomly generates the number of steps the robot will take,
     * must be a number between 1 and the gridSize.
     * @param gridSize, the size of the grid.
     * @return the number of steps the robot will take.
     */
    public static int generateSteps(int gridSize) {
	return (int) (Math.random() * gridSize) + 1; //varies between 1 and gridSize
    }
    
    /**
     * Displays the game's closing message.
     * @param robot, the input robot object.
     * @param turns, the number of turns it took to win the game.
     */
    public static void closingMessage(Robot robot, int turns) {
	System.out.printf("------> %s %s %d %s!!", robot.getName(), "reached its final destination in", turns, "turns");
    }
    
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	//variables to be used later on
	int steps; 
	int gridSize; 
	
	//displaying opening message
	gameHeader();
	
	//getting gridSize
	gridSize = getGridSize();
	
	//creating robot object
	Robot r = new Robot(getRobotName());
	
	//closing scanners to avoid memory leaks
	scanner.close();
	scan.close();
	
	//starting the game
	while (!r.won(gridSize)) {
	    System.out.printf("\n---------------> %s %d.\n", "Move number", turns + 1);  //printing out number of moves
	    steps = generateSteps(gridSize); //getting nb of steps
	    turns++;
	    System.out.printf("%s, %s %d %s.\n", r, "and needs to take", steps, "steps"); //printing out nb of steps to take
	    r.move(steps, gridSize); //moving the robot
	    System.out.printf("%s: %s.\n", "Result", r); //printing out position after direction change and steps taken
	}
	System.out.println(); //skiping a line
	closingMessage(r, turns); //winning message	
    }
}