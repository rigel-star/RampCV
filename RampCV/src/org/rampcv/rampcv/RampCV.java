package org.rampcv.rampcv;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.rampcv.color.BlobDetector;
import org.rampcv.color.InvertColor;
import org.rampcv.filters.ApplyColor;
import org.rampcv.filters.Brighter;
import org.rampcv.filters.Flip;
import org.rampcv.filters.GrayScale;
import org.rampcv.filters.Pixelate;


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
	
	public static BufferedImage detectBlob(BufferedImage src, Color detect) {
		new BlobDetector(src, detect);
		return src;
	}
	public static BufferedImage pixelate(BufferedImage src, int pixSize) {
		new Pixelate(src, pixSize);
		return src;
	}
	public static BufferedImage flip(BufferedImage img, boolean horizontal, boolean vertical) {
		return new Flip(img, horizontal, vertical).getFinalImage();
	}
	public static BufferedImage invertColors(BufferedImage img, boolean red, boolean green, boolean blue) {
		return new InvertColor(img, red, green, blue).getFinalImage();
	}
}
