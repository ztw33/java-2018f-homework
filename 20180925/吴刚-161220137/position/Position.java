package position;/*
 * @author:Wu Gang
 * @create: 2018-10-07 19:46
 */

import creatureInformation.Creature;

public class Position {
    private int x;
    private int y;
    private Creature creature;

    public Position(int x, int y, Creature creature) {
        this.x = x;
        this.y = y;
        this.creature = creature;
    }

    public void printPosition(){
        if(this.creature != null){
            creature.sayName();
        }
        else
            System.out.print("----");
    }

    public void setCreature(Creature creature) {
        this.creature = creature;
    }
}
