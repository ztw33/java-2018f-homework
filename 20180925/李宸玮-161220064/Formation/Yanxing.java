package Formation;

import Creature.Creature;

public class Yanxing {
    protected String name;

    public void setName() {
        this.name = "雁行阵";
    }
    public void setYanxing(Creature crowd[]){
        int i;
        for( i=0;i<crowd.length;i++){
            crowd[i].moveto(crowd.length-i,i);
        }
    }
}
