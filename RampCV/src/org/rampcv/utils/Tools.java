package org.rampcv.utils;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import org.rampcv.image.RampImage;

public class Tools {

	//creates the image like passed parameter, with same height, width and type
	public static BufferedImage createBlankImageLike(BufferedImage img) {
		return new BufferedImage(img.getWidth(),  img.getHeight(), BufferedImage.TYPE_INT_ARGB);
	}
	
	//creates bufferedimage with given type
	public static BufferedImage createBlankImageLike(BufferedImage img, int type) {
		return new BufferedImage(img.getWidth(),  img.getHeight(), type);
	}
	
	public static RampImage createBlankImageLike(RampImage img) {
		RampImage out = new RampImage(img.width(), img.height()));
		return out;
	}
	
	//creates image like the passed argument, same width, height and data.
	public static BufferedImage copyImage(BufferedImage img) {
		BufferedImage out = Tools.createBlankImageLike(img);
		for(int x=0; x<img.getWidth(); x++) {
			for(int y=0; y<img.getHeight(); y++) {
				out.setRGB(x, y, img.getRGB(x, y));
			}
		}
		return out;
	}
	
	//returns all the neighbors of particular pixel
	public static List<Integer> getNeighbors(BufferedImage img, int x, int y){
		List<Integer> list = new ArrayList<Integer>();
		
		for(int y_=-1;y_<=1;y_++) {
			for(int x_=-1;x_<=1;x_++) {
				list.add(img.getRGB(x+x_, y+y_));
			}
		}
		return list;
	}
	
	//sets the passed rgb color on passed image
	public static void setColor(BufferedImage img, float[] rgb, int x, int y) {
		Color col = new Color((int) rgb[0], (int) rgb[1], (int) rgb[2]);
		img.setRGB(x, y, col.getRGB());
	}
	
	//returns the color of passed image pixel
	public static float[] getColor(BufferedImage img, int x, int y) {
		Color col = new Color(img.getRGB(x, y));
		return new float[] {col.getRed(), col.getGreen(), col.getBlue()};
	}
	
	//returns the grayscale value of given rgb
	public static int[] getGray(int[] rgb) {
		rgb[0] = rgb[0] >> 16;
		rgb[1] = rgb[1] >> 8;
		rgb[2] = rgb[2] >> 0;
		
		return new int[] {rgb[0], rgb[1], rgb[2]};
	}
	
	//get gray format of RampImage
	public static RampImage getGray(RampImage img) {
		float[][] pixs = img.getPixels();
		Color normal;
		Color gray;
		
		for(int x=0; x<img.width(); x++) {
			for(int y=0; y<img.height(); y++) {
				normal = new Color((int) pixs[x][y]);
				int[] rgb = {normal.getRed(), normal.getGreen(), normal.getBlue()};
				rgb = Tools.getGray(rgb);
				gray = new Color(rgb[0]+rgb[1]+rgb[2], rgb[0]+rgb[1]+rgb[2], rgb[0]+rgb[1]+rgb[2]);
				pixs[x][y] = gray.getRGB();
			}
		}
		
		RampImage out = new RampImage(pixs);
		return out;
	}
	
	//converting given color from rgb to hsb
	public static float[] RGBtoHSB(int r, int g, int b) {
		float[] hsb = new float[3];
		Color.RGBtoHSB(r, g, b, hsb);
		return hsb;
	}
	
	//converting given color from hsb to rgb
	public static int HSBtoRGB(float h, float s, float b) {
		return Color.HSBtoRGB(h, s, b);
	}
	
	//averaging the pixels intensity
	public static float average(List<Integer> list) {
		int total = 0;
		for(int i: list) {
			total += i;
		}
		return total / list.size();
	}
}





