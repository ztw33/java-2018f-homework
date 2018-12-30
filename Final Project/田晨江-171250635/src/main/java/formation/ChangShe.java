package formation;

import world.*;
import creature.*;


public class ChangShe implements FormationImp {


    public void arrange(BattleField battleField, Queue queue, Location location) {
        int row = battleField.getRow();
        int column = battleField.getColumn();
        Creature[] creatures = queue.getCreatures();
        location.setEmpty(false);

        for(int i=location.getX(),count=0;
             i<location.getX() + creatures.length && count<creatures.length;  i++,count++){

            Location location1 = new Location(i, location.getY());
            creatures[count].setLocation(location1);


            battleField.addCreature(creatures[count],new Location(i,location.getY()));
            location1.setEmpty(false);
        }
    }
}
