package org.rampcv.filters;

import java.awt.image.BufferedImage;
import java.util.Collections;
import java.util.List;

import org.rampcv.utils.Tools;

public class Denoise {

	public Denoise(BufferedImage img, int iteration) {
		
		for(int i=0;i<iteration;i++) {
			
			for(int x=1;x<img.getWidth()-1;x++) {
				for(int y=1;y<img.getHeight()-1;y++) {
					
					List<Integer> neighbors = Tools.getNeighbors(img, x, y);
					Collections.sort(neighbors);
					
					int median = neighbors.get(neighbors.size() / 2);
					img.setRGB(x, y, median);
				}
			}
			
		}
		
	}
}
