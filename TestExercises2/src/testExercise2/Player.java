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

package testExercise2;

/**
* Class based on Niloufar's Self-Test Exercise II - Q4.
* Used arrays this time.
* @author Giuliana Bouzon
*/
public class Player {

    //properties
    private String name;
    private double score;
        
    //default constructor
    public Player() {
	this("", 0);
    }
    
    //parameterized constructor
    public Player(String name, double score) {
	this.name = (name != null) ? name : "noName";
	this.score = (score >= 0 && score <= 100) ? score : 0;
    }
    
    //copy constructor
    public Player(Player player) {
	this(player.name, player.score);
    }
    
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Player other = (Player) obj;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	if (Double.doubleToLongBits(score) != Double.doubleToLongBits(other.score))
	    return false;
	return true;
    }
    
    @Override
    public String toString() {
	return String.format("%s's %s: %.2f", this.name, "score", this.score);
    }
   
    //getters and setters
    
    public String getName() {
	return this.name;
    }
    
    public void setName(String name) {
	if (name != null)
	    this.name = name;
    }
    
    public double getScore() {
	return this.score;
    }
    
    public void setScore(double score) {
	if (score >= 0 && score <= 100)
	    this.score = score;
    }
}