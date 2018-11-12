package calabashBrothers.formation;

import calabashBrothers.Maps;
import calabashBrothers.beings.Creature;

/**
 * @ Author     ：Young
 * @ Description：鱼鳞阵
 */
public class YuLin extends Formation{
    public YuLin(int startX, int startY) {
        super(startX, startY);
    }

    @Override
    public void SetFormation(Maps maps, Creature[] creatures, int direction) {
        maps.getMaps()[startX][startY].setCreature(creatures[0]);
        maps.getMaps()[startX-1][startY+1].setCreature(creatures[1]);
        maps.getMaps()[startX-2][startY+2].setCreature(creatures[2]);
        maps.getMaps()[startX][startY+2].setCreature(creatures[3]);
        maps.getMaps()[startX+2][startY+2].setCreature(creatures[4]);
        maps.getMaps()[startX-3][startY+3].setCreature(creatures[5]);
        maps.getMaps()[startX-1][startY+3].setCreature(creatures[6]);
        maps.getMaps()[startX+1][startY+3].setCreature(creatures[7]);
        maps.getMaps()[startX+3][startY+3].setCreature(creatures[8]);
        maps.getMaps()[startX][startY+4].setCreature(creatures[9]);
    }
}
