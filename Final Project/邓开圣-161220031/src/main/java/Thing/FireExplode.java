package Thing;

import Frame.GameObject;
import Main.GameAdmin;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FireExplode extends GameObject {
    private GameAdmin admin;
    private static Image image;
    private static int drawCount = 10;
    private int count;
    static{
        try {
            image = new Image(new FileInputStream(wd +"\\resources\\hitEffect\\fireExplode.gif"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public FireExplode(int x,int y,boolean good,GameAdmin admin){
        super(x,y,50,50,good);
        this.admin = admin;
        this.count = drawCount;
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(image,getX(),getY(),50,50);
        count--;
        if(count == 0){
            this.admin.removeObject(this);
        }
    }

    public void update() {

    }
}
