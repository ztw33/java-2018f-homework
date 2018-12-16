package formation;

import world.*;
import creature.*;


public class ChangShe implements FormationImp {

    @Override
    public void arrange(BattleField battleField, Queue queue, Location location) {
        int row = battleField.getRow();
        int column = battleField.getColumn();
        Creature[] creatures = queue.getCreatures();

        for(int i=location.getX(),count=0;
             i<location.getX() + creatures.length && count<creatures.length;  i++,count++){
            creatures[count].setLocation(new Location(i,location.getY()));
            battleField.addCreature(creatures[count],new Location(i,location.getY()));
        }
    }
}
