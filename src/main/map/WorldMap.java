package main.map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;

import main.DataTypes.CPanel;
import main.map.Tiles.TestTile;

public class WorldMap {
private final int tileSize=16;
	private CPanel worldPanel = new CPanel() {
		private boolean switcher = false;
		private boolean switcher2 = false;

		@Override
		public void paintComponent(Graphics g) {
			if (g != null) {
			}
			super.paintComponent(g);
			for (int a = 0; a < xSize; a += 16) {
				for (int b = 0; b < ySize; b += 16) {

					g.setColor(new Color(10,10,15,2));
					g.fillRect(a, b, 16, 16);
					if (switcher) {
						if(switcher2){
						g.drawImage(test.getImage(), a, b, a + 16, b + 16, 0, 0, 16, 16, null);
						}else{
							g.drawImage(test.getImage(), a, b, a + 16, b + 16, 0, 32, 16, 48, null);
						}
						switcher2=!switcher2;
					} else {
						g.drawImage(test.getImage(), a, b, a + 16, b + 16, 0, 16, 16, 32, null);
					}
					switcher=!switcher;
				}
			}

		}
	};
	private TileBase[][] world;// = new Tiles[(int)
	// worldPanel.getSize().getHeight()][(int)
	// worldPanel.getSize().getWidth()];// 2d array of the
	// entire world, saved in "Tiles"
	public static int xSize = 160 * 10, ySize = 160 * 10;// how many tiles in the
																												// entire world?
	private TestTile test = new TestTile();
	private Graphics g = worldPanel.getGraphics();

	public WorldMap() {
		worldPanel.paintComponents(worldPanel.getGraphics());
		worldPanel.setSize(xSize, ySize);
		worldPanel.setName("World Panel");
		worldPanel.setBorder(BorderFactory.createLineBorder(Color.green, -1));
		world = new TileBase[(int) worldPanel.getSize().getHeight() / 16][(int) worldPanel.getSize().getWidth() / 16];
		try {
			getImages();
		} catch (IOException e) {
		}
	}

	// public WorldMap(int tileWide, int tileHieght) {
	// worldPanel.setSize(tileWide * 16, tileHieght * 16);
	// }

	private void getImages() throws IOException {
		BufferedImage bi = new BufferedImage(16, 16, BufferedImage.TYPE_4BYTE_ABGR);
		File f = new File("tiles/jpg.wbmp");
		Graphics2D g;
		bi = ImageIO.read(f);
		if (!f.exists()) {
			f.createNewFile();
		}
		g = bi.createGraphics();
		g.setColor(Color.GREEN);
		g.draw3DRect(1, 1, 10, 10, true);

		// Draw your chart

		ImageIO.write(bi, "jpg", f);
		System.out.println("file writen " + f.exists());
		System.out.println("System out after painting");
	}

	public CPanel getWorld() {
		return worldPanel;
	}

	private void getAllFiles() {

	}

	private void populateTiles() {
		for (int a = 0; a < xSize / 16; a++) {
			for (int b = 0; b < ySize / 16; b++) {
				// world[a][b]=
			}
		}
	}
	public void drawVisible(){
		
	}
}
