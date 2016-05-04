package com.main.layers;

import javax.swing.JButton;

import com.main.DataTypes.CPanel;

public class GamePause extends CPanel {
	private JButton resume,MainMenu;
	public GamePause(LayerAndInputHandler in){
		super(in);
		System.out.println("BG of GP: " + this.getBackground());
		resume = new JButton("Resume Game");
		resume.setActionCommand("GamePauseResume");
		resume.addActionListener(in);
		
		MainMenu=new JButton("Return to Main Menu");
		MainMenu.setActionCommand("ReturnToMainMenu");
		MainMenu.addActionListener(in);
		
		add(resume);
		add(MainMenu);
		
		setBounds(0,0,1000,500);
		setVisible(true);
		
	}
}
