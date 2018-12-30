package formation;

import creature.Location;
import creature.Creature;
import java.util.ArrayList;

public class Queue {

    private Location[] locations;
    private Creature[] creatures;
    private ArrayList<Creature> list = new ArrayList<>(); //TODO


    public Queue(Creature[] cb){
        this.locations = new Location[cb.length];
        this.creatures = cb;

        for (int i = 0; i < cb.length; i++) {
            this.locations[i] = new Location(0,i);
            this.creatures[i].setLocation(this.locations[i]);
        }
        this.creatures = cb;

        for (Creature creature : creatures) {
            list.add(creature);
        }
        this.setList(list);
    }

    public Location[] getLocations() {
        return locations;
    }

    public Creature[] getCreatures() {
        return creatures;
    }

    public ArrayList<? extends Creature> getList() {
        return list;
    }

    public void setList(ArrayList<Creature> list) {
        this.list = list;
    }
}
