package jchan.calabash.formation;

import jchan.calabash.creatures.Creature;

public class Yulin extends Formation {
    private int x;
    private int y;
    private int z;
    public Yulin(int x,int y,int z,int number){
        super(x,y,z,number);
    }
    public Yulin(int x,int y,int number){
        this(x,y,0,number);
    }
    @Override
    public void sort(Creature[] creatures, int i) {
        if(creatures[i].getRange() == creatures.length - 1){
            x = x0;
            y = creatures[i - 1].getLocationy() + 1;
            z = z0;
            creatures[i].exchange(x,y,z);
        }
        else if (creatures[i].getRange() == 0) {
            x = x0;
            y = y0;
            z = z0;
            creatures[i].exchange(x, y, z);
        } else if (Math.sqrt(creatures[i - 1].getRange() + 1) == (int) Math.sqrt(creatures[i - 1].getRange() + 1)) {
            x = 2 * x0 - creatures[i - 1].getLocationx() + 1;
            y = creatures[i - 1].getLocationy() + 1;
            z = z0;
            creatures[i].exchange(x, y, z);
        } else {
            x = creatures[i - 1].getLocationx() - 1;
            y = creatures[i - 1].getLocationy();
            z = z0;
            creatures[i].exchange(x,y,z);
        }
    }
}
