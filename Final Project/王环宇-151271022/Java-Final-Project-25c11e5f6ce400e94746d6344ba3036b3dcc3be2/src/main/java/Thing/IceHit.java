package Thing;

import Frame.GameObject;
import Main.GameAdmin;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class IceHit extends GameObject {
    private GameAdmin admin;
    private static Image[] images;
    private int index;
    private Image currentImage;

    static{
        try {
            images = new Image[]{
                    new Image(new FileInputStream(wd + "\\resources\\hitEffect\\iceHit\\iceHit1.png")),
                    new Image(new FileInputStream(wd + "\\resources\\hitEffect\\iceHit\\iceHit2.png")),
                    new Image(new FileInputStream(wd + "\\resources\\hitEffect\\iceHit\\iceHit3.png")),
                    new Image(new FileInputStream(wd + "\\resources\\hitEffect\\iceHit\\iceHit4.png")),
                    new Image(new FileInputStream(wd + "\\resources\\hitEffect\\iceHit\\iceHit5.png")),
                    new Image(new FileInputStream(wd + "\\resources\\hitEffect\\iceHit\\iceHit6.png")),
                    new Image(new FileInputStream(wd + "\\resources\\hitEffect\\iceHit\\iceHit7.png"))
            };
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public IceHit(int x, int y, boolean good,GameAdmin admin){
        super(x,y,50,50,good);
        index = 0;
        this.admin = admin;
    }
    public void draw(GraphicsContext gc) {
        currentImage = images[index];
        gc.drawImage(currentImage,getX(),getY(),(int)currentImage.getWidth(),(int)currentImage.getHeight());
        index++;
        if(index == images.length){
            index = 0;
            this.admin.removeObject(this);
        }
    }

    public void update() {

    }
}
