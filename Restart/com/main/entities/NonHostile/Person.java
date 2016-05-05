package com.main.entities.NonHostile;

import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;

import com.main.entities.Entity;
import com.main.entities.EntityType;

public class Person extends Entity{

	public Person(String name) {
		super(EntityType.NONHOSTILE);

		setName("Person."+name);
		setText(name);
		
		setLocation(150,150);
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
	}

}
