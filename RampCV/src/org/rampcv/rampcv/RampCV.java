package org.rampcv.rampcv;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.rampcv.filters.ApplyColor;
import org.rampcv.filters.Brighter;
import org.rampcv.filters.GrayScale;

import com.rampcv.color.ColorDetector;


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
		ApplyColor apcl = new ApplyColor(src);
		return apcl;
	}
	
	public static BufferedImage detectColor(BufferedImage src, Color detect) {
		new ColorDetector(src, detect);
		return src;
	}
	
}
