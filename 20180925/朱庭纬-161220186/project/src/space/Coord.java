package space;

import creature.Creature;

public class Coord<T extends Creature> {

	private boolean existCreature;
	private T creatureInCoord;
	
	public boolean setCreature(T creature) {
		if (existCreature) {
			return false;
		} else {
			existCreature = true;
			creatureInCoord = creature;
			return true;
		}		
	}
	
	public void clearCreature() {
		existCreature = false;
	}
	
	public boolean existCreature() { return existCreature; }
	
	@Override
	public String toString() {
		return creatureInCoord.toString();
	}

	public T getCreatrue() {
		return creatureInCoord;
	}
}
