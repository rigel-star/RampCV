package org.rampcv.image;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RampIO {
	
	public static RampImage read(String path) {
		RampImage rimg = null;
		try {
			ImageExtractor ext = new ImageExtractor(path);
			rimg = new RampImage(ext.extractedImg());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rimg;
	}
	
	/**RampImage: renderedImage
	 * extn: eg. PNG, JPG
	 * path: directory on your computer
	 * */
	public static boolean write(RampImage img, String extn, String path) {
		
		if(img == null || extn == null || path == null) {
			throw new NullPointerException("Image, extn and path can't be null.");
		}
		
		try {
			ImageIO.write(new ImageZipper(img).zippedImage(), "jpg", new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
}
