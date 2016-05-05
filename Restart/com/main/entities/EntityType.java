package com.main.entities;

import java.awt.Color;

import com.main.entities.AI.AIBase;
import com.main.entities.AI.AIType;

public enum EntityType {
	NONHOSTILE(10, 0, 3, false, Color.cyan, AIType.RANDOM), PLAYER(50, 2.5, 5, false, Color.GREEN, null), HOSTILE(25, 1, 4,
			true, Color.RED, AIType.FOLLOWPLAYER);
	private double Health;
	private double Damage;
	private int Speed = 1;
	private boolean followPlayer;
	private Color bg;
	private AIType AI;

	EntityType(double defaultHealth, double defaultDamage, int defaultSpeed, boolean Follow, Color c, AIType ai) {
		this.Health = defaultHealth;
		this.Damage = defaultDamage;
		this.Speed = defaultSpeed;
		this.followPlayer = Follow;
		this.bg = c;
		this.AI = ai;
	}

	public AIBase getAI() {
		return AI.getAI();
	}

	public Color getBG() {
		System.out.println("Color; " + bg);
		return bg;
	}

	public double getDamge() {
		return Damage;
	}

	public boolean getFollowPlayer() {
		return followPlayer;
	}

	public double getHealth() {
		return Health;
	}

	public int getSpeed() {
		return Speed;
	}

	public void setAI(AIType a) {
		AI = a;
	}

	public void setB(Color c) {
		bg = c;
	}

	public void setDamage(double damage) {
		Damage = damage;
	}

	public void setFollowPlayer(boolean f) {
		followPlayer = f;
	}

	public void setHealth(double health) {
		Health = health;
	}

	public void setSpeed(int v) {
		this.Speed = v;
	}

}
