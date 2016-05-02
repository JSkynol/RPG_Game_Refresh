package main.game.layers;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

import main.S;
import main.game.MainGame;

public class GameLayer extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	MainGame gr;
	Graphics g;
	JFrame f;

	public GameLayer() {
		g = this.getGraphics();
		f = S.frame;
		this.setOpaque(true);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("G", f.getWidth()-70, f.getHeight()-70);
		
	}

	@Override
	public void customRun() {
		this.setBackground(Color.orange);
		/* gr = new MainGame(); gr.run(); // gr.createTimer(); //
		 * gr.startTimer();
		 * 
		 * Thread t = new Thread() { public void run() { while
		 * (!gr.gamePaused()) { }
		 * 
		 * } };
		 * 
		 * t.setName("Game Thread"); t.start(); */

	}
}
