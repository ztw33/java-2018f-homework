package creature;
import space.*;
import javax.imageio.*;
import java.io.*;
import javafx.scene.image.*;
public class Creature {
    protected String name;
    protected int coordinateX;
    protected int coordinateY;
    protected String imgPath;
    protected Image image;
    public Creature(){
        coordinateX = -1;
        coordinateY = -1;
        name = "未命名";
    }
    public Creature(String name){
        coordinateX = -1;
        coordinateY = -1;
        this.name = name;
    }
    public String getPath() { return imgPath; }
    public Image getImage() {return image; }
    public String getName(){
        return name;
    }
    public void shoutOutName(){
        System.out.println(name);
    }
    public int getCoordinateX(){
        return coordinateX;
    }
    public int getCoordinateY(){
        return coordinateY;
    }
    public void setCoordinate(int x, int y){
        coordinateX = x;
        coordinateY = y;
    }
    public boolean moveTo(TwoDimensionSpace space, int x, int y){
        //System.out.print(x);
        //System.out.print(" ");
        //System.out.print(y);
        //System.out.print("\n");
        if (!space.isExceed(x, y)){
            if (space.isEmpty(x, y)) {
                space.cleanSpace(coordinateX, coordinateY);
                space.setSpace(x, y, this);
                coordinateX = x;
                coordinateY = y;
                return true;
            }
        }
        return false;
    }
    public void removeFrom(TwoDimensionSpace space){
        if (!space.isExceed(coordinateX, coordinateY)){
            space.cleanSpace(coordinateX, coordinateY);
            coordinateX = -1;
            coordinateY = -1;
        }
    }
}
