package homework3.creature;

import homework3.position.Position;

public abstract class Creature {
    String name;

    public Creature(){
        name = null;
    }

    public String toString(){
        return name;
    }
}
