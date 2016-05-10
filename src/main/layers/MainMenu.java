package main.layers;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

import main.DataTypes.CPanel;

public class MainMenu extends CPanel {

	MainMenu p;
	Box buttonGroup;
	JButton btn_startGame, btn_Options;
	LayerAndInputHandler IN;

	public MainMenu() {
		// IN = getInputHandler();
	}

	public MainMenu(LayerAndInputHandler in) {
		super(in);
		setInputHandler(in);
		IN = getInputHandler();
		p = this;
	}

	public void createMainMenu() {
		ImageIcon i =new ImageIcon("imgs/splash2.png");
		JLabel splash = new JLabel();

		splash.setIcon(i);
//		add(splash);
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		buttonGroup = new Box(BoxLayout.PAGE_AXIS);
		btn_startGame = new JButton("Start Game");
		btn_startGame.setActionCommand("MainMenuStart");
		btn_startGame.addActionListener(IN);
		btn_startGame.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		btn_Options = new JButton("Options Menu");
		btn_Options.setActionCommand("MainMenuOptions");
		btn_Options.addActionListener(IN);
		btn_Options.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		
		btn_startGame.setSize(btn_Options.getSize());
		 buttonGroup.add(Box.createVerticalGlue());
		buttonGroup.add(btn_startGame);
		buttonGroup.add(btn_Options);
		add(buttonGroup);
		add(splash);
	}

	@Override
	public void CRun() {
		createMainMenu();
	}
	@Override
	public void paintComponents(Graphics g){
		super.paintComponents(g);
		g.drawImage(new ImageIcon("imgs/Menu.png").getImage(), 0, 0, null);
		g.setColor(Color.red);
		g.fillRect(0, 0, 100, 100);
		System.out.println("System: " + g.getColor());
	}

}
