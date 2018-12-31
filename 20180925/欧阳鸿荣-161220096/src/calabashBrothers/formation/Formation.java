package calabashBrothers.formation;

import calabashBrothers.Maps;
import calabashBrothers.beings.Creature;

/**
 * @ Author     ：Young
 * @ Description：${description}
 */
abstract public class Formation {
    protected int startX;   //阵法领导者的X坐标
    protected int startY;   //阵法领导者的Y坐标

    public Formation(int startX, int startY) {
        this.startX = startX;
        this.startY = startY;
    }

    abstract public void SetFormation(Maps maps, Creature[] creatures,int direction);

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }
}
