package main.entities.AI;

import main.DataTypes.Direction;

public class RandomMovement implements AIBase {
	private Direction d = new Direction(0,0);
	private int storeForLater;
	private int updateFreq;

	public RandomMovement() {

	}
	public int rngThis(){
		int rnd=(int)(Math.random() * 5);
		System.out.println("rng: " + rnd);
		switch(rnd){
			case 0:return -1;
			case 1:return -1;
			case 2:return 0;
			case 3:return 1;
			case 4:return 1;
			default: return 0;
		}
		
	}

	@Override
	public Direction getDirection() {
//		d.setXDir((int) (Math.random() * 3) - 1);
		int xrnd=(int)(Math.random() * 6),yrnd=(int)(Math.random() * 6);
		switch(xrnd){
			case 0:d.setXDir(-1);break;
			case 1:d.setXDir(-1);break;
			case 2:d.setXDir(0);break;
			case 3:d.setXDir(0);break;
			case 4:d.setXDir(1);break;
			case 5:d.setXDir(1);break;
		}
		
//		d.setYDir((int) ((Math.random() * 3) - 1));
		switch(yrnd){
		case 0:d.setYDir(-1);break;
		case 1:d.setYDir(-1);break;
		case 2:d.setYDir(0);break;
		case 3:d.setYDir(0);break;
		case 4:d.setYDir(1);break;
		case 5:d.setYDir(1);break;
	}
		return d;
	}

	@Override
	public void setDirection(Direction d) {

	}

}
