package com.main.DataTypes;

import javax.swing.Spring;

public class Direction {
	private byte xDirection, yDirection, ammount = 5;
	
	public Direction(Direction d,int v){
		setXDir(d.getXDir());
		setYDir(d.getYDir());
		setVelocity(v);
	}
	
	public Direction(int xDir, int yDir) {
		setXDir(xDir);
		setYDir(yDir);
	}

	public Direction(int xDir, int yDir, int a) {
		setXDir(xDir);
		setYDir(yDir);
		setVelocity(a);
	}

	public int getXDir() {
		return xDirection;
	}

	public int getYDir() {
		return yDirection;
	}

	public int getVelocity() {
		return ammount;
	}

	public void setXDir(int x) {
		if (x == -1 || x == 0 || x == 1) {
			xDirection = (byte) x;
		} else {
			System.out.println("Error: X is either -1, 0 or 1: " + x);
		}
	}

	public void setYDir(int y) {
		if (y == -1 || y == 0 || y == 1) {
			yDirection = (byte) y;
		} else {
			System.out.println("Error: Y is either -1, 0 or 1: " + y);
		}
	}

	public void setVelocity(int a) {
		ammount = (byte) a;
	}

	public void setXDir(double x) {
		System.out.println("x: " + x);
		int t = (int) x;
		if (x == -1 || x == 0 || x == 1) {
			yDirection = (byte) x;
		} else {
			System.out.println("Error: X is either -1, 0 or 1: " + t);
		}

	}

	public void setYDir(double y) {
		System.out.println("y: " + y);
		int t = (int) y;
		if (y == -1 || y == 0 || y == 1) {
			yDirection = (byte) y;
		} else {
			System.out.println("Error: Y is either -1, 0 or 1: " + t);
		}
	}
	@Override
	public String toString(){
		
		String temp=new String();//= "[x: "+getXDir()+",	y: "+getYDir()+",	Speed: "+getVelocity()+"]";
		temp="Direction[X: ";
		switch(getXDir()){
		case -1:temp+="down";break;
		case 0: temp+= "null";break;
		case 1: temp+="up  ";break;
		}
		temp+=", Y: ";
		switch(getYDir()){
		case -1:temp+="right";break;
		case 0:temp+="null ";break;
		case 1: temp+="left ";break;
		}
		temp+=",Speed: " + getVelocity()+"]";
		
		return temp;
	}

}
