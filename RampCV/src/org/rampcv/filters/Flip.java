package org.rampcv.filters;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.rampcv.utils.Tools;

public class Flip {
	
	private BufferedImage  out;
	
	public Flip(BufferedImage img, boolean horizontal, boolean vertical) {
		this.out = Tools.createBlankImageLike(img);
		
		int h = img.getHeight();
		int w = img.getWidth();
		
		for(int x=0;x<w;x++) {
			for(int y=0;y<h;y++) {
				
				Color color = new Color(img.getRGB(x, y));
				int newx = horizontal ? (img.getWidth() - x) - 1 : x;
				int newy = vertical ?( img.getHeight() - y ) - 1: y;
				
				this.out.setRGB(newx, newy, color.getRGB());
			}
		}
	}
	
	public BufferedImage getFinalImage() {
		return this.out;
	}

}
