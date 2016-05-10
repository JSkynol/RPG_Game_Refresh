package main.layers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import main.GameTick;
import main.DataTypes.CPanel;
import main.DataTypes.Direction;
import main.entities.Entity;
import main.entities.Player;
import main.map.WorldMap;

public class Game extends CPanel {
	private JButton test;
	private Player p;
	private GameTick gt;
	private JLayeredPane gsp;
	private WorldMap world;
	private CPanel EntityPane = new CPanel();
	boolean pM = false;

	public Game(
			LayerAndInputHandler in) {
		super(in);
		world = new WorldMap();
		gsp = new JLayeredPane();
		// add(test);
		// setBounds(0, 0, 1000, 500);
		setVisible(true);
		gt = new GameTick(getInputHandler());
		gt.setup();
		p = gt.getPlayer();

		// p.setBounds(0,0,p.getWidth(),p.getHeight());
		for (int a = 1; a < Entity.list.size(); a++) {
			world.getWorld().add(Entity.list.get(a));
		}
		// gsp.add(EntityPane);
		gsp.add(world.getWorld());
		gsp.add(p);
		p.setVisible(true);
		gsp.setBounds(0, 0, 1000, 500);
		world.getWorld().setBackground(new Color(255, 100, 100, 10));
		// this.add(gsp);
		gsp.setVisible(true);
		gsp.moveToFront(p);
//		this.paint(this.getGraphics());

	}

	@Override
	public void CRun() {
	}

	public GameTick getGameTick() {
		return gt;
	}

	public JLayeredPane getLayerPane() {
		return gsp;
	}

	public Entity getPlayer() {
		return p;
	}

	public CPanel getEntityPanel() {
		return EntityPane;
	}

	public WorldMap getWorld() {
		return world;
	}

	public void moveWorld(Direction d) {

		int x = d.getXDir() * -1, y = d.getYDir() * -1;
		double currX = world.getWorld().getX(), currY = world.getWorld().getY();

		pM = false;
		world.getWorld().setLocation((int) (currX + (x * d.getVelocity())), (int) (currY + (y * d.getVelocity())));
		p.setName(p.getName()+ " " +p.getLocation());

	}

	
	@Override 
	public void paintComponents(Graphics g){
		super.paintComponents(g);
		System.out.println("Called painting");
		try {
			g.drawImage(ImageIO.read(new File("imgs/GameOverlay.png")), 00, 0, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    		System.out.println("Called painting");
    		try {
					g.drawImage(ImageIO.read(new File("imgs/GameOverlay.png")), 00, 0, null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void unused(Direction d) {
		int x = d.getXDir() * -1, y = d.getYDir() * -1;
		double currX = world.getWorld().getX(), currY = world.getWorld().getY();
		int pLocX = p.getLocation().x, pLocY = p.getLocation().y;
		boolean test1 = currX + (x * d.getVelocity()) > 0;
		boolean test2 = currX + (x * d.getVelocity()) + getPlayer().getWidth() >= world.getWorld().getSize().getWidth();
		boolean test3 = currY + (y * d.getVelocity()) > 0;
		boolean test4 = currY + (y * d.getVelocity()) + getPlayer().getHeight() >= world.getWorld().getSize().getHeight();
		boolean test5 = 0 - (currX + (x * d.getVelocity())) < d.getVelocity();
		if (test1) {
			System.out.println("test 1");
			// p.setLocation(p.getLocation().x+(x*-1)*d.getVelocity(),p.getLocation().y);
			pM = true;
			x = 0;
		}
		if (test2) {
			System.out.println("test 2");
			pM = true;
			x = 0;
		}
		if (test3) {
			System.out.println("test 3");
			pM = true;
			y = 0;
		}
		if (test4) {
			System.out.println("test 4");
			pM = true;
			y = 0;
		}
		if (p.getLocation().distance(new Point(480, 240)) < 5) {
			pM = true;
		}
		if (p.getLocation().getX() <= 240) {
			System.out.println("Error");
		}
		if (pM) {
			p.moveEntityCheck(d);
			System.out.println("Location: " + (p.getLocation().distance(new Point(480, 240)) < 5) + " " + pM);
		} else {
			world.getWorld().setLocation((int) (currX + (x * d.getVelocity())), (int) (currY + (y * d.getVelocity())));
		}
		System.out.println("End of move World " + world.getWorld().getLocation() + " " + test1 + " " + test2 + " " + test3 + " " + test4 + " " + test5);
	}

}
