package space;

import creature.Creature;

public class Position {
	//private int x,y;
	private Creature creature;
	
	public Position(){ creature = null; }

	public void clearCreature(){
		setCreature(null);
	}
	
	public void setCreature(Creature creature) {
		this.creature = creature;
	}

	public Creature getCreature() {
		return creature;
	}
	
	public boolean isEmpty(){
		return creature == null;
	}

    @Override
    public String toString() {
        return String.valueOf(creature.getSymbol());
    }
}
