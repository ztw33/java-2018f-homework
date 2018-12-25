package jchan.calabash.formation;

import jchan.calabash.creatures.Creature;

public class Fangyuan extends Formation {
    private int x;
    private int y;
    private int z;
    public Fangyuan(int x,int y,int z,int number){
        super(x,y,z,number);
    }
    public Fangyuan(int x,int y,int number){
        this(x,y,0,number);
    }
    @Override
    public void sort(Creature[] creatures, int i){
        int width = (int)Math.ceil((double)n / 4);
        switch(i % 4){
            case 0:
            {
                x = x0 - i / 4;
                y = y0 - width + i / 4;
                break;
            }
            case 1:
            {
                x = x0 - width + i / 4;
                y = y0 + i / 4;
                break;
            }
            case 2:
            {
                x = x0 + i / 4;
                y = y0 + width - i / 4;
                break;
            }
            case 3:
            {
                x = x0 + width - i / 4;
                y = y0 - i / 4;
                break;
            }
        }
        z = z0;
        creatures[i].exchange(x,y,z);
    }
}
