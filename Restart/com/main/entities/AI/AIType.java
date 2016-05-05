package com.main.entities.AI;

import java.util.ArrayList;

public enum AIType {
	FOLLOWPLAYER("Chase", 10), RUNFROMPLAYER("Flee", 10), RANDOM("Random", 0);

	private AIBase ai;
	private RandomMovement RM;
	private ArrayList al = new ArrayList();
	// private FollowMovement(range)
	private int rangeOfDetect = 0;

	AIType(String aitype, int range) {
		rangeOfDetect = range;
		switch (aitype) {
		case "Chase":
			ai = new RandomMovement();
//			al.add(chaseAI);
		case "Flee":
//			al.add(runAI);
		case "Random":
			RM = new RandomMovement();
			al.add(RM);
		}
	}

	public AIBase getAI() {
		ai = (AIBase) al.get(0);
		return ai;
	}

	public void setAI(AIBase a) {
		ai = a;
	}

}
