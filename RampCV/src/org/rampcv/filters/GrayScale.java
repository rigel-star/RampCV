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
				
				rgb = Tools.getGray(rgb);
				
				Color newCol = new Color(rgb[0]+rgb[1]+rgb[2],
						rgb[0]+rgb[1]+rgb[2],
						rgb[0]+rgb[1]+rgb[2]);
				
				src.setRGB(x, y, newCol.getRGB());
				
			}
		}
		
	}
	
}
