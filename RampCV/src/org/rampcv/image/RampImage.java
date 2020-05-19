package org.rampcv.image;

import java.awt.image.BufferedImage;

public class RampImage {
	
	private float[][] pixels;
	private int height;
	private int width;
	
	public RampImage() {}
	
	
	//creates image with passed 2d array
	public RampImage(float[][] pixs) {
		this.width = pixs.length;
		this.height = pixs[0].length;
		this.pixels = pixs;
	}
	
	//creates blank image with all values 0.
	public RampImage(int w, int h) {
		pixels = new float[w][h];
	}
	
	
	
	public static int[] toIntArray(BufferedImage src) {
		
		var h = src.getHeight();
		var w = src.getWidth();
		
		var outArr = new int[w*h];
		
		for(int x=0; x<w; x++) {
			for(int y=0; y<h; y++) {
				var index = x + w * y;
				outArr[index] = src.getRGB(x, y);
			}
		}
		
		return outArr;
	}
	
	
	public int height() {
		return this.height;
	}
	public int width() {
		return this.width;
	}
	public void setPixels(float[][] pixels) {
		this.pixels = pixels;
	}
	public float[][] getPixels(){
		return this.pixels;
	}

}
