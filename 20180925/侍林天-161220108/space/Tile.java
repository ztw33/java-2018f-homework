package space;
import creature.*;
public class Tile<T extends Creature> {
    private int coordinateX;
    private int coordinateY;
    private T creatureStandOnTile;
    public Tile(){
        coordinateX = 0;
        coordinateY = 0;
        creatureStandOnTile = null;
    }
    public Tile(int x, int y){
        coordinateX = x;
        coordinateY = y;
        creatureStandOnTile = null;
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
    public void removeCreatureStandOnTile(){
        creatureStandOnTile = null;
        //System.out.println(" "+coordinateX+" "+coordinateY);
    }
    public void setCreatureStandOnTile(T x){
        creatureStandOnTile = x;
    }
    public boolean isEmpty(){
        if (creatureStandOnTile == null){
            return true;
        } else {
            return false;
        }
    }
    public String getCreatureName(){
        return creatureStandOnTile.getName();
    }
    public Creature getCreature() { return creatureStandOnTile; }
}
