package org.rampcv.filters;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Threshold {

	public Threshold(BufferedImage img) {
		
		int h = img.getHeight();
		int w = img.getWidth();
		
		int threshold = -128;
		int pixelIntensity = 0;
		Color white = new Color(255, 255, 255);
		
		for(int x=0;x<w;x++) {
			for(int y=0;y<h;y++) {
				
				pixelIntensity = ((img.getRGB(x, y)/65025));
				
				if(pixelIntensity > threshold) {
					img.setRGB(x, y, white.getRGB());
				}
				else
					img.setRGB(x, y, 0);
				
			}
		}
	}
}
