package battlefield;

import creature.*;

public class Unit {
	public Creature creature;
	public Position position;
	Unit(){
		this.creature = new Creature();
		this.position = new Position();
	}
	public Unit(Creature creature, Position position) {
		this.creature = creature;
		this.position = position;
	}
}
