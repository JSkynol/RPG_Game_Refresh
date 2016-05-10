package main;

import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.Timer;

import main.DataTypes.CPanel;
import main.DataTypes.Direction;
import main.entities.Entity;
import main.entities.Player;
import main.entities.Hostile.Robot;
import main.entities.NonHostile.Person;
import main.layers.LayerAndInputHandler;

public class GameTick {
	private boolean gameRunning = false;
	private LayerAndInputHandler Input;
	private Thread gameTickThread;
	private Player player;
	private Timer t;
	private ArrayList<Entity> EntityList;//= Entity.list;
	private CPanel temp = new CPanel();	

	public GameTick(LayerAndInputHandler in) {
		Input = in;
	}

	private void createTimer() {
		t = new Timer(0, Input);
		t.setActionCommand("Tick");
		t.setDelay(100);
		t.start();
	}

	int tick = 0;
	private boolean flop = false;
	public void tickLoop() {
		tick++;
		flop=!flop;
		// if (tick == 10) {
		// tick = 0;
		for (int a = EntityList.size() - 1; a > 0; a--) {
			Entity temp = EntityList.get(a);
			if (temp.getName().contains("robot")) {
				temp.setText("t " + tick);
			}
			Direction tempD = new Direction(temp.getAI().getDirection(),temp.getEntityType().getSpeed());
			temp.moveEntityCheck(tempD);
			

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
		createTimer();
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(Input);
		createPlayer();
		createEntity();
		EntityList=Entity.list;
	}

	public Player getPlayer() {
		return player;
	}

	public ArrayList<Entity> getEntities() {
		return EntityList;
	}

	private void createPlayer() {
		player = new Player();
	}

	private void createEntity() {
		Robot rbt = new Robot("Alpha");
		//rbt.setName("robotAlpha");
		Person person1 = new Person("K");
	}
	
	
	
private boolean willColide(){
		for(int a=0;a<EntityList.size();a++){
			ArrayList<Entity> temp = EntityList;//.remove(a);
			temp.remove(a);
			for(int b=0;b<temp.size();b++){
				Entity tempA =EntityList.get(a);
				Entity tempB = temp.get(b);
				Point tempAPoint =new Point(),tempBPoint = new Point();
				tempAPoint.setLocation(tempA.getBounds().getCenterX(),tempA.getBounds().getCenterY());
				tempBPoint.setLocation(tempB.getBounds().getCenterX(), tempB.getBounds().getCenterY());
				if(tempAPoint.distance(tempBPoint)<8){
					System.out.println("Colison soon");
				}
				
			}
		}
		
		
		
		return true;
		
	}
	

}
