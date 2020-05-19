package app;
 
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.rampcv.utils.Tools;


public class Test {

	public static void main(String[] args) throws IOException {
		
		var img1 = ImageIO.read(new File("C:\\Users\\Ramesh\\Desktop\\styletransfer\\galaxy.jpg"));
		var img2 = ImageIO.read(new File("C:\\Users\\Ramesh\\Desktop\\styletransfer\\model.jpg"));
		
		var out = mix(img1, img2);
		
		ImageIO.write(out, "jpg", new File("C:\\Users\\Ramesh\\Desktop\\model.jpg"));
		
	}
	
	public static BufferedImage mix(BufferedImage src, BufferedImage dest) {
		
		var h = Math.min(src.getHeight(), dest.getHeight());
		var w = Math.min(src.getWidth(), dest.getWidth());
		
		BufferedImage out = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
		
		
		for(int x=0; x<w; x++) {
			for(int y=0; y<h; y++) {
				
				int rgb = Tools.mixColors(0.5f, src.getRGB(x, y), dest.getRGB(x, y));
				Tools.setColor(out, rgb, x, y);
			}
		}
		
		
		return out;
		
	}
	
}
