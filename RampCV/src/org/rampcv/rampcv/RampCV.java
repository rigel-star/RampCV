package org.rampcv.rampcv;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.rampcv.color.BlobDetector;
import org.rampcv.color.InvertColor;
import org.rampcv.filters.ApplyColor;
import org.rampcv.filters.Brightness;
import org.rampcv.filters.Denoise;
import org.rampcv.filters.GrayScale;
import org.rampcv.filters.Pixelate;
import org.rampcv.filters.Saturation;
import org.rampcv.utils.Tools;

public class RampCV {

	
	public static Tools utils() {
		return new Tools();
	}
	
	
	public static BufferedImage rgb2gray(BufferedImage src) {
		new GrayScale(src);
		return src;
	}
	public static BufferedImage brighter(BufferedImage src, float intensity) {
		new Brightness(src, intensity);
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
	public static BufferedImage invertColors(BufferedImage src, boolean red, boolean green, boolean blue) {
		new InvertColor(src, red, green, blue);
		return src;
	}
	public static BufferedImage invertColors(BufferedImage src) {
		new InvertColor(src);
		return src;
	}
	public static BufferedImage saturation(BufferedImage src, float intensity) {
		new Saturation(src, intensity);
		return src;
	}
	public static BufferedImage denoise(BufferedImage src, int iteration) {
		new Denoise(src, iteration);
		return src;
	}
}
