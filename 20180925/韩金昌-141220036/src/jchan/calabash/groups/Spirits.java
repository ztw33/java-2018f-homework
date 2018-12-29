package jchan.calabash.groups;

import jchan.calabash.calabashworld.*;
import jchan.calabash.creatures.Spirit;
import jchan.calabash.creatures.SpiritType;
import jchan.calabash.formation.Changshe;

public class Spirits extends Groups{
    public Spirits(Field field,int n) {
        this.field = field;
        number = 0;
        creatures = new Spirit[n];
        for (int i = 0; i < n; i++) {
            creatures[i] = new Spirit(field.getxMax() - 1, field.getyMax() - 1 - i, Camp.EVIL, field, this, SpiritType.getType(i));
            number++;
        }
        formation = new Changshe(field.getxMax()/2,field.getyMax()/2,field.getzMax()-1,number);
    }
    /*public void sort(){
        formation.sortTeam(creatures);
    }

    public int getNumber() {
        return number;
    }*/
}
