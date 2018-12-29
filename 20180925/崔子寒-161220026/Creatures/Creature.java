package Creatures;
import Attributes.*;
import javafx.scene.image.Image;

public abstract class Creature {
    private Position position= new Position();
    protected Image image;
    public void setPosition(int x,int y) {
        position.setX(x);
        position.setY(y);
    }

    public Position getPosition() {
        return  position;
    }
    public abstract void outputInfo();
    public abstract Image getImage();
}
