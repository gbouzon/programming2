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

/**A robot has a name and moves in a 2-dimensional plane (square grid) in a specified direction. It
starts at location (0,0) facing East and moves a randomly generated number of steps each turn until
it reaches the top right corner of the grid, whose coordinates will be N x N, where N is the size of
the square grid. 
*/

/**
* Assignment 1
* Class Robot
* @author Giuliana Bouzon
* For Programming II Section 00002 - Winter 2021
* Submitted on February 18th, 2021
*/
public class Robot {
    
    //properties
    private String name;
    private int x, y;
    private char direction;
    
    //default constructor
    public Robot() {
	this("noName");
    }
    
    //parameterized constructor
    public Robot(String name) {
	this.name = (name != null) ? name : ""; //checking that the name isn't null
	this.x = 0;
	this.y = 0;
	this.direction = 'E';
    }
    
    //copy constructor
    public Robot(Robot robot) {
	this(robot.name);
    }
 
    /**
     * Checks if two robot objects are equal to one another,
     * by checking if their positions and directions are the same.
     * @param robot, the input robot object.
     * @return true if the two robots have the same positions and directions. False if otherwise.
     */
    public boolean equals(Robot robot) {
	return this.direction == robot.direction
		&& this.x == robot.x
		&& this.y == robot.y;
    }
    
    /**
     * Changes the direction of the robot according to the specified rules:
     * E --> N
     * N --> W
     * W --> S
     * S --> E
     */
    public void changeDirection() {
	switch(this.direction) { //using switch() since it is more efficient than ifs
	    case 'E':
		this.direction = 'N';
		break;
	    case 'W':
		this.direction = 'S';
		break;
	    case 'N':
		this.direction = 'W';
		break;
	    case 'S':
		this.direction = 'E';
	}
	System.out.printf("-> %s: %c.\n", "New direction", this.direction); //showing user the direction changes
    }
    
    /**
     * Checks if the robot exceeds the gridSize (possible coordinates).
     * Screens for negative values (when applicable).
     * @param gridSize, the input grid size.
     * @return true if the robot does exceed the grid limitations.
     */
    public boolean doesExceed(int steps, int gridSize) {
	switch(this.direction) { //using switch() since it is more efficient than ifs
	    case 'E':
		return this.x + steps > gridSize;
	    case 'W':
	    	return this.x - steps < 0;
	    case 'N':
	    	return this.y + steps > gridSize;
	    case 'S':
	    	return this.y - steps < 0;
	    default:
		return false;
	}
    }
    
    /**
     * Moves the robot the specified number of steps when it doesn't
     * exceed the grid boundaries (just because I didn't want to do it all in one method).
     * @param steps, the input number of steps.
     * @param gridSize, the input grid size.
     */
    public void moveNotExceeded(int steps, int gridSize) {
	switch(this.direction) { //using switch() since it is more efficient than ifs
    	    case 'E':
    		this.x += steps; //east moves to the right
    		break;
    	    case 'W':
    	    	this.x -= steps; //west moves to the left
    	    	break;
    	    case 'N':
    	    	this.y += steps; //north moves up
    	    	break;
    	    case 'S':
    	    	this.y -= steps; //south moves down
	}
    }
    
    /**
     * Moves the robot the specified number of steps across the grid.
     * If "steps" exceeds the grid, it takes precautions and changes directions.
     * Recursion makes this more interesting ;)
     * 
     * ex: if position is (2,0), direction is 'E' and grid size is 5
     * if steps is = 4, then 2 + 4 = 6, therefore exceeds boundaries.
     * then we should do (2 + 4) - 5 = 1 to get the remaining steps (which in this case is 1).
     * 
     * @param steps, the input number of steps.
     * @param gridSize, the input grid size.
     */
    public void move(int steps, int gridSize) { 
	int remainingSteps = 0; //to be used in calculating the steps remaining when it exceeds grid boundaries
	
	if (doesExceed(steps, gridSize)) { //checking if it exceeds the grid boundaries to set conditions
	    switch(this.direction) {
	    	case 'E':
	    	    remainingSteps = (this.x + steps) - gridSize;
	    	    this.x = gridSize;
	    	    changeDirection();
	    	    move(remainingSteps, gridSize); //goes back in the method and takes the remaining steps in the other direction
	    	    break;
	    	case 'W':
	    	    remainingSteps = steps - this.x;
	    	    this.x = 0;
	    	    changeDirection();
	    	    move(remainingSteps, gridSize); //goes back in the method and takes the remaining steps in the other direction
	    	    break;
	    	case 'N':
	    	    remainingSteps = (this.y + steps) - gridSize;
	    	    this.y = gridSize;
	    	    changeDirection();
	    	    move(remainingSteps, gridSize); //goes back in the method and takes the remaining steps in the other direction
	    	    break;
	    	case 'S':
	    	    remainingSteps = steps - this.y;
	    	    this.y = 0;
	    	    changeDirection();
	    	    move(remainingSteps, gridSize); //goes back in the method and takes the remaining steps in the other direction
	    }
	}
	else 
	    moveNotExceeded(steps, gridSize); //another method not to jam everything in one ;)
    }
    
    /**
     * Checks if the robot has won by checking if its
     * coordinates are the same as the size of the grid
     * (meaning it's at the top right corner of the grid).
     * @param gridSize, the input grid size.
     * @return true if the robot has reached position (gridSize, gridSize).
     */
    public boolean won(int gridSize) {
	return (this.x == gridSize && this.y == gridSize);
    }

    @Override
    public String toString() {
	return String.format("%s %s %c %s (%d, %d)", this.name, "is facing", this.direction, "and at position", this.x, this.y);
    }
    
    // getters and setters
    
    public String getName() {
	return this.name;
    }
    
    public void setName(String name) {
	if (name != null) //checking that the string isn't null
	    this.name = name;
    }
    
    public int getX() {
	return this.x;
    }
    
    public int getY() {
	return this.y;
    }
    
    public char getDirection() {
	return this.direction;
    }
}