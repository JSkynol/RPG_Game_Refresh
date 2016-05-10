package main.layers;

import java.awt.Color;
import java.awt.Component;
import java.awt.KeyEventDispatcher;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JLayeredPane;

import main.DataTypes.Direction;
import main.DataTypes.Event;
import main.entities.Entity;
import main.map.WorldMap;

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
	private WorldMap w_Map;

	// private InputHandler Input;

	public LayerAndInputHandler() {
	}

	public void createSubClasses() {

		Game = new Game(this);
		Game.setName("Game");
		GamePause = new GamePause(this);
		GamePause.setName("GamePause");
		MainMenu = new MainMenu(this);
		MainMenu.setName("MainMenu");
		MainMenu.CRun();
		OptionsMenu = new OptionsMenu(this);
		OptionsMenu.setName("OptionsMenu");
		
		w_Map = Game.getWorld();
		System.out.println("Game width: " + Game.getLayerPane().getHeight()/2 +" " + Game.getLayerPane().getWidth()/2);
//		Game.getPlayer().setLocation(Game.getLayerPane().getHeight()/2, Game.getLayerPane().getWidth()/2);
		
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



	/*
	 * public void moveToFront(Component c){
	 * 
	 * }
	 */


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
			boolean test = ke.getKeyCode() == ke.VK_A || ke.getKeyCode() == ke.VK_S || ke.getKeyCode() == ke.VK_D
					|| ke.getKeyCode() == ke.VK_W;
			if (test&& Game.getLayerPane().isVisible()) {
				if (ke.getID() == 401) {
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
//					Game.getGameTick().getPlayer().moveEntityCheck(d);
					Game.moveWorld(d);
					// TODO moveplayer
					// }
				}
				if (ke.getID() == ke.KEY_RELEASED) {
					KeyCount = 0;
				}

			}
			if (ke.getKeyCode() == 27 && Game.isVisible()) {// Pause Game
				setVis(GamePause);
				Game.getGameTick().setGameRunning(false);
				System.out.println("Pause");
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
					for (int a = 1; a < Entity.list.size(); a++) {
						Game.getLayerPane().moveToFront(Entity.list.get(a));
					}
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
