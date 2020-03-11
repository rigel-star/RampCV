package org.rampcv.filters;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class GrayScale {
	
	public GrayScale(BufferedImage src) {
		
		int h = src.getHeight();
		int w = src.getWidth();
		
		for(int y=0;y<h;y++) {
			for(int x=0;x<w;x++) {
				
				Color col = new Color(src.getRGB(x, y));
				
				int R = (int) (col.getRed() * 0.5);
				int G = (int) (col.getGreen() * 0.3);
				int B = (int) (col.getBlue() * 0.1);
				
				Color newCol = new Color(R+G+B, R+G+B, R+G+B);
				
				src.setRGB(x, y, newCol.getRGB());
				
			}
		}
		
	}
	
}
