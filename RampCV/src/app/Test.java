package app;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import org.rampcv.image.RampIO;
import org.rampcv.rampcv.RampCV;

public class Test {

	public static void main(String[] args) throws IOException {
		
		BufferedImage src = RampIO.read("C:\\Users\\Ramesh\\Desktop\\fire.jpg");
		
		Color col = new Color(190, 0, 0);
		
		RampCV.detectColor(src, col);
		
		RampIO.write(src, "jpg", "C:\\Users\\Ramesh\\Desktop\\out_img.jpg");
	}

}
