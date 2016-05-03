package com.main.layers;

import javax.swing.JButton;

import com.main.DataTypes.CPanel;

public class Game extends CPanel{
	public Game(LayerAndInputHandler in) {
		super(in);
	}

	public void run(){
		JButton button = new JButton("name");
		add(button);
	}
}
