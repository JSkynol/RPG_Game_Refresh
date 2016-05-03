package com.main.layers;

import javax.swing.JButton;

import com.main.GameTick;
import com.main.DataTypes.CPanel;

public class Game extends CPanel{
	private JButton test;
	public Game(LayerAndInputHandler in) {
		super(in);
		test = new JButton("name");
		add(test);
		setBounds(0,0,1000,500);
		setVisible(true);
		GameTick gt = new GameTick(this.getInputHandler());
		gt.setup();
	}
	@Override
	public void CRun(){
		setup();
	}
	private void setup(){
	}
}
