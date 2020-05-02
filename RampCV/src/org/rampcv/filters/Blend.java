package org.rampcv.filters;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.rampcv.color.Range;

public class Blend {

	public class BlendMode {
		
		public static final int ADD = 1;
	}
	
	private int mode;
	BufferedImage src, dest;
	
	public Blend(BufferedImage src, BufferedImage dest, int blendMode) {
		
		mode = blendMode;
		this.src = src;
		this.dest = dest;
		
	}
	
	public BufferedImage apply() {
		
		switch(mode) {
		
		case BlendMode.ADD:
			return blend_add(src, dest);
		case 2:
			return null;
		}
		
		return null;
	}
	
	private BufferedImage blend_add(BufferedImage src, BufferedImage dest) {
		var h = dest.getHeight();
		var w = dest.getWidth();
		
		var out = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
		
		Color srcColor = null, destColor = null, resultColor = null;
		
		for(int x=0; x<w; x++) {
			for(int y=0; y<h; y++) {
				
				srcColor = new Color(src.getRGB(x, y));
				destColor = new Color(dest.getRGB(x, y));
				
				int[] rgb = {
						srcColor.getRed() + destColor.getRed(),
						srcColor.getGreen() + destColor.getGreen(),
						destColor.getBlue() + destColor.getBlue(),
						srcColor.getAlpha() + destColor.getAlpha()
				};
				
				rgb = Range.constrain(rgb);
				
				resultColor = new Color(rgb[0], rgb[1], rgb[2]);
				out.setRGB(x, y, resultColor.getRGB());
			}
		}
		
		return out;
	}
	
}
