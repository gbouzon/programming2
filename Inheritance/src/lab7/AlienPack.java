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
* Class defining an AlienPack object, child class of Alien.
* @author Giuliana Bouzon
*/
public class AlienPack extends Alien {
    
    private Alien[] aliens;
    
    //default constructor
    public AlienPack(int numAliens) {
	aliens = new Alien[numAliens];
    }
    
    /**
     * Adds an Alien object to the specified index of the alien array.
     * @param newAlien, the input alien object.
     * @param index, the input index.
     */
    public void addAliens(Alien newAlien, int index) {
	aliens[index] = newAlien;
    }
    
    /**
     * Calculates the damage done by an alien.
     * @return the damage.
     */
    public int calculateDamage() {
	for (Alien alien : aliens) 
	    this.damage += alien.getDamage();

	return this.damage;
    }
    
    @Override
    public String toString() {
	String str = "";
	for (Alien alien : aliens) 
	    str += alien.toString() + "\n";
	
	return str;
    }
    
    //getter
    public Alien[] getAliens() {
	return this.aliens;
    }
}