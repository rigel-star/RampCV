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
}
