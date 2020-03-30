package org.rampcv.utils;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


public class Tools {

	//crates the image like passed parameter, with same height, width and type
	public static BufferedImage createBlankImageLike(BufferedImage img) {
		return new BufferedImage(img.getWidth(),  img.getHeight(), img.getType());
	}
	
	//returns all the neighbors of particular pixel
	public static List<Integer> getNeighbors(BufferedImage img, int x, int y){
		int n1 = img.getRGB(x, y);
		int n2 = img.getRGB(x-1, y-1);
		int n3 = img.getRGB(x, y-1);
		int n4 = img.getRGB(x+1, y-1);
		int n5 = img.getRGB(x-1, y);
		int n6 = img.getRGB(x+1, y);
		int n7 = img.getRGB(x-1, y-1);
		int n8 = img.getRGB(x, y+1);
		int n9 = img.getRGB(x+1, y+1);
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(n2);
		list.add(n3);
		list.add(n4);
		list.add(n5);
		list.add(n1);
		list.add(n6);
		list.add(n7);
		list.add(n8);
		list.add(n9);
		
		return list;
	}
	
	//sets the passed rgb color on passed image
	public static void setColor(BufferedImage img, int[] rgb, int x, int y) {
		Color col = new Color(rgb[0] + rgb[1] + rgb[2]);
		img.setRGB(x, y, col.getRGB());
	}
	
	//returns the color of passed image pixel
	public static int[] getColors(BufferedImage img, int x, int y) {
		Color col = new Color(img.getRGB(x, y));
		return new int[] {col.getRed(), col.getGreen(), col.getBlue()};
	}
	
}





