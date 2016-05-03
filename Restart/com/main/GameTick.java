package com.main;

import java.awt.EventQueue;
import java.awt.KeyboardFocusManager;

import com.main.layers.LayerAndInputHandler;

public class GameTick {
	private boolean gameRunning = false;
	private LayerAndInputHandler Input;
	private Thread gameTickThread;

	public GameTick(LayerAndInputHandler in) {
		Input = in;
	}

	private void tickLoop() {
		while (gameRunning) {

		}

	}

	public boolean isGameRunning() {
		return gameRunning;
	}

	public void setGameRunning(boolean f) {
		gameRunning = f;
	}
	/** creates thread for game tick and adds keyboard manager to game */
	public void setup() {
		gameTickThread = new Thread() {
	    public void run() {
	       tickLoop();
	    }  
	};

	gameTickThread.start();
		KeyboardFocusManager manager = KeyboardFocusManager
				.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(Input);
	}

}
