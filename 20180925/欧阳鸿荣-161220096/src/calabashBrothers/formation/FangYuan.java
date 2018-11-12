package calabashBrothers.formation;

import calabashBrothers.Maps;
import calabashBrothers.beings.Creature;

/**
 * @ Author     ：Young
 * @ Description：方円阵
 */
public class FangYuan extends Formation{

    private int midX;
    private int midY;

    public FangYuan(int startX, int startY) {
        super(startX, startY);
        this.midX = startX;
        this.midY = startY+3;
    }

    @Override
    public void SetFormation(Maps maps, Creature[] creatures, int direction) {
        maps.getMaps()[midX][midY-3].setCreature(creatures[0]);
        maps.getMaps()[midX-1][midY-2].setCreature(creatures[1]);
        maps.getMaps()[midX+1][midY-2].setCreature(creatures[2]);
        maps.getMaps()[midX+2][midY-1].setCreature(creatures[3]);
        maps.getMaps()[midX-2][midY-1].setCreature(creatures[4]);
        maps.getMaps()[midX+3][midY].setCreature(creatures[5]);
        maps.getMaps()[midX-3][midY].setCreature(creatures[6]);
        maps.getMaps()[midX+2][midY+1].setCreature(creatures[7]);
        maps.getMaps()[midX-2][midY+1].setCreature(creatures[8]);
        maps.getMaps()[midX+1][midY+2].setCreature(creatures[9]);
        maps.getMaps()[midX-1][midY+2].setCreature(creatures[10]);
        maps.getMaps()[midX][midY+3].setCreature(creatures[11]);
    }
}
