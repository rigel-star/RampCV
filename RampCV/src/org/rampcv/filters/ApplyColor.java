package org.rampcv.filters;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class ApplyColor implements RampApplyColor{

	private BufferedImage src;
	int col;
	Color color;
	private int h, w;
	
	public ApplyColor(BufferedImage src, int col) {
		this.src = src;
		this.col = col;
	}
	
	public ApplyColor(BufferedImage src, Color col) {
		this.src = src;
		this.color = col;
	}
	
	public ApplyColor(BufferedImage src) {
		this.src = src;
		this.h = src.getHeight();
		this.w = src.getWidth();
	}
	
	@Override
	public BufferedImage reddish() {
		
		for(int y=0;y<h;y++) {
			for(int x=0;x<w;x++) {
				
				Color col = new Color(src.getRGB(x, y));
				
				int R = col.getBlue();
				int G = 0;
				int B = 0;
				
				col = new Color(R, G, B);
				
				src.setRGB(x, y, col.getRGB());
				
				
			}
		}
		
		return this.src;
	}

	@Override
	public BufferedImage bluish() {
		
		return null;
	}

	@Override
	public BufferedImage greenish() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BufferedImage applyColor(int col) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BufferedImage applyColor(Color col) {
		// TODO Auto-generated method stub
		return null;
	}

}
