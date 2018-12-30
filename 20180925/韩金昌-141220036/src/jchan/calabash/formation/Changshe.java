package jchan.calabash.formation;

import jchan.calabash.creatures.Creature;

public class Changshe extends Formation {

    private int x;
    private int y;
    private int z;
    public Changshe(int x,int y,int z,int number){
        super(x,y,z,number);
    }
    public Changshe(int x,int y,int number){
        this(x,y,0,number);
    }
    @Override
    public void sort(Creature[] creatures, int i){
        x = x0;
        y = y0 + creatures[i].getRange();
        z = z0;
        creatures[i].exchange(x,y,z);
    }
}
