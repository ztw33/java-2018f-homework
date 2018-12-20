package Formation;

import Creature.Creature;

public class Heyi {
    protected String name;

    public void setName() {
        this.name = "鹤翼阵";
    }
    public void setHeyi(Creature crowd[]){
        int i;
        for( i=0;i<(crowd.length+1)/2;i++){
            crowd[i].moveto(0+i,(crowd.length+1)/2-1-i);
        }
        for(;i<crowd.length;i++){
            crowd[i].moveto(0+i,i-(crowd.length+1)/2+1);
        }
    }

}
