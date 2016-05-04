package com.main.layers;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;

import main.S;

import com.main.DataTypes.CPanel;

public class MainMenu extends CPanel {

	MainMenu p;
	Box buttonGroup;
	JButton btn_startGame, btn_Options;
	LayerAndInputHandler IN;

	public MainMenu() {
//		IN = getInputHandler();	
	}

	public MainMenu(LayerAndInputHandler in) {
		super(in);
		setInputHandler(in);
		IN = getInputHandler();
		p = this;
	}

	public void createMainMenu() {
		buttonGroup = new Box(BoxLayout.PAGE_AXIS);
		btn_startGame = new JButton("Start Game");
		btn_startGame.setActionCommand("MainMenuStart");
		btn_startGame.addActionListener(IN);
		btn_startGame.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		btn_Options = new JButton("Options Menu");
		btn_Options.setActionCommand("MainMenuOptions");
		btn_Options.addActionListener(IN);
		btn_Options.setAlignmentX(JComponent.CENTER_ALIGNMENT);

		buttonGroup.add(btn_startGame);
		buttonGroup.add(Box.createHorizontalStrut(500));
		buttonGroup.add(Box.createVerticalBox());
		buttonGroup.add(btn_Options);
		System.out.println("MainMenu butons called "+ IN.toString());
		add(buttonGroup);
	}
	@Override
	public void CRun(){
		createMainMenu();
	}
	

}
