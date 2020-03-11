package org.rampcv.filters;

import java.awt.Color;
import java.awt.image.BufferedImage;

public interface RampApplyColor {

	BufferedImage reddish();
	BufferedImage bluish();
	BufferedImage greenish();
	BufferedImage applyColor(int col);
	BufferedImage applyColor(Color col);
	
}
