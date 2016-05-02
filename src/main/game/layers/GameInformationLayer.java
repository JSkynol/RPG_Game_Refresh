package main.game.layers;

import java.awt.Graphics;

import main.S;


public class GameInformationLayer extends Panel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("GI", S.frame.getWidth()-41, S.frame.getHeight()-70);
	}
}
