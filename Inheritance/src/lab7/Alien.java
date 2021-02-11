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

package lab7;

/**
* Class based on Niloufar's lab 7 - Q1, defines Alien objects.
* @author Giuliana Bouzon
*/
public class Alien {

    protected int damage;
    protected int health;  // 0 = dead, 100 = full strength
    protected String name;
    
    //default constructor
    public Alien() {
	this(50, "");
    }
    
    //parameterized constructor
    public Alien(int health, String name) {
	this.health = (health >= 0 && health <= 100) ? health : 50; 
	this.name = (name != null) ? name : "";
    }
    
    //copy constructor
    public Alien(Alien alien) {
	this(alien.health, alien.name);
    }
    
    @Override
    public String toString() {
	String str = "";
	
	str += String.format("%-20s: %d\n", "Health", health);
	str += String.format("%-20s: %s\n", "Name", name);
	
	return str;
    }
    
    //getters and setters
    
    public int getDamage() {
	return this.damage;
    }
    
    public int getHealth() {
	return this.health;
    }
    
    public void setHealth(int health) {
	if (health >= 0 && health <= 100)
	    this.health = health;
    }
    
    public String getName() {
	return this.name;
    }
    
    public void setName(String name) {
	if (name != null)
	    this.name = name;
    }
}
