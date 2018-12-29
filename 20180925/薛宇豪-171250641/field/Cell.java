package field;

import creature.Creature;

public class Cell<T extends Creature> {
    private Position position;
    private T creature;
    private boolean ifEmpty;
    public Cell(Position position){
        this.position=position;
        ifEmpty=true;
    }
    public Position getPosition(){
        return position;
    }

    public void setCreature(T creature) {
        if(creature!=null && ifEmpty) {
            this.creature = creature;
            ifEmpty=false;
        }else {
            //nothing to do now
        }
    }

    public void recoverNull(){
        creature=null;
        ifEmpty=true;
    }

    public T getCreature(){
        return creature;
    }
    public boolean getIfEmpty(){
        return ifEmpty;
    }
}
