package formation;

import world.*;
import creature.Creature;

public class HeYi implements FormationImp {
    @Override
    public void arrange(BattleField battleField, Queue queue, Location location) {
        int row = battleField.getRow();
        int column = battleField.getColumn();

        Creature[] creatures = queue.getCreatures();


        int location_x = location.getX();
        int location_y = location.getY();

        int num = creatures.length;

        for(int i=location.getX(),count=0;
            i<location.getX()+num&&count<num; count++,i++){

            if(count<(int)(num/2)){
                battleField.addCreature(creatures[count],new Location(location_x,location_y));
                creatures[count].setLocation(new Location(location_x,location_y));
                location_x++;
                location_y++;
            }
            else {
                battleField.addCreature(creatures[count],new Location(location_x,location_y));
                creatures[count].setLocation(new Location(location_x,location_y));
                location_x--;
                location_y++;
            }

        }

    }
}
