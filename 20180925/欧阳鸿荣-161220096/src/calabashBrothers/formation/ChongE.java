package calabashBrothers.formation;

import calabashBrothers.Maps;
import calabashBrothers.beings.Creature;

/**
 * @ Author     ：Young
 * @ Description：衝轭阵
 */
public class ChongE extends Formation{
    public ChongE(int startX, int startY) {
        super(startX, startY);
    }

    @Override
    public void SetFormation(Maps maps, Creature[] creatures, int direction) {
        for (int i = 0; i <creatures.length ; i++) {
            if(i%2==0){
                maps.getMaps()[startX+i][startY].setCreature(creatures[i]);
            }else{
                maps.getMaps()[startX+i][startY+1].setCreature(creatures[i]);
            }
        }
    }
}
