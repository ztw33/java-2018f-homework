package battlefield;

import creatures.*;
import formation.*;
public class Unit<T extends Creature> {
	T creature;
	Position position;
	Unit(Position p){
		position = p;
	}
	public void setCreature(T t) {
		creature = t;
	}
	public T getCreature() {
		return creature;
	}
	public void clearUnit() {
		creature = null;
	}
	public boolean isFilled() {
		if (creature == null) {
			return false;
		}else {
			return true;
		}
	}
}
