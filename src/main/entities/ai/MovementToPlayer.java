package main.entities.ai;

import main.entities.Entity;

public class MovementToPlayer implements AIBase{
	private Entity ent;
	public MovementToPlayer(Entity entity) {
		ent = entity;
	}

	@Override
	public int moveDirection() {
		// TODO Auto-generated method stub
		return 0;
	}

}
