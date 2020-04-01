package org.rampcv.color;

import java.awt.image.BufferedImage;

import org.rampcv.utils.Tools;

public class InvertColor {
	
	public InvertColor(BufferedImage img, boolean red, boolean green, boolean blue) {
		
		for(int x=0;x<img.getWidth();x++) {
			for(int y=0;y<img.getHeight();y++) {
				
				float[] rgb = Tools.getColor(img, x, y);
				
				if(red)
					rgb[0] = 255 - rgb[0];
				if(green)
					rgb[1] = 255 - rgb[1];
				if(blue)
					rgb[2] = 255 - rgb[2];
				
				Tools.setColor(img, rgb, x, y);
			}
		}
	}
	
	public InvertColor(BufferedImage img) {
		
		for(int x=0;x<img.getWidth();x++) {
			for(int y=0;y<img.getHeight();y++) {
				
				float[] rgb = Tools.getColor(img, x, y);
				
				rgb[0] = 255 - rgb[0];
				rgb[1] = 255 - rgb[1];
				rgb[2] = 255 - rgb[2];
				
				Tools.setColor(img, rgb, x, y);
			}
		}
	}
	
}
