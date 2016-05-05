package com.main.layers;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLayeredPane;

import com.main.GameTick;
import com.main.DataTypes.CPanel;
import com.main.entities.Entity;
import com.main.entities.Player;

public class Game extends CPanel {
	private JButton test;
	private Player p;
	private GameTick gt;
	private JLayeredPane gsp;

	public Game(LayerAndInputHandler in) {
		super(in);
		gsp = new JLayeredPane();
		test = new JButton("Test Button");
		// add(test);
		// setBounds(0, 0, 1000, 500);
		setVisible(true);
		gt = new GameTick(getInputHandler());
		gt.setup();
		p = gt.getPlayer();
		// p.setBounds(0,0,p.getWidth(),p.getHeight());
		for (int a = 1; a < Entity.list.size(); a++) {
			gsp.add(Entity.list.get(a));
		}
		gsp.add(p);
		p.setVisible(true);
		gsp.add(test);
		gsp.setBounds(0, 0, 1000, 500);
		gsp.setBackground(Color.GREEN);
		// this.add(gsp);
		gsp.setVisible(true);
		gsp.moveToFront(p);
		
		
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

}
