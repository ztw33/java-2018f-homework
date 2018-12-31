import Attributes.Position;
import Creatures.*;
import java.io.*;

public class Battlefield {
    private Block[][] battlefield = new Block[10][20];
    public Battlefield() {
        for(int i = 0;i < 10;i++) {
            for( int j = 0;j < 20;j++) {
                battlefield[i][j] = new Block();
            }
        }
    }
    public void print() {
        for(int i = 0;i < 10;i++) {
            for(int j = 0; j<20 ;j++) {
                battlefield[i][j].outputInfo();
                if(j == 9){
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }
    public void clear() {
        for(int i = 0;i < 10;i++) {
            for(int j = 0;j < 20;j++) {
                battlefield[i][j].creatureLeave();
            }
        }
    }
    public void creatureEnter(Creature creature, Position position) {
        try{
            battlefield[position.getX()][position.getY()].creatureEnter(creature);
        }
        catch (NullPointerException e) {
            e.printStackTrace();
            System.err.println("A illegal creature try to enter");
            System.exit(-2);
        }
    }
}

class Block {
    private Creature creature = null;
    private boolean isEmpty = true;

    public boolean creatureEnter(Creature creature) throws NullPointerException{
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
