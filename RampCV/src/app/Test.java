package app;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.rampcv.image.RampIO;
import org.rampcv.rampcv.RampCV;

public class Test {

	public static void main(String[] args) throws IOException {
		
		BufferedImage img = ImageIO.read(new File("C:\\Users\\Ramesh\\Desktop\\opencv\\fruit.png"));
		RampCV.detectBlob(img, new Color(0, 200, 0));
		RampIO.write(img, "png", "C:\\Users\\Ramesh\\Desktop\\mack.png");
		
	}

}
