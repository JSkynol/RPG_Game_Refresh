package main.entities;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import main.S;
import main.entities.ai.AIBase;

public class EntityBase {

	private String name;
	private Image image;
	private int xLocation, yLocation;
	private Point Location;
	private Point pLoc = new Point(0, 0);
	private int move = 1;
//	private Graphics LayerGraphics = S.GameLayers.get(S.EntityLayer).getGraphics();
	private Graphics graphics;
	private AIBase ai;
	private StackTraceElement ex;
	public static ArrayList<ArrayList<Object>> instances = new ArrayList<ArrayList<Object>>();
	public static ArrayList<EntityBase> EBList = new ArrayList<EntityBase>();

	public EntityBase() {
		EBList.add(this);
		ex = new Exception().getStackTrace()[2];
		ArrayList<Object> s = new ArrayList<Object>();
		s.add(/* new java.lang.ref.WeakReference<EntityBase> */(this));
		s.add(ex);
		instances.add(s);
	}


	/**
	 * Sets the name of the entity
	 * 
	 * @param Name
	 */
	public void setName(String a) {
		this.name = a;
	}

	/**
	 * Sets the image of Entity
	 * 
	 * @param Image
	 */
	public void setImage(Image b) {
		this.image = b;
	}

	/**
	 * Sets the graphics layer of the entity
	 * 
	 * @param Graphics
	 */
	public void setGraphics(Graphics g) {
		graphics = g;
	}
	/**
	 * 
	 * Returns Graphics of the entity
	 * */
	public Graphics getGraphics(){
		return graphics;
	}

	/**
	 * Sets the entity update Move speed
	 * 
	 * @param speed
	 */
	public void setMove(int b) {
		move = b;
	}

	/**
	 * Sets the x Location of Entity
	 * 
	 * @param x
	 */
	private void setX(int x) {
		xLocation = x;
	}

	/**
	 * Sets the y Location of Entity
	 * 
	 * @param setY
	 */
	private void setY(int setY) {
		yLocation = setY;
	}




	/** Returns the image of the Entity */
	public Image getImage() {
		return image;
	}

	/** Return the name of the Entity */
	public String getName() {
		return name;
	}

	/** Gets the x Location of Entity */
	public int getX() {
		return xLocation;
	}

	/** Gets the y Location of Entity */
	public int getY() {
		return yLocation;
	}

	/** Gets the Location of Entity as a point (x,y) */
	public Point getLocation() {
		return new Point(xLocation, yLocation);
	}

	/** Gets the Height of Entity image */
	public int getHight() {
		return image.getHeight(null);
	}

	/** Gets the Width of Entity image */
	public int getWidth() {
		return image.getWidth(null);
	}

	/**
	 * Returns the Image as an Image Icon from file location
	 * 
	 * @param FileLocation
	 */
	public ImageIcon getImageAsIcon(File f) {
		ImageIcon image;
		try {
			image = new ImageIcon(f.getCanonicalPath());
			return image;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Updates the Entity graphics
	 * 
	 * @param Graphics
	 */
	public void Update(Graphics g) {
		if (getAI() != null) {
			move(getAI().moveDirection());
		}
			Point[] p = getLastAndCurr();
			
		if (getImage() == null) {
			
			g.clearRect(p[0].x - 1, p[0].y - 1, 18, 18);
			g.draw3DRect(p[1].x, p[1].y, 16, 16, true);
		} else {
			
			g.clearRect(p[0].x, p[0].y, getImage().getHeight(null), getImage().getWidth(null));
			g.drawImage(getImage(), p[1].x,p[1].y, null);
		}
	}

	/**
	 * Moves the Entity in the direction specified
	 * 
	 * @param m
	 *          - 0 for no movement, 1 to move up, 2 to move left, 3 to move down,
	 *          4 to move right
	 * */
	public void move(int direction) {
		Point pLoc = getLocation();
		if (direction == S.MoveUp) {
			moveUp();
		}
		if (direction == S.MoveRight) {
			moveRight();
		}
		if (direction == S.MoveDown) {
			moveDown();
		}
		if (direction == S.MoveLeft) {
			moveLeft();
		}
		prevAndCurrent(pLoc,getLocation());
	}
	public synchronized void prevAndCurrent(Point last, Point curr){
		if(last!=null){
		pLoc=last;
		}else{pLoc=new Point(-16,-16);}
		Location = curr;
		xLocation=Location.x;
		yLocation=Location.y;
	}
	public synchronized Point[] getLastAndCurr(){
		Point[] p = new Point[2];
		p[0]=pLoc;		
		p[1]=Location;
		return p;
	}

	/** Returns whether or not the entity is on loaded */
	public boolean isLoaded() {
		return true;
	}

	/* public static int Random = 0, ToPlayerAndRandom = 1, ToPlayer = 2;
	 * 
	 * public void addAI(int AIIndex) { switch (AIIndex) { case 0: setAI(new
	 * MovementRandom(this)); case 1: setAI(new MovementRandomAndToPlayer(this));
	 * case 2: setAI(new MovementToPlayer(this)); default: setAI(null); } } */

	public void setAI(AIBase ai) {
		this.ai = ai;
	}

	public AIBase getAI() {
		return this.ai;
	}

	 void moveUp() {
		setY(getY() - move);
	}

	void moveRight() {
		setX(getX() + move);
	}

	void moveDown() {
		setY(getY() + move);
	}

	void moveLeft() {
		setX(getX() - move);

	}

}
