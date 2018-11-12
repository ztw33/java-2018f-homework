package calabashBrothers.formation;

import calabashBrothers.Maps;
import calabashBrothers.beings.Creature;

/**
 * @ Author     ：Young
 * @ Description：长蛇阵
 */
public class ChangShe extends Formation{
    public ChangShe(int startX, int startY) {
        super(startX, startY);
    }

    @Override
    public void SetFormation(Maps maps, Creature[] creatures, int direction) {
        for (int i = 0; i <creatures.length ; i++) {
            maps.getMaps()[startX+i][startY].setCreature(creatures[i]);
        }
    }
}
