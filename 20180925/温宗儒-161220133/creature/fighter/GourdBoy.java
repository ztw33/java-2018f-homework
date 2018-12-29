package creature.fighter;

import creature.Creature;

public class GourdBoy extends Creature {

    public int getRank(){
        return this.attribute.getRank();
    }
    Attribute attribute;

    //constructor
    public GourdBoy(Attribute attribute){
        this.attribute = attribute;
        name = this.attribute.getName();
    }
}
