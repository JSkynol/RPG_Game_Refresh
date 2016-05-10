package main.entities.NonHostile;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;

import main.entities.Entity;
import main.entities.EntityType;

public class Person extends Entity{

	public Person(String name) {
		super(EntityType.NONHOSTILE);

		setName("Person."+name);

		setIcon(new ImageIcon("imgs/robot.png") );
		setLocation(150,150);
	}

}
