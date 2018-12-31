package creature;
import space.*;
public class Creature {
    protected String name;
    protected int coordinateX;
    protected int coordinateY;
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
