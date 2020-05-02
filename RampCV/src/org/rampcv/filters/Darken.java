package org.rampcv.filters;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.rampcv.color.Range;
import org.rampcv.utils.Tools;

public class Darken {

	public Darken(BufferedImage img, int perc) {
		
		var h = img.getHeight();
		var w = img.getWidth();
		
		Color col = null;
		
		for(int x=0; x<w; x++) {
			for(int y=0; y<h; y++) {
			
				col = new Color(img.getRGB(x, y));
				
				int r = col.getRed();
				int g = col.getGreen();
				int b = col.getBlue();
				
				float[] hsb = Tools.RGBtoHSB(r, g, b);
				
				hsb[2] -= perc;
				
				int rgb =  (int) Range.constrain(Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]), 0, 255) ;
				Color res = new Color(rgb);
				
				img.setRGB(x, y, res.getRGB());
			}
		}
	}
}
