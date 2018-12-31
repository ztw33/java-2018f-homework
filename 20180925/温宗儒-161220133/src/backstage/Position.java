package backstage;

import backstage.creature.Creature;

public class Position {
    private Creature creature;   //放置的生物是什么
    private boolean possession; //该位置是否被占用

    Position(){
        creature = null;
        possession = false;
    }


    void print(){
        if(possession){
            System.out.print(creature.getName()+' ');
        }else {
            System.out.print("口   ");
        }
    }
    void setCreature(Creature creature) {
        this.creature = creature;
        this.possession = true;
    }

    void clean(){
        this.creature = null;
        this.possession = false;
    }



    public Creature getCreature() {
        return creature;
    }

    public boolean isPossession() {
        return possession;
    }



}
