package Thing;

import Animation.MyAnimation;
import Enums.Direction;
import Frame.GameObject;
import Character.GameAdmin;
import Character.Character;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public abstract class Weapon extends GameObject {
    protected Character owner;
    protected GameAdmin admin;

    Weapon(int x,int y,int width,int height,GameAdmin admin){
        super(x,y,width,height);
        this.admin = admin;
    }
    @Override
    public void draw(GraphicsContext gc) {

    }

    @Override
    public void update() {

    }
    public void appear(){

    }
    public void disappear(){

    }

    public abstract void stand();
    public abstract void stay();
    public abstract void move(Direction direction, int speed, int imageIndex);
    public abstract MyAnimation attack(Direction direction, int time);
    public abstract void collidesWithObjects(List<GameObject>objects);

    public Character getOwner() { return owner; }

    public void setOwner(Character owner) { this.owner = owner; }
}
