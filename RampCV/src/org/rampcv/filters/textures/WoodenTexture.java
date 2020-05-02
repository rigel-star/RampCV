package org.rampcv.filters.textures;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.rampcv.utils.Tools;

public class WoodenTexture implements Texture {

	private BufferedImage texture;
	private BufferedImage dest;
	private float opacity;
	
	public WoodenTexture(BufferedImage dest) {
		this(dest, 0.5f);
	}
	
	
	public WoodenTexture(BufferedImage dest, float opacity) {
		this.dest = dest;
		this.opacity = opacity;
		
		try {
			this.texture = ImageIO.read(new File("imgs/textures/wooden1.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public BufferedImage apply() {
		var out = Tools.createBlankImageLike(dest);
		
		Graphics2D g = dest.createGraphics();
		g.setComposite(AlphaComposite.SrcOver.derive(this.opacity));
		g.drawImage(texture, 0, 0, null);
		
		out = dest;
		return out;
	}
	
	
	
	
	
	
	
}
