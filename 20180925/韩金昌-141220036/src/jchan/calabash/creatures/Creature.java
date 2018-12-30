package jchan.calabash.creatures;

import jchan.calabash.calabashworld.*;

public abstract class Creature extends Thing {
    protected int range = 0;
    private Camp camp;
    Creature(double x,double y,Camp camp,Field field){
        this(x,y,0,camp,field);
    }
    Creature(double x,double y,double z,Camp camp,Field field){
        super(x,y,z,field);
        this.camp = camp;
    }
    protected boolean movesth(Thing sth,double x,double y){
        return movesth(sth,x,y,0);
    }
    protected boolean movesth(Thing sth,double x,double y,double z){
        return sth.move(x,y,z);
    }
    public Camp getCamp(){
        return this.camp;
    }
    private void exchangeCamp(Camp camp){
        this.camp = camp;
    }

    public int getRange() {
        return range;
    }
}
