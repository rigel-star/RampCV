package org.rampcv.filters;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

public class Pixelate {
	
	private final int PIX_SIZE;
	private BufferedImage src;
	
	public Pixelate(BufferedImage src, int pixSize) {
		
		//making the pixels big as per user input
		this.PIX_SIZE = pixSize;
		//assign private property to given src, which will be retunred as pixelated image
		this.src = src;
		
		doPixelate(this.src);
	}
	
	private boolean doPixelate(BufferedImage src) {
		
		if(src == null)
			return false;
		
		final int h = src.getHeight();
		final int w = src.getWidth();
		
		//get image data from bufferedImage and store in raster
		Raster raster = src.getData();
		
		//writable raster: creates image using raster class properties
		WritableRaster wRaster = raster.createCompatibleWritableRaster();
		
		for(int y=0; y<h; y+=this.PIX_SIZE) { 
			for(int x=0; x<w; x+=this.PIX_SIZE) {
				
				double[] pixel = new double[3];
				pixel = raster.getPixel(x, y, pixel);
				
				for(int yd = y; (yd < y + PIX_SIZE) && (yd < h); yd++) {
		            for(int xd = x; (xd < x + PIX_SIZE) && (xd < w); xd++) {
		                wRaster.setPixel(xd, yd, pixel);
		            }
		        }
				
			}
		}
		
		src.setData(wRaster);
		
		return true;
	}
	
	public BufferedImage getPixelatedImg() {
		return this.src;
	}

}
