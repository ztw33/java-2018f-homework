package Formations;

import Creatures.*;

public class Position {
    //MARK:Properties;
    Creature creature;
    int pos_x;  int pos_y;
    boolean isEmpty;

    //MARK:initialize;
    public Position(int x,int y){
        this.pos_x = x;
        this.pos_y = y;
        creature = new Blank();
        isEmpty = true;
    }

    //MARK:function
    public boolean isEmpty(){
        return isEmpty;
    }

    public Creature getCreature(){
        return creature;
    }

    public boolean setCreature(Creature newCreature){
        if(creature.isAlive())
            return false;
        creature = newCreature;
        isEmpty = false;
        newCreature.setPosition(pos_x,pos_y);
        return true;
    }

    public void reSetCreature(){
        if(!creature.isBlank()) {
            creature.setPosition(0,0);
            creature = new Blank();
            isEmpty = true;
        }
    }

    public boolean getCreatureCamp(){
        return this.creature.isFriend();
    }
}
