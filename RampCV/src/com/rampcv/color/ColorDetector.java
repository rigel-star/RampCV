package com.rampcv.color;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class ColorDetector {
	
	public ColorDetector(BufferedImage src, Color detect) {
		
		int h = src.getHeight();
		int w = src.getWidth();
		
		Range r = new Range();
		
		//eg: orange color
		//new Color(255,165,0);
		
		// detect color
		Color trackCol = detect;
		
		//eg: blue color
		//new Color(0, 0, 128);
		
		Color col;
		double diff;
		
		
		for(int y=0;y<h;y++) {
			for(int x=0;x<w;x++) {
				
				col = new Color(src.getRGB(x, y));
				
				diff = dist(trackCol.getRed(), trackCol.getGreen(), trackCol.getBlue(),
						col.getRed(), col.getGreen(), col.getBlue());
				
				/*if the euclidian dist between two colors is in range hundered then
				*those colors come close and seems same
				*/
				if(r.is(Math.abs(diff)).inRange(0, 100)) {
						
					src.setRGB(x, y, detect.getRGB());
				}
				else
					src.setRGB(x, y, new Color(0, 0, 0).getRGB());
				
			}
		}
		
	}
	
	//euclidian distance of two RGB_color_space
	static double dist(double r1, double g1, double b1, double r2, double g2, double b2) {	
		return Math.sqrt(Math.pow((r1-r2), 2) + Math.pow((b1-b2), 2) + Math.pow((g1-g2), 2));
	}
	
}
