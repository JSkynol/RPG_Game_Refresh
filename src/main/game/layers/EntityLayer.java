package main.game.layers;

import java.awt.Graphics;

import main.S;

public class EntityLayer extends Panel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;

	public EntityLayer() {
		this.setOpaque(false);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("E", S.frame.getWidth()-60, S.frame.getHeight()-70);
	}
}
