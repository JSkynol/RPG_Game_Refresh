package main.entities.ai;

import java.awt.Point;

import main.S;
import main.entities.Entity;
import main.entities.EntityBase;

public class MovementRandom implements AIBase {
	private int tick = 0;
	private int move = 0;
	private Entity ent;

	public MovementRandom(Entity e) {
		ent = e;
	}

	public void start() {

	}

	@Override
	public int moveDirection() {
		tick++;
		int rnd;
		if ((int) Math.random() == 1) {
			tick = 5;
		}
		if (tick == 10) {
			tick = 0;
			rnd = (int) (Math.random() * 4) + 1;
			move = rnd;
		} else {
			rnd = move;
		}
		if (ent.getLocation().getX() == 0) {
			tick = 9;
			if (rnd == 4) {
				rnd = 0;
			}
		}
		if (ent.getLocation().getX() == S.frame.getWidth() - 16) {
			tick = 9;
			if (rnd == 2) {
				rnd = 0;
			}
		}
		if (ent.getLocation().getY() == 0) {
			tick = 9;
			if (rnd == 1) {
				rnd = 0;
			}
		}
		if (ent.getLocation().getX() == S.frame.getHeight() - 16) {
			tick = 9;
			if (rnd == 3) {
				rnd = 0;
			}
		}
		return rnd;
	}

	private ColideType[] colide(Point p) {
		ColideType[] s = new ColideType[EntityBase.EBList.size()];

		for (int x = 0; x < EntityBase.EBList.size(); x++) {
			EntityBase eb = EntityBase.EBList.get(x);
			if (p.distance(eb.getLocation()) < 5) {
				s[x] = new ColideType(true,ent.getName(),ent.getLocation().toString(),null);
				// s[3]=//the side closest to hitting
			} else {
				s[x]=new ColideType(false,null,null,null);
			}

		}
		return s;
	}
	
}class ColideType{
	private boolean willColide;
	private String NameOfEnt,LocationOfEnt,SideClosestToEnt;
	public ColideType(boolean b, String name,String Location, String SideClosest){
		willColide=b;
		NameOfEnt=name;
		LocationOfEnt= Location;
		SideClosestToEnt=SideClosest;
		
		
	}
	/**
	 * @return the willColide
	 */
	public boolean isWillColide() {
		return willColide;
	}
	/**
	 * @param willColide the willColide to set
	 */
	public void setWillColide(boolean willColide) {
		this.willColide = willColide;
	}
	/**
	 * @return the nameOfEnt
	 */
	public String getNameOfEnt() {
		return NameOfEnt;
	}
	/**
	 * @param nameOfEnt the nameOfEnt to set
	 */
	public void setNameOfEnt(String nameOfEnt) {
		NameOfEnt = nameOfEnt;
	}
	/**
	 * @return the locationOfEnt
	 */
	public String getLocationOfEnt() {
		return LocationOfEnt;
	}
	/**
	 * @param locationOfEnt the locationOfEnt to set
	 */
	public void setLocationOfEnt(String locationOfEnt) {
		LocationOfEnt = locationOfEnt;
	}
	/**
	 * @return the sideClosestToEnt
	 */
	public String getSideClosestToEnt() {
		return SideClosestToEnt;
	}
	/**
	 * @param sideClosestToEnt the sideClosestToEnt to set
	 */
	public void setSideClosestToEnt(String sideClosestToEnt) {
		SideClosestToEnt = sideClosestToEnt;
	}
	
}
