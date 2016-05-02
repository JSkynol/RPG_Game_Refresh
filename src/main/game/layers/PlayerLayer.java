package main.game.layers;

import java.awt.Graphics;

import main.S;

public class PlayerLayer extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;

	public PlayerLayer() {
	}

	public void customRun() {
	}

	@Override
	public void paintComponent(Graphics g) {
//		System.out.println("Fiddlestix");
		super.paintComponent(g);
		g.drawString("P", S.frame.getWidth()-50, S.frame.getHeight()-70);
	}
}
