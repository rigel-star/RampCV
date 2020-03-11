package org.rampcv.rampcv;

import java.awt.image.BufferedImage;

import org.rampcv.filters.ApplyColor;
import org.rampcv.filters.Brighter;
import org.rampcv.filters.GrayScale;


public class RampCV {

	public static BufferedImage rgb2gray(BufferedImage src) {
		new GrayScale(src);
		return src;
	}
	
	public static BufferedImage brighter(BufferedImage src) {
		new Brighter(src);
		return src;
	}
	
	public static ApplyColor applyColor(BufferedImage src) {
		return new ApplyColor(src);
	}
	
}
