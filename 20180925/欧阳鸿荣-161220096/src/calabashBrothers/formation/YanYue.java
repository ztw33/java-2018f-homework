package calabashBrothers.formation;

import calabashBrothers.Maps;
import calabashBrothers.beings.Creature;

/**
 * @ Author     ：Young
 * @ Description：偃月阵
 */
public class YanYue extends Formation{
    public YanYue(int startX, int startY) {
        super(startX, startY);
    }

    @Override
    public void SetFormation(Maps maps, Creature[] creatures, int direction) {
        maps.getMaps()[startX][startY].setCreature(creatures[0]);
        maps.getMaps()[startX][startY+1].setCreature(creatures[1]);
        maps.getMaps()[startX][startY+2].setCreature(creatures[2]);
        maps.getMaps()[startX-1][startY].setCreature(creatures[3]);
        maps.getMaps()[startX-1][startY+1].setCreature(creatures[4]);
        maps.getMaps()[startX-1][startY+2].setCreature(creatures[5]);
        maps.getMaps()[startX+1][startY].setCreature(creatures[6]);
        maps.getMaps()[startX+1][startY+1].setCreature(creatures[7]);
        maps.getMaps()[startX+1][startY+2].setCreature(creatures[8]);
        maps.getMaps()[startX-2][startY+2].setCreature(creatures[9]);
        maps.getMaps()[startX-2][startY+3].setCreature(creatures[10]);
        maps.getMaps()[startX-3][startY+3].setCreature(creatures[11]);
        maps.getMaps()[startX-3][startY+4].setCreature(creatures[12]);
        maps.getMaps()[startX-4][startY+5].setCreature(creatures[13]);
        maps.getMaps()[startX+2][startY+2].setCreature(creatures[14]);
        maps.getMaps()[startX+2][startY+3].setCreature(creatures[15]);
        maps.getMaps()[startX+3][startY+3].setCreature(creatures[16]);
        maps.getMaps()[startX+3][startY+4].setCreature(creatures[17]);
        maps.getMaps()[startX+4][startY+5].setCreature(creatures[18]);

    }
}
