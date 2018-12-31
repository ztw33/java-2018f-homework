package zhenfa;

import creature.Creature;
import space.BatterGround;

public class YanXingZhen implements ZhenFa {
    private int startX, startY;

    public YanXingZhen(int startX, int startY) {
        this.startX = startX;
        this.startY = startY;
    }

    @Override
    public void apply(BatterGround ground, Creature[] creatures) {

        for(int i=0;i<creatures.length;i++){
            //ground.placeCreature(startX-i, startY+i, creatures[i]);
            creatures[i].moveTo(ground, startX-i, startY+i);
        }
    }

    @Override
    public void clear(BatterGround ground, Creature[] creatures) {
        for(int i=0;i<creatures.length;i++){
            //ground.clearCreature(startX-i, startY+i);
            creatures[i].leaveFrom(ground, startX-i, startY+i);
        }
    }
}
