package jchan.calabash.creatures;

import jchan.calabash.calabashworld.*;

public class Snake extends Creature implements Cheerable{
    public Snake(double x,double y,double z,Field field){
    super(x,y,z,Camp.EVIL,field);
    }
    public Snake(double x,double y,Field field){
        this(x,y,0,field);
    }
    @Override
    public char whoami(){
        return 'S';
    }
    @Override
    public void cheer(){
        System.out.println("Fight for freedom!");
    }
}
