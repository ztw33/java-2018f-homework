package sort;

import creature.Location;
import creature.Creature;
import formation.Queue;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomSort implements Sorter {
    @Override
    public void sort(Queue queue) {
//        取代以前每个随机变量实例化一个随机数生成器实例，每个线程实例化一个。
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

