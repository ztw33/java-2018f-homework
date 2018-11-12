package jchan.calabash.creatures;

import jchan.calabash.groups.Groups;
import jchan.calabash.calabashworld.*;

public class Spirit extends Creature {
    private SpiritType spiritType;
    private Groups spirits;
    public Spirit(double x, double y, double z, Camp camp, Field field, Groups spirits, SpiritType spiritType){
        super(x,y,z,camp,field);
        this.spiritType = spiritType;
        this.spirits = spirits;
        range = this.spirits.getNumber();
    }
    public Spirit(double x, double y, Camp camp, Field field, Groups spirits, SpiritType spiritType){
        this(x,y,0,camp,field,spirits,spiritType);
    }
    @Override
    public char whoami(){
        if(spiritType == SpiritType.SCORPION)
            return 'Y';
        else
            return 'z';
    }
}