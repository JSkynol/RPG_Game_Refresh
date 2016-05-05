package com.main.entities;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JLabel;

import com.main.DataTypes.Direction;
import com.main.entities.AI.AIBase;
import com.main.entities.AI.AIType;

public class Entity extends JLabel {
	private String entityName;
	private String entityID;
	private File imageLocation;
	private Image entityImage;
	private EntityType et;
	private int MoveUpdateFreq=0;
	private Direction tempD ;
//	private AIType ai;
	private Color cl = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
	public static ArrayList<Entity> list = new ArrayList<Entity>();

	public Entity() {
		setBackground(cl);
		System.out.println("Color: " + cl);
		set();
	}
	public Entity(EntityType e){
		et=e;
		set();
		setBackground(et.getBG());
	}
	private void set(){
		list.add(this);
		setOpaque(true);
		setName("");
		setSize(16, 16);
		setToolTipText("Entity");
		tempD= new Direction(0,0,getEntityType().getSpeed());
		
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
		if(MoveUpdateFreq==getEntityType().getSpeed()){
			MoveUpdateFreq=0;
			tempD=d;
		int x = d.getXDir(), y = d.getYDir();
		double currX = getX(), currY = getY();
		if (currX + (x * d.getVelocity()) <= 0 || currX + (x * d.getVelocity())+getWidth() >= 990 || currY + (y * d.getVelocity()) <= 0
				|| currY + (y * d.getVelocity())+getHeight() >= 475) {
		} else {
			setLocation((int) (currX + (x * d.getVelocity())), (int) (currY + (y * d.getVelocity())));
		}}
		else{int x = tempD.getXDir(), y = tempD.getYDir();
		double currX = getX(), currY = getY();
		if (currX + (x * tempD.getVelocity()) <= 0 || currX + (x * tempD.getVelocity())+getWidth() >= 990 || currY + (y * tempD.getVelocity()) <= 0
				|| currY + (y * tempD.getVelocity())+getHeight() >= 475) {
		} else {
			setLocation((int) (getX() + (tempD.getXDir() * d.getVelocity())), (int) (getY() + (tempD.getYDir() * d.getVelocity())));
		}
			
		}
	}

	public void setAI(AIType t) {
		et.setAI(t);
		}

	public AIBase getAI() {
		return et.getAI();
	}

}
