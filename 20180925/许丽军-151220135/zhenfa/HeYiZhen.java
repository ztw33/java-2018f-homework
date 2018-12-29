package zhenfa;

import creature.Creature;
import space.BatterGround;

public class HeYiZhen implements ZhenFa {
    private int startX, startY;

    public HeYiZhen(int startX, int startY) {
        this.startX = startX;
        this.startY = startY;
    }

    @Override
    public void apply(BatterGround ground, Creature[] creatures) {
        for(int i=0;i<creatures.length;i++){
            int offsetY =  (i+1)/2;
            int offsetX =  offsetY * ((i % 2) * 2 - 1);
            creatures[i].moveTo(ground, startX+offsetX, startY+offsetY);
        }
    }

    @Override
    public void clear(BatterGround ground, Creature[] creatures) {
        for(int i=0;i<creatures.length;i++){
            int offsetY =  (i+1)/2;
            int offsetX =  offsetY * ((i % 2) * 2 - 1);
            creatures[i].leaveFrom(ground, startX+offsetX, startY+offsetY);
        }
    }
}
