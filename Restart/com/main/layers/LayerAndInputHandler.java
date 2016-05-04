package com.main.layers;

import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

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
	private boolean keypress;
	private KeyEvent key;
	private int KeyCount;

	// private InputHandler Input;

	public LayerAndInputHandler() {
	}

	public void createSubClasses() {

		Game = new Game(this);
		Game.setName("Game");
		GamePause = new GamePause(this);
		GamePause.setName("GamePause");
		MainMenu = new MainMenu(this);
		// MainMenu.crea
		MainMenu.setName("MainMenu");
		MainMenu.CRun();
		OptionsMenu = new OptionsMenu(this);
		OptionsMenu.setName("OptionsMenu");
//		OptionsMenu.setInputHandler(this);

		add(Game);
		add(GamePause);
		add(OptionsMenu);
		add(MainMenu);

		for (int a = 0; a < getComponents().length; a++) {
			getComponents()[a].setBackground(Color.gray);
			getComponents()[a].setVisible(true);
		}
 
		setVis(MainMenu);
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
			boolean test = ke.getKeyCode() == ke.VK_A
					|| ke.getKeyCode() == ke.VK_S || ke.getKeyCode() == ke.VK_D
					|| ke.getKeyCode() == ke.VK_W;
			if (test) {
				if (ke.getID() == ke.KEY_RELEASED) {
					KeyCount = 0;
				}
				if (ke.getID() == ke.KEY_TYPED || ke.getID() == ke.KEY_PRESSED) {
					KeyCount++;
				}
				if (KeyCount == 10) {
					KeyCount = 0;
					//TODO moveplayer
				}
			}
			// System.out.println(" - Key:		 " + ke);
			if (ke.getKeyCode() == 27 && Game.isVisible()) {
				setVis(GamePause);
			}

		}
		if (ae != null) {
			System.out.println(" - Action: 	 " + ae);
			if (ae.getActionCommand().contains("Start")||ae.getActionCommand().contains("Resume")) {
				setVis(Game);
//				Game.CRun();

			}
			if (ae.getActionCommand().contains("Options")) {
				moveToFront(OptionsMenu);
				setVis(OptionsMenu);
			}
			if (ae.getActionCommand().contains("ReturnToMainMenu")) {
				setVis(MainMenu);
			}
		}

		for (int a = 0; a < getComponents().length; a++) {
			// System.out.println("List of Components	" + getComponents()[a]);
		}
		ae=null;

	}

	private void setVis(CPanel cp) {
		for (int a = 0; a < this.getComponents().length; a++) {

			getComponents()[a].setVisible(false);
		}
		cp.setVisible(true);
		moveToFront(cp);
	}
}
