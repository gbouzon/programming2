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
* Class defining an OgreAlien object, child class of Alien.
* @author Giuliana Bouzon
*/
public class OgreAlien extends Alien {
    
     private final int damage = 6;
    
    //default constructor
    public OgreAlien() {
	super(50, "");
    }
    
    //parameterized constructor
    public OgreAlien(int health, String name) {
	super(health, name);
    }
    
    //copy constructor
    public OgreAlien(OgreAlien alien) {
	this(alien.health, alien.name);
    }
    
    @Override
    public String toString() {
	String str = "";
	
	str += String.format("%-20s: %d\n", "Damage Inflicted", damage);
	str += String.format("%-20s: %s\n", "Type:", "Ogre");
	
	return super.toString() + str;
    }
    
    // getters and setters
    
    public int getDamage() {
	return damage;
    }
}
