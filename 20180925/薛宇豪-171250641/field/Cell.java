package field;

import creature.Creature;

public class Cell {
    private Position position;
    private Creature creature;
    private boolean ifEmpty;
    public Cell(Position position){
        this.position=position;
        ifEmpty=true;
    }
    public Position getPosition(){
        return position;
    }

    public void setCreature(Creature creature) {
        if(creature!=null && ifEmpty) {
            this.creature = creature;
            ifEmpty=false;
        }else {
            //nothing to do now
        }
    }

    public Creature getCreature(){
        return creature;
    }
    public boolean getIfEmpty(){
        return ifEmpty;
    }
}
