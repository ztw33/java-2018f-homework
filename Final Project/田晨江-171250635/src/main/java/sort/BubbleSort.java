package sort;

import creature.Location;
import creature.Creature;
import formation.Queue;

public class BubbleSort implements Sorter {
    @Override
    public void sort(Queue queue) {
        Location[] locations = queue.getLocations();
        Creature creature = null;

        for(int i = 0; i < locations.length-1; i++){
            for(int j = 0; j < locations.length-1; j++){
                if(locations[j].getLocation_creature().compareTo(locations[j+1].getLocation_creature())){
                    creature = locations[j].getLocation_creature(); //temp
                    locations[j + 1].getLocation_creature().setLocation(locations[j]);
                    creature.setLocation(locations[j + 1]);
                }
            }
        }
    }
}
