package main.entities;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;

import main.S;
import main.entities.ai.AIBase;

public class Entity extends EntityBase {
	/**
	 * 

	public Entity() {

	}

	/**
	 * Creates Entity with a name
	 * 
	 * @param name
	 */
	public Entity(String a) {
		setName(a);
	}

	/**
	 * Creates Entity with a name and an image
	 * 
	 * @param name
	 * @param image
	 */
	public Entity(String a, Image b) {
		setName(a);
		setImage(b);
	}

	/**
	 * Creates Entity and its location
	 * 
	 * @param xLocation
	 * @param yLocation
	 * */
	public Entity(int x, int y) {

		prevAndCurrent(null, new Point(x, y));
	}

	/**
	 * Creates Entity with a name and location
	 * 
	 * @param name
	 * @param xLocation
	 * @param yLocation
	 */
	public Entity(String a, int b, int c) {
		setName(a);
		prevAndCurrent(null, new Point(b, c));
	}

	/**
	 * Creates Entity with a name and location
	 * 
	 * @param name
	 * @param Location
	 */
	public Entity(String a, Point p) {
		setName(a);

		prevAndCurrent(null, p);
	}

	/**
	 * Creates Entity with name and graphics
	 * 
	 * @param Name
	 * @param Graphics
	 */
	public Entity(String a, Graphics g) {
		setName(a);
		setGraphics(g);
	}

	/**
	 * Creates Entity with name, image and graphics
	 * 
	 * @param Name
	 * @param Image
	 * @param Graphics
	 */
	public Entity(String a, Image b, Graphics g) {
		setName(a);
		setImage(b);
		setGraphics(g);
	}

	/**
	 * Creates Entity with location and graphics
	 * 
	 * @param xLocation
	 * @param yLocation
	 * @param Graphics
	 * */
	public Entity(int x, int y, Graphics g) {

		prevAndCurrent(null, new Point(x, y));
		setGraphics(g);
	}

	/**
	 * Creates Entity with location and graphics
	 * 
	 * @param Location
	 * @param Graphics
	 * */
	public Entity(Point p, Graphics g) {

		prevAndCurrent(null, p);
		setGraphics(g);
	}

	/**
	 * Creates Entity with Name, location and graphics
	 * 
	 * @param Name
	 * @param xLocation
	 * @param yLocation
	 * @param Graphics
	 */
	public Entity(String Name, int b, int c, Graphics g) {
		setName(Name);
		prevAndCurrent(null, new Point(b, c));
		setGraphics(g);
	}

	/**
	 * Creates Entity with Name, location and graphics
	 * 
	 * @param Name
	 * @param Location
	 * @param Graphics
	 */
	public Entity(String Name, Point p, Graphics g) {
		setName(Name);

		prevAndCurrent(null, p);
		setGraphics(g);
	}

	/**
	 * Sets the name of the entity
	 * 
	 * @param Name
	 */}
