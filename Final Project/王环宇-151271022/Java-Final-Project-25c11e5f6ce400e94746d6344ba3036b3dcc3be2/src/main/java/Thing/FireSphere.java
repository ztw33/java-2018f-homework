package Thing;

import Enums.Direction;
import Frame.GameObject;
import Character.Fighter;
import Main.GameAdmin;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class FireSphere extends GameObject {
    private GameAdmin admin;
    private Direction direction;
    private int moveSpeed = 15;
    private Image currentImage;
    private double zoomRatio = 1.1;
    private int atkPower = 10;
    private static Image[] images = null;
    static {
        try {
            images = new Image[]{
                    new Image(new FileInputStream(wd +"\\resources\\monster1\\effect\\fireLeft.png")),
                    new Image(new FileInputStream(wd +"\\resources\\monster1\\effect\\fireRight.png")),
                    new Image(new FileInputStream(wd +"\\resources\\monster1\\effect\\fireUp.png")),
                    new Image(new FileInputStream(wd +"\\resources\\monster1\\effect\\fireDown.png"))
            };
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public FireSphere(int x, int y, Direction direction,boolean good, GameAdmin admin){
        super(x,y,50,50,good);
        this.direction = direction;
        this.admin = admin;
        currentImage = images[direction.ordinal()];
    }

    private void move(){
        switch (direction){
            case Left: setX(getX()-moveSpeed);break;
            case Right:setX(getX()+moveSpeed);break;
            case Up:setY(getY()-moveSpeed);break;
            case Down:setY(getY()+moveSpeed);break;
            default:break;
        }
        if(getX()<=0 || getX()>=this.admin.getWidth()
                ||getY()<= (-currentImage.getHeight()) || getY()>= this.admin.getHeight()){
            this.admin.removeObject(this);
        }

    }

    public Rectangle getRect(){
        return new Rectangle(getX(),getY(),(int)(currentImage.getWidth()*zoomRatio),(int)(currentImage.getHeight()*zoomRatio));
    }

    public boolean collidesWithObjects(List<GameObject> objects){
        for(int i=0;i<objects.size();i++){
            GameObject o = objects.get(i);
            if(o!=this){

                if(o instanceof IceWave && ((IceWave) o).getRect().intersects(this.getRect())){     //火球和冰光抵消
                    objects.remove(this);objects.remove(o); return true;
                }else if(o instanceof Fighter && ((Fighter) o).getRect().intersects(this.getRect())){   //火球击中主角
                    ((Fighter) o).getHit(getX(),getY(),atkPower);objects.remove(this); return true;
                }else if(o instanceof Shield && ((Shield) o).getRect().intersects(this.getRect())){     //火球被护盾吸收
                    this.admin.removeObject(this);
                }
            }
        }
        return false;
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(currentImage,getX(),getY(),(int)(currentImage.getWidth()*zoomRatio),(int)(currentImage.getHeight()*zoomRatio));

        move();
        collidesWithObjects(admin.getObjectList());
    }

    public void update() {

    }
}
