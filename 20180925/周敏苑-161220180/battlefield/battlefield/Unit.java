package battlefield;

import creature.Creature;
import creature.Position;

public class Unit {
    private boolean exist_creature;
    private Creature unit_creature;
    private Position position;

    Unit(){
        exist_creature = false;
        unit_creature = null;
        position = new Position();
    }

    Unit(Position coordinate) {
        unit_creature = null;
        position = coordinate;
        exist_creature = false;
    }

    Unit(Creature creature, Position coordinate) {
        unit_creature = creature;
        position = coordinate;
        exist_creature = true;
    }
    public String getName(){
        return unit_creature.toString();
    }

    public void clear_unit(){
        exist_creature = false;
        unit_creature = null;
    }

    public boolean setCreature(Creature creature){
        if(exist_creature)
            return false;
        else{
            exist_creature = true;
            unit_creature = creature;
            return true;
        }
    }

    public boolean if_exist_creature(){
        return exist_creature;
    }
}
