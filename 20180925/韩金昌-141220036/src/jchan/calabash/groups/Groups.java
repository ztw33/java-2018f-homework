package jchan.calabash.groups;

import jchan.calabash.calabashworld.Field;
import jchan.calabash.creatures.Creature;
import jchan.calabash.formation.Formation;

public abstract class Groups implements Sortable {
    protected Field field;
    protected int number;
    protected Formation formation;
    protected Creature[] creatures;
    public void sort(){
        formation.sortTeam(creatures);
    }
    public void setformation(Formation formation){
        this.formation = formation;
    }
    public int getNumber() {
        return number;
    }
}
