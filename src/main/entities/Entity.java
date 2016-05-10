package main.entities;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.DataTypes.Direction;
import main.entities.AI.AIBase;
import main.entities.AI.AIType;
import main.map.WorldMap;

public class Entity extends JLabel {
	private String entityName;
	private String entityID;
	private File imageLocation;
	private ImageIcon entityImage;
	private EntityType et;
	private int MoveUpdateFreq = 0;
	private Direction tempD;
	// private AIType ai;
	private Color cl = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
	public static ArrayList<Entity> list = new ArrayList<Entity>();

	public Entity() {
		setBackground(cl);
		System.out.println("Color: " + cl);
		set();
	}

	public Entity(
			EntityType e) {
		et = e;
		set();
		// setBackground(et.getBG());
	}

	private void set() {
		list.add(this);
		setName("");
		setSize(16, 16);
		setToolTipText("Entity");
		setOpaque(false);
		tempD = new Direction(0, 0, getEntityType().getSpeed());

	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getEntityID() {
		return entityID;
	}

	public ImageIcon getEntityImage() {
		return entityImage;
	}

	public void setEntityImage(ImageIcon i) {
		entityImage = i;
	}

	public void setEntityID(String entityID) {
		this.entityID = entityID;
	}

	public EntityType getEntityType() {
		return et;
	}

	public void setEntityType(EntityType et) {
		this.et = et;
	}

	public void moveEntityCheck(Direction d) {
		MoveUpdateFreq++;
		if (MoveUpdateFreq == getEntityType().getSpeed()) {
			// System.out.println("Location of " + getName()+ ": " + getLocation() );
			MoveUpdateFreq = 0;
			tempD = d;
			int x = d.getXDir(), y = d.getYDir();
			double currX = getX(), currY = getY();
			double movement[] = {
					currX + (x * d.getVelocity()), currY + (y * d.getVelocity()) };

			if (movement[0] <= 0) {
				movement[0] = currX;
			}
			if (movement[0] + getWidth() >= WorldMap.xSize) {
				movement[0] = currX;
			}
			if (movement[1] <= 0) {
				movement[1] = currY;
			}
			if (movement[1] + getHeight() >= WorldMap.ySize) {
				movement[1] = currY;
			}
			setLocation((int) movement[0], (int) movement[1]);

		} else {
			int x = tempD.getXDir(), y = tempD.getYDir();
			double currX = getX(), currY = getY();
			double movement[] = {
					currX + (x * tempD.getVelocity()), currY + (y * tempD.getVelocity()) };

			if (movement[0] <= 0) {
				movement[0] = currX;
			}
			if (movement[0] + getWidth() >= WorldMap.xSize) {
				movement[0] = currX;
			}
			if (movement[1] <= 0) {
				movement[1] = currY;
			}
			if (movement[1] + getHeight() >= WorldMap.ySize) {
				movement[1] = currY;
			}
			setLocation((int) movement[0], (int) movement[1]);

		}
	}

	public void setAI(AIType t) {
		et.setAI(t);
	}

	public AIBase getAI() {
		return et.getAI();
	}

}
