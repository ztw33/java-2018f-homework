package Thing;

import Frame.GameObject;
import Main.GameAdmin;
import Character.Fighter;
import Character.Snake;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class BloodMedicine extends GameObject {
    private GameAdmin admin;
    private static Image image;
    private static int maintainTime = 5000;
    private static int recoverAmount = 40;
    static{
        try {
            image = new Image(new FileInputStream(wd + "\\resources\\things\\bloodMedicine.png"),40,40,false,false);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public BloodMedicine(int x, int y, boolean good, GameAdmin admin){
        super(x,y,50,50,good);
        this.admin = admin;
        maintainCountStart();
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(image,getX(),getY(),(int)image.getWidth(),(int)image.getHeight());
        collidesWithObjects(this.admin.getObjectList());
    }

    public void update() {

    }

    private void disappear(){
        this.admin.removeObject(this);
    }
    private void maintainCountStart(){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                disappear();
                System.gc();cancel();
            }
        },maintainTime);
    }

    public Rectangle getRect(){
        return new Rectangle(getX(),getY(),(int)image.getWidth(),(int)image.getHeight());
    }

    private void collidesWithObjects(List<GameObject> objects){
        for(int i=0;i<objects.size();i++){
            GameObject o = objects.get(i);
            if(o != this){
                if(o instanceof Fighter && ((Fighter) o).isLive() &&                //主角获得药品
                        this.getRect().intersects(((Fighter) o).getRect())){
                    ((Fighter) o).getRecover(recoverAmount);
                    this.disappear();
                }else if(o instanceof Snake && ((Snake) o).isLive() &&              //药品被蛇捡到
                        this.getRect().intersects(((Snake) o).getRect())){
                    this.disappear();
                }
            }
        }
    }
}
