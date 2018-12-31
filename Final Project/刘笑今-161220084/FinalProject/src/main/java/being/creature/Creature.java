package being.creature;

import being.Being;
import output.Output;
import position.Position;
import configurations.Configuration;

public abstract class Creature extends Being{
    private int health;
    private int attackrate;
    private int range;

    public Creature(Position position, String name, char identifier, boolean faction, int health, int attackrate, int range){
        super(position, name, identifier, faction);
        this.health=health;
        this.attackrate=attackrate;
        this.range=range;
    }

    public int getAttackrate() {
        return attackrate;
    }
    public int getHealth() {
        return health;
    }
    private void setHealth(int health){
        this.health=health;
    }
    private void setAttackrate(int attackrate){
        this.attackrate=attackrate;
    }
    public int getRange(){
        return range;
    }

    public void reduceHealth(int value, String sourcename){
        if(value>health)
            value=health;
        setHealth(health-value);
        Output.outputInformation(getName()+" has been attacked by "+sourcename+", current hp is "+health);
    }

    public void increaseHealth(int value, String sourcename){
        setHealth(health+value);
        Output.outputInformation(getName()+" used "+sourcename+", health increased to "+health);
    }

    public void reduceAttackrate(int value, String sourcename){
        setHealth(attackrate+value);
        Output.outputInformation(getName()+" used "+sourcename+", attack rating increased to "+health);
    }

    public void increaseAttackrate(int value, String sourcename){
        int tmp=attackrate-value;
        if(tmp < Configuration.MinAttackRate)
            tmp=Configuration.MinAttackRate;
        setHealth(tmp);
        Output.outputInformation(getName()+" used "+sourcename+", attack rating decreased to "+attackrate);
    }
}
