package app;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.rampcv.image.RampIO;
import org.rampcv.rampcv.RampCV;

public class Test {

	public static void main(String[] args) throws IOException {
		
		BufferedImage src = RampIO.read("C:\\Users\\Ramesh\\Desktop\\opencv\\mack.jpg");
		
		RampCV.applyColor(src).reddish();
		
		RampIO.write(src, "jpg", "C:\\Users\\Ramesh\\Desktop\\test_img.jpg");
	}

}
