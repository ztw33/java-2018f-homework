package battlefield;

import spritecontroller.Creature;

public class Tile {
	boolean isOccupied = false;
	Tile() {
		
	}
	void stood(Creature onePerson) {
		isOccupied = true;
	}
	void leave() {
		isOccupied = false;
	}
}
