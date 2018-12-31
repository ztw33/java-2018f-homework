package formation;

import world.*;
import creature.*;


public class ChangShe implements FormationImp {

    @Override
    public void arrange(BattleField battleField, Creature[] creature, Location location) {
        int row = battleField.getRow();
        int column = battleField.getColumn();
        for(int i=location.getX(),count=0;
             i<location.getX() + creature.length && count<creature.length;  i++,count++){
            battleField.addCreature(creature[count],new Location(i,location.getY()));
        }
    }
}
