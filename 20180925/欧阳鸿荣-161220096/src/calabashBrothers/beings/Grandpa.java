package calabashBrothers.beings;

import calabashBrothers.Maps;
import calabashBrothers.beings.enums.CreatureType;

/**
 * @ Author     ：Young
 * @ Description：葫芦娃爷爷
 */
public class Grandpa extends Creature implements CheeringUp{

    public Grandpa() {
        super("葫芦娃爷爷", CreatureType.HUMAN_BEING);
    }

    @Override
    public void selfIntroduction() {
        super.selfIntroduction();
        System.out.println("我是"+this.name);
    }

    @Override
    public void CheeringUp(Maps maps, int x, int y) {
        if(maps.getMaps()[x][y].none()){
            maps.getMaps()[x][y].setCreature(this);
        }
    }
}
