package Creatures;
import Attributes.*;

public abstract class Creature {
    private Position position= new Position();
    public void setPosition(int x,int y) {
        position.setX(x);
        position.setY(y);
    }

    public Position getPosition() {
        return  position;
    }
    public abstract void outputInfo();
}
