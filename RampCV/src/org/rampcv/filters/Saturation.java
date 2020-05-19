package org.rampcv.filters;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.rampcv.color.Range;
import org.rampcv.utils.Tools;

public class Saturation {

	public Saturation(BufferedImage img, float intensity) {
		intensity = Range.constrain(intensity, 0.0f, 1.0f);
		
		if(intensity == 0)
			return;
		
		for(int x=0;x<img.getWidth();x++) {
			for(int y=0;y<img.getHeight();y++) {
				
				Color col = new Color(img.getRGB(x, y));
				float[] hsb = Tools.RGBtoHSB(col.getRed(), col.getGreen(), col.getBlue());
				
				hsb[1] = Range.constrain(hsb[1] * intensity, 0.0f, 1.0f);
				img.setRGB(x, y, Tools.HSBtoRGB(hsb[0], hsb[1], hsb[2]));
			}
		}
	}
	
	
	public static int incSaturation(BufferedImage src, int x, int y, float intensity) {
		
		float[] hsb;
		Color color;
		
		if(intensity <= 0) {
			return src.getRGB(x, y);
		}
		
		color = new Color(src.getRGB(x, y));
		int r = color.getRed();
		int g = color.getGreen();
		int b = color.getBlue();
		
		hsb = Tools.RGBtoHSB(r, g, b);
		
		hsb[1] = Range.constrain(hsb[1] * intensity, 0.0f, 1.0f);
		
		return (int) hsb[1];
	}
	
	
}
