package formation;

import world.*;
import creature.Creature;

public class HeYi implements FormationImp {
    @Override
    public void arrange(BattleField battleField, Creature[] creature, Location location) {
        int row = battleField.getRow();
        int column = battleField.getColumn();

        int location_x = location.getX();
        int location_y = location.getY();

        int num = creature.length;

        for(int i=location.getX(),count=0;
            i<location.getX()+num&&count<num; count++,i++){

            if(count<(int)(num/2)){
                battleField.addCreature(creature[count],new Location(location_x,location_y));
                location_x++;
                location_y++;
            }
            else {
                battleField.addCreature(creature[count],new Location(location_x,location_y));
                location_x--;
                location_y++;
            }

        }

    }
}
