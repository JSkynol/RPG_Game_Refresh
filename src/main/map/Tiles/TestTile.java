package main.map.Tiles;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TestTile 	{
	private Image test;
	public TestTile() {
		try {
			test = ImageIO.read(new File("tiles/TileTest.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Image getImage(){
		return test;
	}
}
