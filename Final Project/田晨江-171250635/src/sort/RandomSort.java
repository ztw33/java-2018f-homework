package sort;

import BattleField.Location;
import creature.CalabashBrothers;
import creature.Creature;
import formation.Queue;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomSort implements Sorter {
    @Override
    public void sort(Queue queue) {
        Random rnd = ThreadLocalRandom.current();
        Location[] locations = queue.getLocations();
        Creature creature = null;

        for(int i=locations.length; i>=1; i--){
            int j = rnd.nextInt(i);

            creature = locations[i-1].getLocation_creature(); //temp
            locations[j].getLocation_creature().setLocation(locations[i-1]);
            creature.setLocation(locations[j]);
        }

    }
}

