package jchan.calabash.creatures;

import jchan.calabash.calabashworld.*;
import jchan.calabash.groups.Groups;

public class CalabashMan extends Creature {
    private CalaType calaType;
    //int range;
    private Groups calabashGourd;
    public CalabashMan(double x, double y, double z, Camp camp, Field field, Groups calabashGourd, CalaType calaType){
        super(x,y,z,camp,field);
        this.calabashGourd = calabashGourd;
        range = this.calabashGourd.getNumber();
        this.calaType = calaType;
    }
    public CalabashMan(double x, double y, Camp camp, Field field, Groups calabashGourd, CalaType calaType){
        this(x,y,0,camp,field,calabashGourd,calaType);
    }
    @Override
    public char whoami(){
        return (char)(range + '0');
    }
}