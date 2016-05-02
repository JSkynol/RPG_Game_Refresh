package main.game.layers;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Panel extends JPanel {
	private static final long serialVersionUID = 0;

	public Panel() {
		this.setLocation(0, 0);
		this.setOpaque(false);
		// System.out.println("Panel: "+ new
		// Exception().getStackTrace()[1].getClassName() +" " +
		// this.getLocation());
		// count++;
	}

	public void customRun() {
		// TODO Auto-generated method stub

	}

	public void paintComponent(Graphics g) {

	}

}
