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

package rainfall;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

/**
 * Graph class defines a vertical bar graph corresponding to the Rainfall array created in the RainfallDemo class.
 * Class to be used to graphically display a vertical bar chart for the Rainfall data previously defined in Rainfall and RainfallDemo classes.
 * The graph follows a chronological order (starting with the first month of the year and ending with the last month of the year)
 * The name of the month is used as a label to represent each rectangle in the bar chart.
 * The height of each rectangle corresponds to the precipitation value of the specified month.
 */

/**
 * Assignment 4
 * Class Graph
 * @author Giuliana Bouzon - 1940108
 * For Programming II Section 00002 - Winter 2021
 * Submitted on May 17th, 2021
 */
public class Graph extends JPanel {
    
    //variables 
    public static final int RECTANGLE_WIDTH = 15;
    public static final int DISTANCE = 30;
    
    //Random to be used later on
    private static Random random = new Random();
    
    @Override
    public void paintComponent(Graphics graphics) {
	//generating the rainfall array
	Rainfall[] rainfalls = RainfallDemo.generateArray();
	int y = 400;
	//where the graph starts, x-coordinate wise
	int xStartingPoint = 200;
	//"x" variable to be used later to set each rectangle's starting point
	int x = xStartingPoint;
	//variable to be used later on to get the tallest rectangle's height
	int maxHeight = 0;
	//gets the length of the graph (from where first rectangle starts until where the last rectangle ends)
	int graphLength = (RECTANGLE_WIDTH + DISTANCE) * rainfalls.length;
	
	super.paintComponent(graphics);
	this.setBackground(Color.WHITE);
	
	//loop to iterate through array and make each rectangle
	for (Rainfall rainfall : rainfalls) {
	    maxHeight = Math.max(maxHeight, rainfall.getPrecipitation()); //gets the max height
	    //chooses a colour randomly using the Random() class
	    graphics.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
	    //creates a rectangle to the height of the precipitation from the rainfall object
	    graphics.fillRect(x, y - rainfall.getPrecipitation(), RECTANGLE_WIDTH, rainfall.getPrecipitation());
	    //sets the font to times new roman, 12
	    graphics.setFont(new Font("Times New Roman", Font.PLAIN, 8));
	    //write the corresponding month's name under each rectangle
	    graphics.drawString(rainfall.getMonth(), x, y + DISTANCE); 
	    //calculates the x-coordinate for the next rectangle (which is 1 rectangle's width + distance between rectangles)
	    x += RECTANGLE_WIDTH + DISTANCE;
	}
	
	//resets the color to black for the axis lines
	graphics.setColor(Color.BLACK);
	//y-axis, starts at the same place as the graph and ends at the same place as maxHeight aka tallest rectangle
	graphics.drawLine(xStartingPoint, y - maxHeight, xStartingPoint, y);
	//x-axis, starts at the same place as the first rectangle and ends at the same places as last rectangle + distance
	graphics.drawLine(xStartingPoint, y, xStartingPoint + graphLength, y);
    }
}