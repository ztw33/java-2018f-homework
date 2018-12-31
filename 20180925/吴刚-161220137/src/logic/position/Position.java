package logic.position;/*
 * @author:Wu Gang
 * @create: 2018-10-07 19:46
 */

import javafx.scene.image.Image;
import logic.creatureInformation.Creature;

public class Position <T extends Creature>{
    private int x;
    private int y;
    private T creature;

    public Position(int x, int y, T creature) {
        this.x = x;
        this.y = y;
        this.creature = creature;
    }

    public void printPosition(){
        if(this.creature != null){
            creature.sayName();
        }
        else
            System.out.print("----");
    }

    public void setCreature(T creature) {
        this.creature = creature;
    }

    public Object getImage() {
        if(this.creature!=null)
            return  this.creature.getImage();
        return null;
    }

    public Image getMyImage() {
        if(this.creature!=null)
            return  this.creature.getMyImage();
        return null;
    }
}
