package homework3.creature;

import homework3.position.Position;

public abstract class Creature {
    private Position position;
    String name;

    public Creature(){
        position = null;
        name = null;
    }


    public Position getPosition(){
        return position;
    }

    public void setPosition(Position position) {
        if (this.position != null) {
            this.position.clear();
        }
        this.position = position;
        if(position!=null && position.getCreature()!=this){
            position.setCreature(this);
        }
    }

    public String toString(){
        return name;
    }
}
