package creature;
import world.*;


public class Creature {

    protected String name;
    //private int x, y;
    private Creature creature;
    private Location location;

    public String toString(){return name;}

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
        //location.setLocation_creature(this);
    }
    public void setCreature(Creature creature){
        this.creature = creature;
    }


    /** 打印当前名字+位置
    public void printCreature(){
        System.out.print(name+":  (" +x+","+y+")");
    }
*/

}
