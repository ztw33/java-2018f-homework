package creatureInformation;/*
 * @author:Wu Gang
 * @create: 2018-10-07 19:15
 */

import position.Position;

public class Creature {
    Position position = new Position(-1, -1, null);
    public void sayName(){};

    public void moveTo(Position position){
        this.position.setCreature(null);
        this.position = position;
        this.position.setCreature(this);
    }
}





