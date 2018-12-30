package battlefield;
import creature.Creature;

public class Position {
	Creature creature;
	public Position() {
		creature=null;
	}
	public void clearCreature() {
		setCreature(null);
	}
	public boolean isEmpty() {
		return creature == null;
	}
	public void setCreature(Creature creature) {
		this.creature = creature;
	}

	public Creature getCreature() {
		return creature;
	}

}
