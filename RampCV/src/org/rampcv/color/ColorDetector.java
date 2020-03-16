package org.rampcv.color;

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
						
					src.setRGB(x, y, src.getRGB(x, y));
				}
				else {
					Color c = new Color(src.getRGB(x, y));
					src.setRGB(x, y, toGray(c.getRed(), c.getGreen(), c.getBlue()).getRGB());
				}
				
			}
		}
		
	}
	
	private Color toGray(int R, int G, int B) {
		
		R = (int) (R * 0.3);
		G = (int) (G * 0.5);
		B = (int) (B * 0.1);
		
		return new Color(R+G+B, R+G+B, R+G+B); 
	}
	
	//euclidian distance of two RGB_color_space
	static double dist(double r1, double g1, double b1, double r2, double g2, double b2) {	
		return Math.sqrt(Math.pow((r1-r2), 2) + Math.pow((b1-b2), 2) + Math.pow((g1-g2), 2));
	}
	
}
