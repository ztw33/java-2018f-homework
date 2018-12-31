package calabashBrothers.beings;

import calabashBrothers.Maps;
import calabashBrothers.beings.enums.CreatureType;

/**
 * @ Author     ：Young
 * @ Description：妖怪
 */
public class Monster extends Creature implements Fighting{
    public Monster() {
        super("小喽啰", CreatureType.MONSTER);
    }

    @Override
    public void selfIntroduction() {
        super.selfIntroduction();
        System.out.println("我是"+this.name);
    }

    @Override
    public void Fighting(Maps maps, int x, int y) {
        //TODO
    }
}
