package calabashBrothers.beings;

import calabashBrothers.Maps;
import calabashBrothers.beings.enums.CreatureType;

/**
 * @ Author     ：Young
 * @ Description：蛇精
 */
public class Snake extends Monster implements CheeringUp{
    public Snake() {
        this.type=CreatureType.MONSTER_LEADER;
        this.name="蛇精";
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
