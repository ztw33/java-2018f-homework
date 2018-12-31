package formation;
import space.TwoDimensionSpace;
import creature.*;
public class YulinFormation extends Formation {
    public void generateFormation(TwoDimensionSpace space, Creature beings[], Creature ob, int x, int y, int direction){
        for (Creature creature : beings) {
            creature.removeFrom(space);
        }
        ob.removeFrom(space);
        if (direction == 0) {
            ob.moveTo(space, 0, 0);
        }
        else {
            ob.moveTo(space, space.size() - 1, space.size() - 1);
        }
        if (direction == 0){
            int i = 0;
            int k = 0;
            while (i < beings.length){
                for (int j = x; j < x + k && i < beings.length; j++){
                    beings[i].moveTo(space, j, y - k);
                    i++;
                }
                k++;
            }
        } else {
            int i = 0;
            int k = 0;
            while (i < beings.length){
                for (int j = x; j < x + k && i < beings.length; j++){
                    beings[i].moveTo(space, j, y + k);
                    i++;
                }
                k++;
            }
        }
    }
}
