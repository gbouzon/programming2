package singleDimensionalArrays;

import java.util.Random;

/**
 * A simple Face class.
 * @author Giuliana Bouzon
 *
 */
public class Face {

    private int eyeType;
    private int noseType;
    private String mouthColor;   //can only have specific values
	
    //enum
    private static final int MAX_EYE_TYPE = 2;
    private static final int MAX_NOSE_TYPE = 2;
    private static final String[] VALID_MOUTH_COLORS = {"Red", "Pink", "Orange"};
	
    //default constructor
    public Face() {
	Random rand = new Random();
	this.eyeType = rand.nextInt(MAX_EYE_TYPE + 1);
	this.noseType = rand.nextInt(MAX_NOSE_TYPE + 1);
	this.mouthColor = VALID_MOUTH_COLORS[rand.nextInt(VALID_MOUTH_COLORS.length)];
    }
	
    //parameterized constructor
    public Face(int eyeType, int noseType, String mouthColor) {
	this.eyeType = (eyeType >= 0 && eyeType < MAX_EYE_TYPE) ? eyeType : 0;
	this.noseType = (noseType >= 0 && noseType < MAX_NOSE_TYPE) ? eyeType : 0;
	this.mouthColor = (isMouthColorValid(mouthColor)) ? mouthColor : "Red";	
    }
	
    /**
     * Checks if a mouth color belongs to the validMouthColors array
     * @param mouthColor, the input mouthColor needs to be validated
     * @return true if the mouth color belongs to the validMouthColors array
     */
    public boolean isMouthColorValid(String mouthColor) {
	for (String color : VALID_MOUTH_COLORS)
	    if (mouthColor.equalsIgnoreCase(color))
		return true;
	
	return false;
    }

    //getters and setters
    public int getEyeType() {
	return this.eyeType;
    }

    //here we're only changing the value of the eyeType if it 
    //matches the specified limitations. Otherwise, we leave it as is.
    public void setEyeType(int eyeType) {
	if (eyeType >= 0 && eyeType < MAX_EYE_TYPE)
	    this.eyeType = eyeType;
    }	

    public int getNoseType() {
	return this.noseType;
    }

    public void setNoseType(int noseType) {
	if (noseType >= 0 && noseType < MAX_NOSE_TYPE)
	    this.noseType = noseType;
    }

    public String getMouthColor() {
	return mouthColor;
    }

    public void setMouthColor(String mouthColor) {
	if (isMouthColorValid(mouthColor))
	    this.mouthColor = mouthColor;
    }
}
