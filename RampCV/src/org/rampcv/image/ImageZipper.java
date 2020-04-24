package org.rampcv.image;

import java.awt.image.BufferedImage;

/**Encode RampImage into BufferedImage.*/
public class ImageZipper {

	private BufferedImage out;
	
	public ImageZipper(RampImage img) {
		float[][] pixs = img.getPixels();
		this.out = new BufferedImage(img.width(), img.height(), BufferedImage.TYPE_3BYTE_BGR);
		
		for(int x=0; x<img.width(); x++) {
			for(int y=0; y<img.height(); y++) {
				this.out.setRGB(x, y, (int) pixs[x][y]);
			}
		}
		
	}
	
	public BufferedImage zippedImage() {
		return this.out;
	}
}
