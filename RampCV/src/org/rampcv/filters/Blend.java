package org.rampcv.filters;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.rampcv.color.Range;

public class Blend {

	public class BlendMode {
		
		public static final int SCREEN = 1;
	}
	
	private int mode;
	BufferedImage i1, i2;
	
	public Blend(BufferedImage bg, BufferedImage fg, int blendMode) {
		
		mode = blendMode;
		i1 = bg;
		i2 = fg;
		
	}
	
	public BufferedImage apply() {
		
		switch(mode) {
		
		case BlendMode.SCREEN:
			return screen(i1, i2);
		case 2:
			return null;
		}
		
		return null;
	}
	
	private BufferedImage screen(BufferedImage i1, BufferedImage i2) {
		var h = i1.getHeight();
		var w = i1.getWidth();
		
		var out = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
		
		Color c1 = null, c2 = null;
		
		for(int x=0; x<w; x++) {
			for(int y=0; y<h; y++) {
				
				c1 = new Color(i1.getRGB(x, y));
				c2 = new Color(i2.getRGB(x, y));
				
				int rgb = (int) Range.constrain(screen_mode_formula(c1.getRGB(), c2.getRGB()), 0, 255);
				out.setRGB(x, y, rgb);
			}
		}
		
		return out;
	}
	
	
	
	private int screen_mode_formula(int rgb1, int rgb2) {
		int res = 255 - ((255 - rgb1) * (255 - rgb2));
		return res;
	}
	
	
	
	
}
