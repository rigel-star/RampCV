package org.rampcv.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RampIO {

	public static BufferedImage read(String path) throws IOException {
		BufferedImage img = ImageIO.read(new File(path));
		return img;
	}
	
	public static boolean write(BufferedImage renderedImg, String extn, String path) throws IOException {
		
		if(renderedImg == null || extn == null || path == null)
			return false;
		
		ImageIO.write(renderedImg, extn, new File(path));
		
		return true;
	}
	
}
