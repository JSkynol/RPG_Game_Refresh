package main.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import main.S;
import main.entities.Entity;
import main.entities.EntityBase;
import main.entities.Mob;
import main.entities.Player;
import main.entities.ai.MovementRandom;
import main.game.layers.Panel;

public class MainGame implements Runnable {
	JFrame f;
	Graphics g;

	Timer timer;
	int gameSpeedLimit = 120;// , currentFrame = 0;
	boolean esc = false, canrun = true;
	Player player;
	Panel GL, EL, PL, PG, GIL;
	BufferedImage playerSprite;
	int leftMove[] = { 37, 65, 100 }, upMove[] = { 38, 86, 104 }, rightMove[] = { 39, 68, 102 }, downMove[] = { 40, 83, 98 };
	// Thread thread;
	JLabel lbl;
	boolean timerRunning = false;
	private ArrayList<Entity> loadedEntities = new ArrayList<Entity>();

	public MainGame() {
		g = S.graphics;
		f = S.frame;
		GL = S.GameLayers.get(S.GameLayer);
		EL = S.GameLayers.get(S.EntityLayer);
		PL = S.GameLayers.get(S.PlayerLayer);
		PG = S.GameLayers.get(S.GamePause);
		GIL = S.GameLayers.get(S.GUIandInformation);
		// S.addFrame(S.GameLayer);
		// S.addFrame(S.EntityLayer);
		// S.addFrame(S.PlayerLayer);
		// S.cl.next(S.mainContainer);

		GL.setBackground(Color.orange);

		// GL.customRun();
		// S.cl.next(S.mainContainer);
		// CardLayout layout = (CardLayout)(S.mainContainer.getLayout());
		// layout.next(S.mainContainer);
		// S.array.get(S.EntityLayer).customRun();
	}

	private void inputHandler(KeyEvent k) {
		// print(k.getID()+ " ");
		if (k.getKeyCode() == 27) {
			System.out.println("Pause");
			PG.customRun();
		}
		if (k.getID() != KeyEvent.KEY_RELEASED) {
			k.setKeyCode(0);
			char c_test = k.getKeyChar();
			// int c = 250 / gameSpeedLimit;
			switch (String.valueOf(c_test)) {
			case "w":
				// player.setY(player.getY() - c);
				player.move(S.MoveUp);
				// lbl.setLocation(lbl.getX(), lbl.getY() - c);
				break;
			case "s":
				// player.setY(player.getY() + c);
				player.move(S.MoveDown);
				// lbl.setLocation(lbl.getX(), lbl.getY() + c);
				break;
			case "a":
				// player.setX(player.getX() - c);
				player.move(S.MoveLeft);
				// lbl.setLocation(lbl.getX() - c, lbl.getY());
				break;
			case "d":
				// player.setX(player.getX() + c);
				player.move(S.MoveRight);
				// lbl.setLocation(lbl.getX() + c, lbl.getY());
				break;
			}

			player.Update(PL.getGraphics());
			// PL.repaint();
			// lbl.setLocation(player.getLocation());
			// PL.repaint();
			// lbl.repaint();
			// lbl.setLocation(player.getLocation());
			// System.out.println("Input: " + lbl.getLocation() + " " +
			// player.getLocation() + " " + PL.getLocation());
		}
	}

	private void createTimer() {
		timer = new Timer(0, null);
		timer.setDelay(1000 / gameSpeedLimit);
		timer.setRepeats(true);
		timer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				gametick();
			}
		});
		startTimer();
	}

	public void startTimer() {
		if (!timerRunning) {
			timer.start();
			timerRunning = true;
		}
	}

	public void stopTimer() {
		if (timerRunning) {
			timer.stop();
			timerRunning = false;
		}
	}

	int EntityUpdtCounter = 0, levelUpdtTick = 0, gameTick = 0;

	private void gametick() {
		gameTick++;

		if (gameTick == gameSpeedLimit / 10) {
			gameTick = 0;
			EntityUpdtCounter++;
			updateEntities();
			// EL.repaint();
			// EL.validate();
			// System.out.println("EL update");
			if (EntityUpdtCounter == gameSpeedLimit / 10) {
				EntityUpdtCounter = 0;
				levelUpdtTick++;
				// GL.repaint();
				// GL.validate();
				// System.out.println("GL update");
			}
//			 PL.repaint();
//			player.Update(PL.getGraphics());
			// PL.validate();
		}

		// TODO Entity Updates
		// TODO player update
		//
	}

	public void pause() {

	}

	public void resume() {
		timer.start();
	}

	@Override
	public void run() {

		S.showGame();
		// p.addKeyListener(this);
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(new KeyEventDispatcher() {
			@Override
			public boolean dispatchKeyEvent(KeyEvent e) {
				inputHandler(e);
				return false;
			}
		});
		createPlayer();
		createEntities();
		createMap();

		System.out.println("All entity classes: " + EntityBase.instances.size());
		for (int x = 0; x < EntityBase.instances.size(); x++) {
			ArrayList<?> ar = EntityBase.instances.get(x);
			System.out.println(" - Classes: " + ar.get(1));
			
		}
		
		
		S.showGame();
		// PL.add(lbl);

		createTimer();

		// player.Update(g);
	}

	public boolean gamePaused() {
		return false;
	}

	private void createPlayer() {
		player = new Player();
		player.prevAndCurrent(null, new Point(100, 100));
		try {
			playerSprite = ImageIO.read(new File("imgs/ruby.png"));
			player.setImage(playerSprite);
		} catch (IOException ex) {
		}
	}

	private void createEntities() {
		Mob evilOne = new Mob("Evil One");
		evilOne.prevAndCurrent(null,new Point(200, 200));
		
		evilOne.setAI(new MovementRandom(evilOne));
		loadedEntities.add(evilOne);
		evilOne.setMove(5);
		Mob SecondaryEvil = new Mob("Name");
		SecondaryEvil.prevAndCurrent(null, new Point(100, 100));
		loadedEntities.add(SecondaryEvil);

	}

	private void createMap() {

	}
	private void updateEntities(){
		for(int count = 0; count<loadedEntities.size();count++){
			Entity temp = loadedEntities.get(count);
			temp.Update(EL.getGraphics());
		}

	}

}
