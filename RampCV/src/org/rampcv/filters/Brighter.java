package org.rampcv.filters;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class Brighter {

	public Brighter(BufferedImage src) {
		
		BufferedImage out = new BufferedImage(src.getWidth(), src.getHeight(), src.getType());
		
		Kernel kernel = new Kernel(3, 3, new float[] {-1,-1,-1,-1,9,-1,-1,-1,-1});
		BufferedImageOp op = new ConvolveOp(kernel);
		out = op.filter(src, out);
		
		src = out;
	}
}
