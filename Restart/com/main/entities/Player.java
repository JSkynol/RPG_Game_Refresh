package com.main.entities;

import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;

import com.main.DataTypes.Direction;

public class Player extends Entity {
	public Player() {
		super(EntityType.PLAYER);
		setText("Player");
		setSize(40, 16);
		setLocation(100,100);
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
	
		
	}
}
