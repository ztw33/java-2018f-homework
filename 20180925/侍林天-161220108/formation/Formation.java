package formation;
import space.*;
import creature.*;
public abstract class Formation {
    public abstract void generateFormation(TwoDimensionSpace space, Creature beings[], Creature ob, int x, int y, int direction);
}
