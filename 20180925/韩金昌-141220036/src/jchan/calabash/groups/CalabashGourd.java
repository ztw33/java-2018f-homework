package jchan.calabash.groups;

import jchan.calabash.calabashworld.*;
import jchan.calabash.creatures.CalaType;
import jchan.calabash.creatures.CalabashMan;
import jchan.calabash.formation.Changshe;

public class CalabashGourd extends Groups{
    public CalabashGourd(Field field) {
        this.field = field;
        number = 0;
        creatures = new CalabashMan[7];
        for (int i = 0; i < 7; i++) {
            creatures[i] = new CalabashMan(0, i, Camp.OLDMAN, field, this, CalaType.getType(i));
            number++;
        }
        formation = new Changshe(field.getxMax()/2,field.getyMax()/2-number,number);
    }
    /*public int getNumber(){
        return number;
    }
    public void sort(){
        formation.sortTeam(creatures);
    }*/
    //void sort()
}
