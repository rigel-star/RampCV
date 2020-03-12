package app;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import org.rampcv.image.RampIO;
import org.rampcv.rampcv.RampCV;

public class Test {

	public static void main(String[] args) throws IOException {
		
		BufferedImage src = RampIO.read("C:\\Users\\Ramesh\\Desktop\\org.jpg");
		
		RampCV.detectColor(src, new Color(255,165,0));
		
		RampIO.write(src, "jpg", "C:\\Users\\Ramesh\\Desktop\\out_img.jpg");
	}

}
