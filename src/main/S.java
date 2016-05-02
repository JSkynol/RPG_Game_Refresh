package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import main.game.MainGame;
import main.game.layers.EntityLayer;
import main.game.layers.GameInformationLayer;
import main.game.layers.GameLayer;
import main.game.layers.GamePause;
import main.game.layers.Panel;
import main.game.layers.PlayerLayer;
import main.menu.Menu;

public class S {
	public static void main(String[] args) {
		S init = new S();
		init.setupFrameAndPanels();
	}

	public static ArrayList<Panel> GameLayers = new ArrayList<Panel>();
	public static int GameLayer = 0;
	public static int EntityLayer = 1;
	public static int PlayerLayer = 2;
	public static int GUIandInformation = 3;
	public static int GamePause = 4;
	public static String menuPlayButton = "menuPlayButton", menuOptionsButton = "menuOptionsButton";
	public static int MoveUp =1,MoveRight = 2, MoveDown = 3, MoveLeft = 4;
	// private static String gameString = "game", menuString = "menu";
	// Menu,1 Game Layer, 2 Entity Layer, 3 Player Layer, 4 Game Information
	// Layer, 5 Game Pause
	public static Graphics graphics;
	public static JFrame frame;
	private String gameTitle = "Game Title";
	// public static CardLayout cl;
	private static Panel menu;
	private Panel gl, el, pl, gil, gp;

	public S() {
		frame = new JFrame(gameTitle);
		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setBackground(Color.lightGray);
		frame.setResizable(false);

		graphics = frame.getGraphics();
	}

	private void setupFrameAndPanels() {
		// --
		// mainContainer = new JPanel(new CardLayout());
		// mainContainer.setSize(frame.getSize());
		// mainContainer.setLocation(x, y);
		// frame.setLayout(new CardLayout());

		menu = new Menu();

		menu.setSize(frame.getSize());
		gl = new GameLayer();
		gl.setName("Game Layer");
		el = new EntityLayer();
		pl = new PlayerLayer();
		gil = new GameInformationLayer();

		gil.setSize(new Dimension(frame.getSize()));

		gp = new GamePause();
		gp.setSize(new Dimension(frame.getSize()));
		// game = new Panel(new SpringLayout());

		// game.setSize(new Dimension(frame.getSize()));
		// game.setLocation(x, y);
		// --
		// game.add(gl);
		gl.setSize(new Dimension(frame.getSize()));
		// game.add(el);
		el.setSize(new Dimension(frame.getSize()));
		el.setOpaque(false);
		// game.add(pl);
		pl.setSize(new Dimension(frame.getSize()));

		// --
		// array.add(menu);
		GameLayers.add(gl);
		GameLayers.add(el);
		GameLayers.add(pl);
		GameLayers.add(gil);
		GameLayers.add(gp);
		// --

		menu.setOpaque(true);
		showMenu();

		// frame.add(game);
		// frame.add(mainContainer);

		// game.getGraphics().drawString("Game", 30, 50);
		// cl = (CardLayout) (frame.getLayout());
		// cl.show(mainContainer,"menu");

	}

	public static void showMenu() {
		for (int xc = GameLayers.size(); xc < GameLayers.size(); xc++) {
			frame.remove(GameLayers.get(xc));
		}
		frame.add(menu);
		frame.repaint();
		frame.revalidate();
	}

	public static void showGame() {
		frame.remove(menu);
		//System.out.println("Show game " + GameLayerArray.size());
		// int xc;
		for (int xc = 0; xc <= (GameLayers.size() - 1); xc++) {
			frame.add(GameLayers.get(xc));
		}
		frame.repaint();
		frame.revalidate();
	}

	// frame.add(menu);
	// frame.add(array.get(0));

	/**
	 * @deprecated Use showMenu or showGame Adds selected component then
	 *             repaints
	 * 
	 * @param i
	 *            0 Menu,1 Game Layer, 2 Entity Layer, 3 Player Layer, 4 Game
	 *            Information Layer, 5 Game Pause
	 */
	public static void addFrame(int i) {
		frame.add(GameLayers.get(i));
		frame.revalidate();
		frame.repaint();
	}

	/**
	 * Removes all components, adds selected then repaints
	 * 
	 * @param i
	 *            0 Menu,1 Game Layer, 2 Entity Layer, 3 Player Layer, 4 Game
	 *            Information Layer, 5 Game Pause
	 */
	public static void resetAndAddFrame(int i) {
		frame.removeAll();
		frame.add(GameLayers.get(i));
		frame.revalidate();
		frame.repaint();
	}

	/**
	 * Which layer to remove from frame
	 * 
	 * @param i
	 *            0 Menu, 1 Game Layer, 2 Entity Layer, 3 Player Layer, 4 Game
	 *            Information Layer, 5 Game Pause
	 */
	public static void removeFrame(int i) {
		frame.remove(GameLayers.get(i));
		frame.revalidate();
		frame.repaint();
	}

	public static ActionListener al = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand().equals(menuPlayButton)) {
				System.out.println("Play Game Button Clicked");
				// f.remove(p);

				/* S.addFrame(S.GameLayer,S.EntityLayer,S.PlayerLayer);
				 * S.array.get(1).customRun(); */
				// cl.next(mainContainer);
				frame.repaint();

				// S.frame.repaint();
				MainGame gr = new MainGame();
				gr.run();
				// showGame();

				// f.revalidate();
				// f.repaint();

			}
			if (event.getActionCommand().equals(menuOptionsButton)) {
				System.out.println("Options Menu Button Pressed");
			}
		}
	};

	public static void println(String... s) {
		System.out.println(s);
	}
}