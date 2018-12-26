package group;
import formation.*;
import space.TwoDimensionSpace;
public interface Group {
    public void generateFormation(Formation formation, TwoDimensionSpace space, int x, int y, int direction);
}
