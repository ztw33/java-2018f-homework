import Attributes.Position;
import Creatures.*;
import java.util.ArrayList;

public class Battlefield {
    private ArrayList<ArrayList<Block<Creature>>> battlefield = new ArrayList<>();
    public Battlefield() {
        for(int i = 0;i < 10;i++) {
            ArrayList<Block<Creature>> blockColumn = new ArrayList<>();
            for( int j = 0;j < 20;j++) {
                blockColumn.add(new Block());
            }
            battlefield.add(blockColumn);
        }
    }
    public void print() {
        for (ArrayList<Block<Creature>> blockColumn:battlefield) {
            for(Block block:blockColumn) {
                block.outputInfo();
                if(blockColumn.indexOf(block) == 9) {
                    System.out.print('|');
                }
            }
            System.out.println();
        }
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

class Block<T extends Creature> {
    private T creature = null;
    private boolean isEmpty = true;

    public boolean creatureEnter(T creature) throws NullPointerException{
        isEmpty = false;
        this.creature = creature;
        if(this.creature==null) {
            throw  new NullPointerException() ;
        }
        return true;
    }

    public void creatureLeave() {
        isEmpty = true;
        creature = null;
    }

    public void outputInfo() {
        if(isEmpty) {
            System.out.printf("    ");
        }
        else {
            try{
                creature.outputInfo();
            }
            catch (NullPointerException e) {
                e.printStackTrace();
                System.err.println("Null pointer");
                System.exit(-1);
            }
        }
    }
}
