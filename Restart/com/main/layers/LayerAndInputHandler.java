package com.main.layers;

import java.awt.Color;
import java.awt.Component;
import java.awt.KeyEventDispatcher;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JLayeredPane;

import com.main.DataTypes.CPanel;
import com.main.DataTypes.Direction;
import com.main.DataTypes.Event;
import com.main.entities.Player;

public class LayerAndInputHandler extends JLayeredPane implements ActionListener, KeyEventDispatcher {

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
	private Game Game;
	private GamePause GamePause;
	private MainMenu MainMenu;
	private OptionsMenu OptionsMenu;
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
		// OptionsMenu.setInputHandler(this);

		add(Game.getLayerPane());
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

	public JLayeredPane Game() {
		return Game.getLayerPane();
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
//		 System.out.println("Actions: "+ KeyCount + " " + ke + " " + ae);
		if (ke != null) {
			boolean test = ke.getKeyCode() == ke.VK_A || ke.getKeyCode() == ke.VK_S || ke.getKeyCode() == ke.VK_D
					|| ke.getKeyCode() == ke.VK_W;
			if (test) {

				// if(ke.getID()==ke.KEY_PRESSED){
				// KeyCount=24;
				// }
				// System.out.println("Test 2: " + ke.getID() + " 401");
				if (ke.getID() == 401) {
					// System.out.println("Typed" + KeyCount);
					KeyCount++;
					// if (KeyCount==5) {
					// KeyCount = 0;
					Direction d = new Direction(0, 0,Game.getGameTick().getPlayer().getEntityType().getSpeed());
					if (ke.getKeyCode() == ke.VK_A) {
						d.setXDir(-1);
					}
					if (ke.getKeyCode() == ke.VK_D) {
						d.setXDir(1);
					}
					if (ke.getKeyCode() == ke.VK_S) {
						d.setYDir(1);
					}
					if (ke.getKeyCode() == ke.VK_W) {
						d.setYDir(-1);
					}
					Game.getGameTick().getPlayer().moveEntityCheck(d);
					// TODO moveplayer
					// }
				}
				if (ke.getID() == ke.KEY_RELEASED) {
					KeyCount = 0;
				}

			}
			// System.out.println(" - Key:		 " + ke);
			if (ke.getKeyCode() == 27 && Game.isVisible()) {// Pause Game
				setVis(GamePause);
				Game.getGameTick().setGameRunning(false);
			}

		}
		if (ae != null) {
//			System.out.println("ae: "  + ae);
			if (ae.getActionCommand().contains("Start") || ae.getActionCommand().contains("Resume")) {
				setVis(Game.getLayerPane());
				Game.getGameTick().setGameRunning(true);
				// Game.CRun();

			}
			if (ae.getActionCommand().contains("Options")) {
				moveToFront(OptionsMenu);
				setVis(OptionsMenu);
			}
			if (ae.getActionCommand().contains("ReturnToMainMenu")) {
				setVis(MainMenu);
			
			}
			int error=0;
			try {
				if (ae.getActionCommand() == "Tick" && Game.getGameTick().isGameRunning()&&error!=1) {
					Game.getGameTick().tickLoop();
					Game.getLayerPane().moveToFront(Game.getPlayer());
				}
			} catch (Exception e) {
				System.out.println("errored");
				Game.getGameTick().setGameRunning(false);
				e.printStackTrace();
				error = 1;

			}
		}
		

		for (int a = 0; a < getComponents().length; a++) {
			// System.out.println("List of Components	" + getComponents()[a]);
		}
		ae = null;
		ke=null;

	}

	private void setVis(Component cp) {
		for (int a = 0; a < this.getComponents().length; a++) {

			getComponents()[a].setVisible(false);
		}
		cp.setVisible(true);
		moveToFront(cp);
	}
	
	
	
}
