package backstage.battleGround;

import annotation.AuthorAnno;
import backstage.creature.Creature;

@AuthorAnno(time = "2018.12.20",version = "2.0")
public class Position{
    private Creature creature;

    Position(){
        creature = null;
    }


    public void setCreature(Creature creature, int x, int y) {
        this.creature = creature;
        creature.setLocationX(x);
        creature.setLocationY(y);
        creature.setImageViewLocation();
    }
    public void clean(){
        this.creature = null;
    }
    public Creature getCreature() {
        return creature;
    }



}
