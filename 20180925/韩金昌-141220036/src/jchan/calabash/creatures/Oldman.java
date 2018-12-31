package jchan.calabash.creatures;

import jchan.calabash.calabashworld.*;

public class Oldman extends Creature implements Cheerable{
    public Oldman(double x,double y,double z,Field field){
        super(x,y,z,Camp.OLDMAN,field);
    }
    public Oldman(double x,double y,Field field){
        this(x,y,0,field);
    }
    @Override
    public char whoami(){
        return '*';
    }
    @Override
    public void cheer(){
        System.out.println("Kill the evil spirits!");
    }
}
