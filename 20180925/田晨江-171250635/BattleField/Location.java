package world;

import creature.Creature;

public class Location {

    private int x;
    private int y;
    private Creature location_creature;


    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public void setLocation_creature(Creature location_creature) {
        this.location_creature = location_creature;
    }

    public Creature getLocation_creature() {
        return location_creature;
    }
}

