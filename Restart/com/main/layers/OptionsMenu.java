package com.main.layers;

import javax.swing.JButton;

import com.main.DataTypes.CPanel;

public class OptionsMenu extends CPanel {
	private JButton Quit;
	public OptionsMenu(LayerAndInputHandler in){
		super(in);
		System.out.println("BG of GP: " + this.getBackground());
		Quit = new JButton("Return to Menu");
		Quit.setActionCommand("ReturnToMainMenu");
		Quit.addActionListener(in);
		
		
		add(Quit);
		
		setBounds(0,0,1000,500);
		setVisible(true);
		
	}
}
