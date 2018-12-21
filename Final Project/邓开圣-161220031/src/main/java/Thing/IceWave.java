package Thing;

import Enums.Direction;
import Frame.GameObject;
import Main.GameAdmin;
import Character.Snake;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class IceWave extends GameObject {
    private GameAdmin admin;            
    private Image currentImage;
    private int x, y;
    private double zoomRatio = 0.8;
    private Direction direction;
    private int moveSpeed = 25;
    private int atkPower = 50;
    private static Image[] images = null;

    static{
        try {
            images = new Image[]{
                    new Image(new FileInputStream(wd + "\\resources\\effect1\\left.png")),
                    new Image(new FileInputStream(wd + "\\resources\\effect1\\right.png")),
                    new Image(new FileInputStream(wd + "\\resources\\effect1\\up.png")),
                    new Image(new FileInputStream(wd + "\\resources\\effect1\\down.png"))
            };
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public IceWave(int x, int y, Direction direction, boolean good,GameAdmin admin){
        super(x,y,50,50,good);
        this.x = x;this.y = y;
        this.direction = direction;
        if(direction!=Direction.Stop)
            currentImage = images[direction.ordinal()];
        this.admin = admin;
    }

    private void move(){
        switch (direction){
            case Left: setX(getX()-moveSpeed);break;
            case Right:setX(getX()+moveSpeed);break;
            case Up:setY(getY()-moveSpeed);break;
            case Down:setY(getY()+moveSpeed);break;
            default:break;
        }
        
        if(getX()<=0 || getX()>=this.admin.getScene().getWidth()
                ||getY()<= (-currentImage.getHeight()) || getY()>= this.admin.getScene().getHeight()){
            this.admin.removeObject(this);
        }

    }

    public Rectangle getRect(){
        return new Rectangle(getX(),getY(),(int)(currentImage.getWidth()*zoomRatio),(int)(currentImage.getHeight()*zoomRatio));
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(currentImage,getX(),getY(),(int)(currentImage.getWidth()*zoomRatio),(int)(currentImage.getHeight()*zoomRatio));
        move();
        collideWithObjects(this.admin.getObjectList()); 
    }

    public void update() {

    }

    private void collideWithObjects(List<GameObject> objects){
        for(int i=0;i<objects.size();i++){
            GameObject o = objects.get(i);
            if(o!=this){
                if(o instanceof Snake && ((Snake) o).isLive() && ((Snake) o).getRect().intersects(this.getRect())){
                    ((Snake) o).hitByWave(atkPower); this.admin.removeObject(this);
                }
            }
        }
    }
}
