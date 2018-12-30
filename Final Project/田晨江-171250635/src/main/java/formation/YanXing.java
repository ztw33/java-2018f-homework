package formation;

import creature.Location;
import world.*;
import creature.Creature;

public class YanXing implements FormationImp {
    @Override
    public void arrange(BattleField battleField, Queue queue, Location location ) {
        int row = battleField.getRow();
        int column = battleField.getColumn();
        Creature[] creatures = queue.getCreatures();
        location.setEmpty(false);

        int location_x = location.getX();
        int location_y = location.getY();

        int num = creatures.length;

        for(int i=location.getX(),count=0;
            i<location.getX()+num&&count<num; count++,i++){
            battleField.addCreature(creatures[count],new Location(location_x,location_y));
            creatures[count].setLocation(new Location(location_x,location_y));
            new Location(location_x, location_y).setEmpty(false);
            location_x--;
            location_y++;
        }

        }
}
