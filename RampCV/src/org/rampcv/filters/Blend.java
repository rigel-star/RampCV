package org.rampcv.filters;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.rampcv.color.Range;

/**
 * Blend two images together with many blend modes.
 * */
public class Blend {

	
	/**
	 * Blend modes to apply to images.
	 * */
	public class BlendMode {

		public static final int ADD = 1;
		public static final int LIGHTEN = 2;
		public static final int DARKEN = 3;
		public static final int SCREEN = 4;
		public static final int DODGE = 5;
		
	}

	private int mode;
	
	/*src: the image which is going to be blended in dest image
	 * dest: the background image where src will be blended
	 * out: the result image after effect is applied
	 * */
	private BufferedImage src, dest, out;

	private int width;
	private int height;
	
	public Blend(BufferedImage src, BufferedImage dest, int blendMode) {

		mode = blendMode;
		this.src = src;
		this.dest = dest;

		height = Math.min(src.getHeight(), dest.getHeight());
		width = Math.min(src.getWidth(), dest.getWidth());

		out = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
	}

	
	/**
	 * @return finalImg after applying the requested blend mode.
	 * */
	public BufferedImage apply() {

		switch (mode) {

		case BlendMode.ADD:
			return blend_add(src, dest);
		
		case BlendMode.LIGHTEN:
			return blend_lighten(src, dest);
		
		case BlendMode.DARKEN:
			return blend_darken(src, dest);
		
		case BlendMode.SCREEN:
			return blend_screen(src, dest);
			
		case BlendMode.DODGE:
			return blend_dodge(src, dest);
			
		default:
			return src;
			
		}
	}



	/*adding two images together. mode: ADD*/
	private BufferedImage blend_add(BufferedImage src, BufferedImage dest) {

		Color srcColor = null, destColor = null, resultColor = null;

		for (int x = 0; x < this.width; x++) {
			for (int y = 0; y < this.height; y++) {

				srcColor = new Color(src.getRGB(x, y));
				destColor = new Color(dest.getRGB(x, y));

				int[] rgb = { srcColor.getRed() + destColor.getRed(), srcColor.getGreen() + destColor.getGreen(),
						destColor.getBlue() + destColor.getBlue(), srcColor.getAlpha() + destColor.getAlpha() };

				rgb = Range.constrain(rgb);

				resultColor = new Color(rgb[0], rgb[1], rgb[2]);
				this.out.setRGB(x, y, resultColor.getRGB());
			}
		}

		return this.out;
	}

	
	/*lighten mode
	 * applies the max color value between srcRGB and destRGB to final image
	 * */
	private BufferedImage blend_lighten(BufferedImage src, BufferedImage dest) {

		Color srcColor = null, destColor = null, resultColor = null;

		for (int x = 0; x < this.width; x++) {
			for (int y = 0; y < this.height; y++) {

				srcColor = new Color(src.getRGB(x, y));
				destColor = new Color(dest.getRGB(x, y));

				resultColor = new Color(Math.max(srcColor.getRGB(), destColor.getRGB()));

				this.out.setRGB(x, y, resultColor.getRGB());
			}
		}

		return this.out;
	}

	
	/*lighten mode
	 * applies the min color value between srcRGB and destRGB to final image
	 * */
	private BufferedImage blend_darken(BufferedImage src, BufferedImage dest) {

		Color srcColor = null, destColor = null, resultColor = null;

		for (int x = 0; x < this.width; x++) {
			for (int y = 0; y < this.height; y++) {

				srcColor = new Color(src.getRGB(x, y));
				destColor = new Color(dest.getRGB(x, y));

				resultColor = new Color(Math.min(srcColor.getRGB(), destColor.getRGB()));

				this.out.setRGB(x, y, resultColor.getRGB());
			}
		}

		return this.out;
	}

	
	
	/*screen mode*/
	private BufferedImage blend_screen(BufferedImage src, BufferedImage dest) {

		Color srcColor = null, destColor = null, resultColor = null;

		for (int x = 0; x < this.width; x++) {
			for (int y = 0; y < this.height; y++) {
				
				srcColor = new Color(src.getRGB(x, y));
				destColor = new Color(dest.getRGB(x, y));
				
				resultColor = new Color(
						srcColor.getRGB() + destColor.getRGB() - 
						srcColor.getRGB() + destColor.getRGB()
						);
				
				this.out.setRGB(x, y, resultColor.getRGB());
			}
		}
		
		return this.out;
	}
	
	
	
	/*divide images*/
	private BufferedImage blend_dodge(BufferedImage src2, BufferedImage dest2) {
		
		Color srcColor = null, destColor = null, resultColor = null;

		for (int x = 0; x < this.width; x++) {
			for (int y = 0; y < this.height; y++) {
				
				srcColor = new Color(src.getRGB(x, y));
				destColor = new Color(dest.getRGB(x, y));
				
				resultColor = new Color(srcColor.getRGB() / 1 - destColor.getRGB());
				
				this.out.setRGB(x, y, resultColor.getRGB());
			}
		}
		
		return this.out;
	}
	
	
	
	
	
}
