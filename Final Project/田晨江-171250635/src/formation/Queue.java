package formation;

import BattleField.Location;
import creature.CalabashBrothers;
import creature.Creature;
import creature.LittleGuys;

public class Queue {

    private Location[] locations;
    private Creature[] creatures;


    public Queue(Creature[] cb){
        this.locations = new Location[cb.length];
        this.creatures = cb;

        for (int i = 0; i < cb.length; i++) {
            this.locations[i] = new Location(0,i);
            this.creatures[i].setLocation(this.locations[i]);
        }
        this.creatures = cb;
    }

    public Location[] getLocations() {
        return locations;
    }

    public Creature[] getCreatures() {
        return creatures;
    }
}
