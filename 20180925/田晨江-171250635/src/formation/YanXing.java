package formation;

import world.*;
import creature.Creature;

public class YanXing implements FormationImp {
    @Override
    public void arrange(BattleField battleField, Creature[] creature, Location location ) {
        int row = battleField.getRow();
        int column = battleField.getColumn();

        int location_x = location.getX();
        int location_y = location.getY();

        int num = creature.length;

        for(int i=location.getX(),count=0;
            i<location.getX()+num&&count<num; count++,i++){
            battleField.addCreature(creature[count],new Location(location_x,location_y));
            location_x--;
            location_y++;
        }

        }
}
