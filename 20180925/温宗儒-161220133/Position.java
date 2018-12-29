import creature.Creature;

class Position {
    private Creature creature;
    private boolean possession;

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



}
