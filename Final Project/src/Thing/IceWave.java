package Thing;

import Enums.Direction;
import Frame.GameObject;
import Character.GameAdmin;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class IceWave extends GameObject {
    private GameAdmin admin;            //管理员类的引用
    private Image currentImage;
    private int x, y;
    private double zoomRatio = 0.8;
    private Direction direction;
    private int moveSpeed = 15;
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
    public IceWave(int x, int y, Direction direction,GameAdmin admin){
        super(x,y,50,50);
        this.x = x;this.y = y;
        this.direction = direction;
        if(direction!=Direction.Stop)
            currentImage = images[direction.ordinal()];
        this.admin = admin;
    }
    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(currentImage,getX(),getY(),(int)(currentImage.getWidth()*zoomRatio),(int)(currentImage.getHeight()*zoomRatio));
        move();
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


}
