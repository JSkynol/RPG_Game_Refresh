package com.main.entities.Hostile;

import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;

import com.main.entities.Entity;
import com.main.entities.EntityType;
import com.main.entities.AI.AIType;

public class Robot extends Entity{

	public Robot(String name) {
		super(EntityType.HOSTILE);
		setText("Robot");
		setName("Robot_"+name);
		setSize(40, 16);
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
	}

}
