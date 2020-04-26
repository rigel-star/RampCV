package org.rampcv.color;

import java.awt.Color;

public class Range {

	private double rgb;
	
	public Range is(double rgb) {
		this.rgb = rgb;
		return this;
	}
	
	public boolean inRange(double v1, double v2) {
		
		if(this.rgb > v1 && this.rgb < v2) {
			return true;
		}
		
		return false;
	}
	
	public boolean inRange(Color min, Color max) {
		
		if(this.rgb > min.getRGB() && this.rgb < max.getRGB()) {
			return true;
		}
		
		return false;
	}
	
	public static float constrain(float value, float min, float max) { //balance value between min and max
		if(value < min)
			value = min;
		if(value > max)
			value = max;
		return value;
	}
	
	static int[] constrain(int[] rgb) {		//balance rgb to not go over 255 and not go below 0.	
		int[] out = new int[rgb.length];
		for(int i=0; i<rgb.length; i++) {
			if(rgb[i] > 255)
				rgb[i] = 255;
			if(rgb[i] < 0)
				rgb[i] = 0;
			out[i] = rgb[i];
		}
		return out;
	}
}
