package Battle;

import Creatures.Creature;
import javafx.scene.image.Image;

public class Block<T extends Creature> {
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

    public Image getImage() {
        if(creature == null) {
            return null;
        }
        else {
            return creature.getImage();
        }
    }
}
