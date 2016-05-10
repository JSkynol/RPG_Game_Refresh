package main.entities.Hostile;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;

import main.entities.Entity;
import main.entities.EntityType;

public class Robot extends Entity{

	public Robot(String name) {
		super(EntityType.HOSTILE);
		setName("Robot_"+name);

		setIcon(new ImageIcon("imgs/flyingRobot.png") );
	}

}
