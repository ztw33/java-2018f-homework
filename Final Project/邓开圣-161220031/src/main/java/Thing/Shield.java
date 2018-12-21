package Thing;

import Frame.GameObject;
import Main.GameAdmin;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Timer;
import java.util.TimerTask;

public class Shield extends GameObject {
    private GameAdmin admin;
    private static Image effect;
    private static int maintainTime = 3000;     //效果持续时间(单位：毫秒)
    static{
        try {
            effect = new Image(new FileInputStream( wd + "\\resources\\effect2\\superFire.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Shield(int x, int y, boolean good,GameAdmin admin){
        super(x,y,50,50,good);
        this.admin = admin;
        countTimeStart();
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(effect,getX(),getY(),300,300);
    }

    public void update() {

    }

    private void disappear(){
        this.admin.removeObject(this);
    }
    private void countTimeStart(){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                disappear();
                System.gc();cancel();
            }
        },maintainTime);
    }

    public Rectangle getRect(){
        return new Rectangle(getX(),getY(),(int)effect.getWidth(),(int)effect.getHeight());
    }
}
