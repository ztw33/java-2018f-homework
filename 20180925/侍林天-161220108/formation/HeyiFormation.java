package formation;
import space.TwoDimensionSpace;
import creature.*;
public class HeyiFormation extends Formation {
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
        beings[0].moveTo(space, x, y);
        if (direction == 0) {
            for (int i = 1; i < beings.length; i++) {
                if (i % 2 == 0) {
                    beings[i].moveTo(space, x + i / 2, y + i / 2);
                } else {
                    beings[i].moveTo(space, x - i / 2 - 1, y + i / 2 + 1);
                }
            }
        } else {
            for (int i = 1; i < beings.length; i++) {
                if (i % 2 == 0) {
                    beings[i].moveTo(space, x + i / 2, y - i / 2);
                } else {
                    beings[i].moveTo(space, x - i / 2 - 1, y - i / 2 - 1);
                }
            }
        }
    }
}
