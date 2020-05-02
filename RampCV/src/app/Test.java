package app;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.rampcv.filters.textures.Texture;
import org.rampcv.filters.textures.WoodenTexture;


public class Test {

	public static void main(String[] args) throws IOException {
		
		var img1 = ImageIO.read(new File("C:\\Users\\Ramesh\\Desktop\\styletransfer\\model.jpg"));
		
		Texture text = new WoodenTexture(img1, 0.2f);
		var out = text.apply();
		
		ImageIO.write(out, "jpg", new File("C:\\Users\\Ramesh\\Desktop\\model.jpg"));
		
	}
}
