package main.map;

import java.io.File;

public enum TileTypes {
	EMPTY(0),FLOOR(0), WALL(1), DOOR(2);
	
	//pirvate file location, tile rotation or centre piece, depending on what surrounding
	private File imageFile;
	//PRIVATE tile rotation/centre, possibly as direction?
	//all tiles are 16x16
	TileTypes(int a) {
		
	}
	
	
}
