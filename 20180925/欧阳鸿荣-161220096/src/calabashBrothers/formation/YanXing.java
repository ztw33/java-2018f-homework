package calabashBrothers.formation;

import calabashBrothers.Maps;
import calabashBrothers.beings.Creature;

/**
 * @ Author     ：Young
 * @ Description：雁行阵
 */
public class YanXing extends Formation{
    public YanXing(int startX, int startY) {
        super(startX, startY);
    }

    @Override
    public void SetFormation(Maps maps, Creature[] creatures, int direction) {
        for (int i = 0; i <creatures.length ; i++) {
            maps.getMaps()[startX+i][startY-i].setCreature(creatures[i]);
        }
    }
}
