package Thing;

import Character.Character;
import Animation.MyAnimation;
import Enums.Direction;
import Frame.GameScreen;
import Frame.GameObject;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public abstract class Weapon extends GameObject {
    protected Character owner;
    protected GameScreen admin;

    public Weapon(int x, int y, int width, int height, boolean good,GameScreen admin){
        super(x,y,width,height,good);
        this.admin = admin;
    }

    public void appear(){

    }
    public void disappear(){

    }

    public abstract void stand();
    public abstract void stay();
    public abstract void move(Direction direction, int speed, int imageIndex);
    public abstract MyAnimation attack(Direction direction, int time);
    public abstract void collidesWithObjects(List<GameObject> objects);

    public Character getOwner() { return owner; }

    public void setOwner(Character owner) { this.owner = owner; }

    public void draw(GraphicsContext gc) {

    }

    public void update() {

    }
}
