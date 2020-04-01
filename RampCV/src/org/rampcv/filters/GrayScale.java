package org.rampcv.filters;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.rampcv.utils.Tools;

public class GrayScale {
	
	public GrayScale(BufferedImage src) {
		
		int h = src.getHeight();
		int w = src.getWidth();
		
		for(int y=0;y<h;y++) {
			for(int x=0;x<w;x++) {
				
				Color col = new Color(src.getRGB(x, y));
				
				int[] rgb = {
						col.getRed(), col.getGreen(), col.getBlue()
				};
				
				int R = Tools.getGray(rgb)[0];
				int G = Tools.getGray(rgb)[1];
				int B = Tools.getGray(rgb)[2];
				
				Color newCol = new Color(R+G+B, R+G+B, R+G+B);
				
				src.setRGB(x, y, newCol.getRGB());
				
			}
		}
		
	}
	
}
