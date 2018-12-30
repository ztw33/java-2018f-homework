package creature;

import creature.Creature;

public class Location<T extends Creature> {

    private int x;
    private int y;
    private T location_creature;
    private boolean isEmpty = false;


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


    public void setLocation_creature(T location_creature) {
        this.location_creature = location_creature;
    }

    public T getLocation_creature() {
        return location_creature;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}

