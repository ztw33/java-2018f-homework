package Creatures;

import javafx.scene.image.Image;
import Source.Global;
import java.net.URL;

public class Creature {
    //MARK: Properties;
    String name;
    int pos_x;
    int pos_y;
    Image image;
    boolean isDead;
    boolean isBlank;
    boolean isFriend;


    //Mark: initialize;
    public Creature(){
        pos_x = 0;
        pos_y = 0;
        name = null;
        image = null;
        isDead = false;
        isBlank = false;
    }

    //MARK: function
    public boolean setPosition(int new_x,int new_y){
        if(new_y < 0 || new_x < 0 || new_x >= Global.colCount || new_y >= Global.rowCount)
            return false;
        pos_y = new_y;
        pos_x = new_x;
        return true;
    }

    public boolean isAlive() {
        return !isDead;
    }

    public boolean isBlank(){
        return isBlank;
    }

    public Image getImage(){
        URL url = getClass().getResource(Global.deadImageURL);
        if(this.isDead == true)
            return new Image(url.toString());
        if(image != null)
            return image;
        Image defaultImage = new Image(this.getClass().getResource(Global.defaultImageURL).toString());
        return defaultImage;
    }

    public int getPos_x(){return pos_x;}

    public int getPos_y(){return pos_y;}

    public void setDead(){
        isDead = true;
    }

    public boolean isFriend(){
        return isFriend;
    }

    public void init(){
        isDead = false;
        pos_x = 0;
        pos_y = 0;
    }
}
