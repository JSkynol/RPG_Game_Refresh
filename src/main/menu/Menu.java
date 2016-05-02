package main.menu;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;

import main.S;
import main.game.layers.Panel;

public class Menu extends Panel {
	private static final long serialVersionUID = 1L;
//	private JFrame f;
	Panel p;
	Box buttonGroup;
	JButton btn_startGame, btn_Options;

	public Menu() {
		p = this;
//		f = S.frame;
		createMainMenu();
	}


	private void createMainMenu() {
		buttonGroup = new Box(BoxLayout.PAGE_AXIS);
		btn_startGame = new JButton("Start Game");
		btn_startGame.setActionCommand(S.menuPlayButton);
		btn_startGame.addActionListener(S.al);
		btn_startGame.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		btn_Options = new JButton("Options Menu");
		btn_Options.setActionCommand(S.menuOptionsButton);
		btn_Options.addActionListener(S.al);
		btn_Options.setAlignmentX(JComponent.CENTER_ALIGNMENT);

		buttonGroup.add(btn_startGame);
		buttonGroup.add(Box.createHorizontalStrut(500));
		buttonGroup.add(Box.createVerticalBox());
		buttonGroup.add(btn_Options);
		p.add(buttonGroup);
	}

}
