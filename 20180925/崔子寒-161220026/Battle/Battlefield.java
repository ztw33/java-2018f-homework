package Battle;

import Attributes.Position;
import Creatures.*;

import java.util.ArrayList;

public class Battlefield {
    private ArrayList<ArrayList<Block<Creature>>> battlefield = new ArrayList<>();
    public Battlefield() {
        for(int i = 0;i < 10;i++) {
            ArrayList<Block<Creature>> blockColumn = new ArrayList<>();
            for( int j = 0;j < 16;j++) {
                blockColumn.add(new Block());
            }
            battlefield.add(blockColumn);
        }
    }

    public ArrayList<ArrayList<Block<Creature>>> getBattlefield() {
        return battlefield;
    }

    public void clear() {
        for (ArrayList<Block<Creature>> blockColumn:battlefield) {
            for(Block block:blockColumn) {
                block.creatureLeave();
            }
        }
    }

    public void creatureEnter(Creature creature, Position position) {
        try{
            battlefield.get(position.getX()).get(position.getY()).creatureEnter(creature);
        }
        catch (NullPointerException e) {
            e.printStackTrace();
            System.err.println("A illegal creature try to enter");
            System.exit(-2);
        }
    }
}

