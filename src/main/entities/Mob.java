package main.entities;


public class Mob extends Entity{
	
	
	public Mob(String name) {
		super("mob_"+name);
	}
	public Mob(String string, int i, int j) {
		super(string,i,j);
	}

}
