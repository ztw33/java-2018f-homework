package Thing;

import Enums.Direction;
import Frame.GameObject;
import Character.GameAdmin;
import Character.FemaleFighter;
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
    public FireSphere(int x, int y, Direction direction,GameAdmin admin){
        super(x,y,50,50);
        this.direction = direction;
        this.admin = admin;
        currentImage = images[direction.ordinal()];
    }
    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(currentImage,getX(),getY(),(int)(currentImage.getWidth()*zoomRatio),(int)(currentImage.getHeight()*zoomRatio));

        move();
        collidesWithObjects(admin.getObjectList());
    }

    @Override
    public void update() {

    }
    private void move(){
        switch (direction){
            case Left: setX(getX()-moveSpeed);break;
            case Right:setX(getX()+moveSpeed);break;
            case Up:setY(getY()-moveSpeed);break;
            case Down:setY(getY()+moveSpeed);break;
            default:break;
        }
        //光波飞出边界后删除
        if(getX()<=0 || getX()>=this.admin.getScene().getWidth()
                ||getY()<= (-currentImage.getHeight()) || getY()>= this.admin.getScene().getHeight()){
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
                //火球和冰光抵消
                if(o instanceof IceWave && ((IceWave) o).getRect().intersects(this.getRect())){
                    objects.remove(this);objects.remove(o); return true;
                }else if(o instanceof FemaleFighter && ((FemaleFighter) o).getRect().intersects(this.getRect())){
                    ((FemaleFighter) o).getHit();objects.remove(this); return true;
                }
            }
        }
        return false;
    }
}
