package jchan.calabash.formation;

import jchan.calabash.creatures.Creature;

public abstract class Formation {
    protected int x0;
    protected int y0;
    protected int z0;
    protected int n;
    Formation(int x, int y, int z, int number){
        x0 = x;
        y0 = y;
        z0 = z;
        n = number;
    }
    public void sortTeam(Creature[] creatures){
        for(int i = 0;i < n;i++){
            sort(creatures,i);
        }
    }
    public abstract void sort(Creature[] creatures,int i);
}
