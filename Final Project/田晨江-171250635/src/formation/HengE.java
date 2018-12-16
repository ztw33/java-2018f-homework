package formation;

import world.*;
import creature.Creature;

public class HengE implements FormationImp {
    @Override
    public void arrange(BattleField battleField, Queue queue, Location location ) {
        int row = battleField.getRow();
        int column = battleField.getColumn();
        Creature[] creatures = queue.getCreatures();


        int location_x = location.getX();
        int location_y = location.getY();

        int num = creatures.length;

        for(int i=location.getX(),count=0;
            i<location.getX()+num&&count<num; count++,i++){
            battleField.addCreature(creatures[count],new Location(location_x,location_y));
            creatures[count].setLocation(new Location(location_x,location_y));
            if(count%2 == 0) {
                location_x++;
                location_y++;
            }else {
                location_x++;
                location_y--;
            }
        }
    }
}
