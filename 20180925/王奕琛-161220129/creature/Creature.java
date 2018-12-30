package creature;
import map.Map;

//生物类，每个生物都会站在地图上，都有自己的名字（或为空）；
public class Creature {
    protected String name;

    public Creature(){name = "NULL";}

    public String getName(){
        return name;
    }

    public void standOn(Map map, int x, int y){
        if(!map.isStand(x,y))
            map.setCreatures(this,x,y);
    }
}


