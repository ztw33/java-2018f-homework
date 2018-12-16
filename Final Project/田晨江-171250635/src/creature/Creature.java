package creature;
import javafx.scene.image.Image;
import world.*;


public class Creature implements Comparable {

    protected String name;
    private Creature creature;
    private Location location;
    private Image image;

    public String toString(){return name;}

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
        location.setLocation_creature(this);
    }

    public void setCreature(Creature creature){
        this.creature = creature;
    }

    @Override
    public boolean compareTo(Comparable another) {
        return false;
    }






    /*synchronized来起到同步加锁*/
    public synchronized void isConfilct(int offsetx, int offsety){

    }

    public Image getImage() {
        return image;
    }


/*
     打印当前名字+位置
    public void printCreature(){
        System.out.print(name+":  (" +x+","+y+")");
    }
*/



}
