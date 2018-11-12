package homework3.position;

import homework3.creature.Creature;

/** A type represents a fix point in Cartesian coordinates*/
public class Position {
    private final int x, y;
    private Creature creature = null;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Creature getCreature(){
        return creature;
    }

    public void setCreature(Creature creature){
        this.creature = creature;

        if(creature!=null && creature.getPosition() != this){
            creature.setPosition(this);
        }

    }

    public void clear(){
        this.creature = null;
    }

    public String toString(){
        if(creature == null)
            return "**";
        return creature.toString();
    }
}
