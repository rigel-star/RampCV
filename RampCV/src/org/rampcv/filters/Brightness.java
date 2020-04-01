package org.rampcv.filters;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.rampcv.color.Range;
import org.rampcv.utils.Tools;

public class Brightness {

	public Brightness(BufferedImage src, float intensity) {
		
		for(int x=0;x<src.getWidth();x++) {
			for(int y=0;y<src.getHeight();y++) {
				
				Color col = new Color(src.getRGB(x, y));
				
				float[] rgb = new float[3];
				
				rgb[0] = col.getRed() + intensity;
				rgb[1] = col.getGreen() + intensity;
				rgb[2] = col.getBlue() + intensity;
				
				rgb[0] = Range.constrain(rgb[0], 0, 255);
				rgb[1] = Range.constrain(rgb[1], 0, 255);
				rgb[2] = Range.constrain(rgb[2], 0, 255);
				
				Tools.setColor(src, rgb, x, y);
			}
		}
	}
}
