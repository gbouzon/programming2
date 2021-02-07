package singleDimensionalArrays;

import java.util.Random;

//a new class, a new type: MouthColor
//states that MouthColor can only have 3 values, so we don't need to check
//the value of a mouthColor before setting it (look at Face class for reference)
enum MouthColor{
	RED,
	PINK,
	ORANGE
}

/**
 * An alias of Face class where the mouth colors 
 * are done with enum instead of String
 * @author Giuliana Bouzon
 *
 */
public class Face_enum {

    private int eyeType;
    private int noseType;
    private MouthColor mouthColor;   //can only have set values in enum class
	
    //enum
    private static final int MAX_EYE_TYPE = 2;
    private static final int MAX_NOSE_TYPE = 2;
	
    public Face_enum() {
	Random rand = new Random();
	this.eyeType = rand.nextInt(MAX_EYE_TYPE + 1);
	this.noseType = rand.nextInt(MAX_NOSE_TYPE + 1);
	this.mouthColor = MouthColor.values()[rand.nextInt(MouthColor.values().length)];
    }
	
    public Face_enum(int eyeType, int noseType, MouthColor mouthColor) {
	this.eyeType = (eyeType >= 0 && eyeType < MAX_EYE_TYPE) ? eyeType : 0;
	this.noseType = (noseType >= 0 && noseType < MAX_NOSE_TYPE) ? eyeType : 0;
	this.mouthColor = mouthColor;	
    }

    //getters and setters
    public int getEyeType() {
	return this.eyeType;
    }

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

    public MouthColor getMouthColor() {
	return mouthColor;
    }

    public void setMouthColor(MouthColor mouthColor) {
	this.mouthColor = mouthColor;
    }
}