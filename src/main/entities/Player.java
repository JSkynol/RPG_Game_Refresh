package main.entities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;

import main.DataTypes.Direction;

public class Player extends Entity {
	public Player() {
		super(EntityType.PLAYER);
//		setText("Player");
//		setSize(16, 16);
		setLocation(500-(getWidth()/2), 250-(getHeight()/2));
//		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		setBorder(null);
		setIcon(new ImageIcon("imgs/ruby.png") );
		setSize(getIcon().getIconWidth()+4, getIcon().getIconHeight()+4);

	}
	@Override
	public void moveEntityCheck(Direction d) {
		// MoveUpdateFreq++;
		// if(MoveUpdateFreq==getEntityType().getSpeed()){
		// MoveUpdateFreq=0;
		// tempD=d;
		int x = d.getXDir(), y = d.getYDir();
		double currX = getX(), currY = getY();
		if (currX + (x * d.getVelocity()) <= 0 || currX + (x * d.getVelocity()) + getWidth() >= 990
				|| currY + (y * d.getVelocity()) <= 0 || currY + (y * d.getVelocity()) + getHeight() >= 475) {
		} else {
			setLocation((int) (currX + (x * d.getVelocity())), (int) (currY + (y * d.getVelocity())));
		}
	}
}
