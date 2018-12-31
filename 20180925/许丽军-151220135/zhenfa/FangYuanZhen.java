package zhenfa;

import creature.Creature;
import space.BatterGround;

public class FangYuanZhen implements ZhenFa {
    private int midX, midY;

    static int[][] offset = {{0,2},{1,1},{2,0},{1,-1},{0,-2},{-1,-1},{-2,0},{-1,1}};


    public FangYuanZhen(int midX, int midY){
        this.midX = midX;
        this.midY = midY;
    }

    @Override
    public void apply(BatterGround ground, Creature[] creatures) {
        if(creatures.length != 8)
            return;

        for(int i=0;i<creatures.length;i++){
            creatures[i].moveTo(ground, midX + offset[i][0], midY + offset[i][1]);
        }
    }

    @Override
    public void clear(BatterGround ground, Creature[] creatures) {
        for(int i=0;i<creatures.length;i++){
            creatures[i].leaveFrom(ground, midX + offset[i][0], midY + offset[i][1]);
        }
    }
}
