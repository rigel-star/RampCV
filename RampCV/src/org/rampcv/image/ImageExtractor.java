package org.rampcv.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**Decode path and make RampImage Object out of it.*/
public class ImageExtractor {

	private float[][] pixs;
	private int height;
	private int width;
	
	public ImageExtractor(String path) throws IOException {
		this(ImageIO.read(new File(path)));	
	}
	
	public ImageExtractor(BufferedImage img) {
		
		if(img == null) {
			throw new IllegalArgumentException("Can't read image file");
		}
		
		this.height = img.getHeight();
		this.width = img.getWidth();
		
		this.pixs = new float[this.width][this.height];
		
		for(int x=0; x<this.width; x++) {
			for(int y=0; y<this.height; y++) {
				pixs[x][y] = img.getRGB(x, y);
			}
		}
	}
	
	
	public int height() {
		return this.height;
	}
	public int width() {
		return this.width;
	}
	
	public float[][] extractedImg(){
		return this.pixs;
	}
}
