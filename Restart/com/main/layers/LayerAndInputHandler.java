package com.main.layers;

import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JLayeredPane;

import com.main.DataTypes.CPanel;
import com.main.DataTypes.Event;

public class LayerAndInputHandler extends JLayeredPane implements
		ActionListener, KeyEventDispatcher {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean[] moveDirection;
	private Event event;
	private KeyEvent ke;
	private ActionEvent ae;
	private String Name;
	private byte ID;
	// private JLayeredPane Game;
	private CPanel Game, GamePause, MainMenu, OptionsMenu;
	private LayerAndInputHandler input;

	// private InputHandler Input;

	public LayerAndInputHandler() {
	}

	public void createSubClasses() {

		Game = new Game(this);
		Game.setName("Game");
		Game.setInputHandler(this);
		GamePause = new GamePause();
		GamePause.setName("GamePause");
		GamePause.setInputHandler(this);
		MainMenu = new MainMenu();
		// MainMenu.crea
		MainMenu.setName("MainMenu");
		MainMenu.setInputHandler(input);
		MainMenu.CRun();
		OptionsMenu = new OptionsMenu();
		OptionsMenu.setName("OptionsMenu");
		OptionsMenu.setInputHandler(this);
		
		for (int a = 0; a < getComponents().length; a++) {

			getComponents()[a].setBackground(Color.gray);
		}

		add(Game);
		add(GamePause);
		add(OptionsMenu);
		add(MainMenu);
	}

	public void setHandler(LayerAndInputHandler in) {
		input = in;
	}

	public void run() {

	}

	public void update() {

	}

	/*
	 * public void moveToFront(Component c){
	 * 
	 * }
	 */

	public CPanel Game() {
		return Game;
	}

	public CPanel GamePause() {
		return GamePause;
	}

	public CPanel MainMenu() {
		return MainMenu;

	}

	public CPanel OptionsMenu() {
		return OptionsMenu;
	}

	/*
	 * public JPanel getLayerClass() { return this; }
	 */
	/*
	 * private void setInputHandler() { Input = new InputHandler();
	 * 
	 * }
	 * 
	 * public Event getEvent() { return Input.getEvent(); }
	 */
	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		ke = e;
		actions();
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ae = e;
		actions();
	}

	public Event getEvent() {
		event = new Event(ke, ae);
		return event;
	}

	private void actions() {
		if (ke != null) {
			System.out.println(" - Key:		 " + ke);
			if(ke.getKeyCode()==27){
				System.out.println("Pause");
				setVis(GamePause);
			}

		}
		if (ae != null) {
			System.out.println(" - Action: 	 " + ae);
			if (ae.getActionCommand().contains("Start")) {
				System.out.println("GameStart");
				setVis(Game);
				Game.CRun();

			}
			if (ae.getActionCommand().contains("Options")) {
				System.out.println("OptionsMenu");
				moveToFront(OptionsMenu);
				setVis(OptionsMenu);
			}
			if (ae.getActionCommand().contains("Quit")) {
				System.out.println("MainMenu");
				setVis(MainMenu);
			}
		}

		for (int a = 0; a < getComponents().length; a++) {
			System.out.println("List of Components	" + getComponents()[a]);
		}

	}

	private void setVis(CPanel cp) {
		for (int a = 0; a < this.getComponents().length; a++) {

			getComponents()[a].setVisible(false);
		}
		cp.setVisible(true);
		moveToFront(cp);
	}
}
