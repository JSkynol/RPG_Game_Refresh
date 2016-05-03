package com.main.entities;

import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;

public class Entity extends Rectangle{
	private String entityName;
	private String entityID;
	private File imageLocation;
	private Image entityImage;

	public Entity() {

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

}
